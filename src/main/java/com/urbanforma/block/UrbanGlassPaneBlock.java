package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.SoundType;

import javax.annotation.Nullable;

// 城市玻璃片类 - 基于细边墙，继承自玻璃方块，宽度为4像素，支持四个方向旋转
public class UrbanGlassPaneBlock extends GlassBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    
    // 定义四个方向的玻璃片形状，宽度为4像素
    private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 0, 16, 16, 4);  // 北方向，方块在南4像素部分
    private static final VoxelShape SHAPE_EAST = Block.box(12, 0, 0, 16, 16, 16);   // 东方向，方块在西4像素部分
    private static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 12, 16, 16, 16);   // 南方向，方块在北4像素部分
    private static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 4, 16, 16);     // 西方向，方块在东4像素部分
    
    public UrbanGlassPaneBlock() {
        super(Properties.of()
                .strength(0.3f)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isRedstoneConductor((state, level, pos) -> false)
                .isSuffocating((state, level, pos) -> false)
                .isViewBlocking((state, level, pos) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // 获取玩家面对的方向，然后旋转180度
        Direction playerDirection = context.getHorizontalDirection().getOpposite();
        Direction rotatedDirection = playerDirection.getCounterClockWise().getCounterClockWise();
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