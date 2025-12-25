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

// Urban tinted glass pane block - Based on thin border wall, inherits from glass block, width is 4 pixels, supports four-direction rotation, with light-blocking properties
public class UrbanTintedGlassPaneBlock extends GlassBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    
    // Define four-direction glass pane shapes, width is 4 pixels
    private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 0, 16, 16, 4);  // North direction, block is in south 4 pixels
    private static final VoxelShape SHAPE_EAST = Block.box(12, 0, 0, 16, 16, 16);   // East direction, block is in west 4 pixels
    private static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 12, 16, 16, 16);   // South direction, block is in north 4 pixels
    private static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 4, 16, 16);     // West direction, block is in east 4 pixels
    
    public UrbanTintedGlassPaneBlock() {
        super(Properties.of()
                .strength(0.3f)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isRedstoneConductor((state, level, pos) -> false)
                .isSuffocating((state, level, pos) -> false)
                .isViewBlocking((state, level, pos) -> false)
                .isValidSpawn((state, level, pos, type) -> false)
                .forceSolidOn()
                .forceSolidOn());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Get the direction the player is facing, then rotate 180 degrees
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
    
    // Add light blocking - Completely blocks light
    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 15;
    }
}