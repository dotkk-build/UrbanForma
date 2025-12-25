package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 防撞灯方块（通用类）
 * 6种放置形态（上下左右前后），红石信号控制发光
 *
 * 工作原理：
 * - 方块可以朝向6个方向（上、下、北、南、东、西）
 * - 有红石信号时发光，发光持续时间为10 tick
 * - 10 tick后，如果没有新的红石信号，灯停止发光
 * - 碰撞箱为4x4x2像素（0.25 x 0.25 x 0.125）
 * - 金属材质
 */
public class AntiCollisionLightBlock extends Block {
    
    // 方向属性（6个方向）
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());
    
    // 发光状态属性
    public static final BooleanProperty LIT = BooleanProperty.create("lit");
    
    // 发光持续时间（tick）
    private static final int GLOW_DURATION_TICKS = 40;
    
    // 碰撞箱形状（4x4x2像素 = 0.25 x 0.25 x 0.125）
    private static final VoxelShape SHAPE_DOWN = box(6, 0, 6, 10, 2, 10);
    private static final VoxelShape SHAPE_UP = box(6, 14, 6, 10, 16, 10);
    private static final VoxelShape SHAPE_NORTH = box(6, 6, 0, 10, 10, 2);
    private static final VoxelShape SHAPE_SOUTH = box(6, 6, 14, 10, 10, 16);
    private static final VoxelShape SHAPE_WEST = box(0, 6, 6, 2, 10, 10);
    private static final VoxelShape SHAPE_EAST = box(14, 6, 6, 16, 10, 10);
    
    /**
     * 构造函数
     * @param properties 方块属性
     */
    public AntiCollisionLightBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(FACING, Direction.UP)
            .setValue(LIT, false));
    }
    
    /**
     * 创建方块状态定义
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
    
    /**
     * 获取碰撞箱形状
     */
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN -> SHAPE_DOWN;
            case UP -> SHAPE_UP;
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
        };
    }
    
    /**
     * 获取发光等级
     * 当LIT为true时返回15（最亮），否则返回0
     */
    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LIT) ? 15 : 0;
    }
    
    /**
     * 相邻方块改变时，检测红石信号变化并更新LIT状态
     * 当接收到红石信号时，开始发光并调度10 tick后的检查
     */
    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!world.isClientSide) {
            boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
            boolean isLit = state.getValue(LIT);
            
            if (hasSignal && !isLit) {
                // 接收到红石信号，开始发光
                BlockState newState = state.setValue(LIT, true);
                world.setBlock(pos, newState, 3);
                // 调度10 tick后的检查
                world.scheduleTick(pos, this, GLOW_DURATION_TICKS);
            }
        }
    }
    
    /**
     * 方块放置时确定朝向
     * 根据玩家点击的方块面来确定FACING属性：
     * - 点击地面（UP）时，灯朝下（FACING = DOWN）
     * - 点击天花板（DOWN）时，灯朝上（FACING = UP）
     * - 点击北面时，灯朝南（FACING = SOUTH）
     * - 点击南面时，灯朝北（FACING = NORTH）
     * - 点击东面时，灯朝西（FACING = WEST）
     * - 点击西面时，灯朝东（FACING = EAST）
     */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        Direction facing = switch (clickedFace) {
            case UP -> Direction.DOWN;
            case DOWN -> Direction.UP;
            case NORTH -> Direction.SOUTH;
            case SOUTH -> Direction.NORTH;
            case EAST -> Direction.WEST;
            case WEST -> Direction.EAST;
        };
        return this.defaultBlockState().setValue(FACING, facing);
    }
    
    /**
     * 方块被放置时，检测红石信号
     */
    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!state.is(oldState.getBlock()) && !world.isClientSide) {
            boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
            if (hasSignal && !state.getValue(LIT)) {
                // 接收到红石信号，开始发光
                BlockState newState = state.setValue(LIT, true);
                world.setBlock(pos, newState, 3);
                // 调度10 tick后的检查
                world.scheduleTick(pos, this, GLOW_DURATION_TICKS);
            }
        }
    }
    
    /**
     * 检查方块是否可以支撑
     * 防撞灯可以独立存在，不需要支撑
     */
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }
    
    /**
     * 方块放置时更新状态
     * 防撞灯不需要支撑，相邻方块改变时不会消失
     */
    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
    
    /**
     * 方块tick事件，检查发光持续时间
     * 当tick到期时，检查是否还有红石信号，如果没有则停止发光
     */
    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            // 检查是否还有红石信号
            boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
            if (!hasSignal) {
                // 没有红石信号，停止发光
                BlockState newState = state.setValue(LIT, false);
                world.setBlock(pos, newState, 3);
            }
        }
    }
}
