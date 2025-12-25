package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 角方块 - 占据16x16平面空间中一个8x8的角落
 * 默认状态占据右上角（NORTH+EAST），支持四个方向
 */
public class CornerBlock extends HorizontalDirectionalBlock {
    
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    
    // 定义四个方向的碰撞箱（8x8x16）
    // 默认状态（NORTH）：占据右上角（x:8-16, z:0-8, y:0-16）
    protected static final VoxelShape SHAPE_NORTH = Block.box(8, 0, 0, 16, 16, 8);
    
    // EAST状态：占据右下角（x:8-16, z:8-16, y:0-16）
    protected static final VoxelShape SHAPE_EAST = Block.box(8, 0, 8, 16, 16, 16);
    
    // SOUTH状态：占据左下角（x:0-8, z:8-16, y:0-16）
    protected static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 8, 8, 16, 16);
    
    // WEST状态：占据左上角（x:0-8, z:0-8, y:0-16）
    protected static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 8, 16, 8);
    
    public CornerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // 根据玩家朝向自动设置方块方向
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return SHAPE_NORTH;
            case EAST:
                return SHAPE_EAST;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }
}
