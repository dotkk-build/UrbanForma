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

/**
 * 粗竖半砖方块类 - 支持两个方向的旋转（0度和90度）
 * 
 * 由于方块是左右对称的，只需要支持两个方向：
 * - NORTH (0度): 半砖沿X轴方向延伸（南北方向）
 * - EAST (90度): 半砖沿Z轴方向延伸（东西方向）
 */
public class VerticalSlabBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    
    // 定义两个方向的半砖形状（10像素宽，16像素高，16像素长）
    // 根据模型：起始位置 [3, 0, 0]，结束位置 [13, 16, 16]，宽度10像素
    private static final VoxelShape SHAPE_NORTH = Block.box(3, 0, 0, 13, 16, 16);  // 北方向，半砖沿X轴方向延伸（宽度10）
    private static final VoxelShape SHAPE_EAST = Block.box(0, 0, 3, 16, 16, 13);  // 东方向，半砖沿Z轴方向延伸（深度10）
    
    public VerticalSlabBlock(Properties properties) {
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
        // 获取玩家面对的方向
        Direction playerDirection = context.getHorizontalDirection().getOpposite();
        
        // 根据玩家朝向设置半砖方向
        // 当玩家从北面或南面放置时，方向为 NORTH（0度）
        // 当玩家从东面或西面放置时，方向为 EAST（90度）
        switch (playerDirection) {
            case NORTH:
            case SOUTH:
                return this.defaultBlockState().setValue(FACING, Direction.NORTH);
            case EAST:
            case WEST:
                return this.defaultBlockState().setValue(FACING, Direction.EAST);
            default:
                return this.defaultBlockState().setValue(FACING, Direction.NORTH);
        }
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        
        switch (facing) {
            case NORTH:
                return SHAPE_NORTH;
            case EAST:
                return SHAPE_EAST;
            default:
                return SHAPE_NORTH;
        }
    }
}
