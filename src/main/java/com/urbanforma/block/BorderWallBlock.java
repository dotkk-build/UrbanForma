package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

// 边墙方块类 - 支持四个方向的旋转
public class BorderWallBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    
    // 定义四个方向的半宽方块形状
    private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 0, 16, 16, 8);  // 北方向，方块在南半部分
    private static final VoxelShape SHAPE_EAST = Block.box(8, 0, 0, 16, 16, 16);    // 东方向，方块在西半部分
    private static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 8, 16, 16, 16);    // 南方向，方块在北半部分
    private static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 8, 16, 16);      // 西方向，方块在东半部分
    
    public BorderWallBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // 获取玩家面对的方向，然后顺时针旋转90度
        Direction playerDirection = context.getHorizontalDirection().getOpposite();
        Direction rotatedDirection = playerDirection.getClockWise();
        return this.defaultBlockState().setValue(FACING, rotatedDirection);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        
        switch (facing) {
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