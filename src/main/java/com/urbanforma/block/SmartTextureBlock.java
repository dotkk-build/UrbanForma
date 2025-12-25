package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SmartTextureBlock extends Block {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());
    public static final IntegerProperty TEXTURE_VARIANT = IntegerProperty.create("texture_variant", 0, 15);
    
    public SmartTextureBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(FACING, Direction.NORTH)
            .setValue(TEXTURE_VARIANT, 0));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TEXTURE_VARIANT);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        
        // 如果玩家点击的是方块的上下面，则使用玩家的水平朝向
        if (direction == Direction.UP || direction == Direction.DOWN) {
            direction = context.getHorizontalDirection().getOpposite();
        }
        
        return this.defaultBlockState().setValue(FACING, direction);
    }
    
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        // 检测相邻方块变化，重新计算贴图效果
        if (neighborState.getBlock() instanceof SmartTextureBlock) {
            LOGGER.debug("检测到相邻SmartTextureBlock变化");
            return calculateTextureVariant(state, level, currentPos);
        }
        return state;
    }
    
    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        
        // 当方块被放置时，重新计算贴图变体
        if (!level.isClientSide()) {
            BlockState newState = calculateTextureVariant(state, level, pos);
            if (!newState.equals(state)) {
                level.setBlock(pos, newState, 3);
            }
            
            // 通知相邻方块更新
            for (Direction dir : Direction.values()) {
                BlockPos adjacentPos = pos.relative(dir);
                BlockState adjacentState = level.getBlockState(adjacentPos);
                
                if (adjacentState.getBlock() instanceof SmartTextureBlock) {
                    BlockState updatedAdjacentState = calculateTextureVariant(adjacentState, level, adjacentPos);
                    if (!updatedAdjacentState.equals(adjacentState)) {
                        level.setBlock(adjacentPos, updatedAdjacentState, 3);
                    }
                }
            }
        }
    }
    
    private BlockState calculateTextureVariant(BlockState state, LevelAccessor level, BlockPos pos) {
        // 计算连接纹理的变体编号 (0-15)
        int variant = 0;
        
        // 检查四个主要方向的相邻方块
        boolean north = level.getBlockState(pos.north()).getBlock() instanceof SmartTextureBlock;
        boolean south = level.getBlockState(pos.south()).getBlock() instanceof SmartTextureBlock;
        boolean east = level.getBlockState(pos.east()).getBlock() instanceof SmartTextureBlock;
        boolean west = level.getBlockState(pos.west()).getBlock() instanceof SmartTextureBlock;
        
        // 使用位运算计算变体编号
        if (north) variant |= 1;  // 北边有连接
        if (south) variant |= 2;  // 南边有连接
        if (east) variant |= 4;   // 东边有连接
        if (west) variant |= 8;   // 西边有连接
        
        LOGGER.debug("计算贴图变体: pos={}, variant={}, connections=[north={}, south={}, east={}, west={}]", 
            pos, variant, north, south, east, west);
        
        return state.setValue(TEXTURE_VARIANT, variant);
    }
}