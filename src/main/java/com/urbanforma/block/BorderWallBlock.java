package com.urbanforma.block;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BorderWallBlock extends Block {
   public static final DirectionProperty FACING = BlockStateProperties.FACING;
   private static final VoxelShape SHAPE_NORTH = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
   private static final VoxelShape SHAPE_EAST = Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);
   private static final VoxelShape SHAPE_SOUTH = Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
   private static final VoxelShape SHAPE_WEST = Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);

   public BorderWallBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING);
   }

   @Nullable
   public BlockState getStateForPlacement(BlockPlaceContext context) {
      Direction playerDirection = context.getHorizontalDirection().getOpposite();
      Direction rotatedDirection = playerDirection.getClockWise();
      return (BlockState)this.defaultBlockState().setValue(FACING, rotatedDirection);
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      Direction facing = (Direction)state.getValue(FACING);
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
