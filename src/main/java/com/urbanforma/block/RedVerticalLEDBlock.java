package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RedVerticalLEDBlock extends Block {
   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
   protected static final VoxelShape SHAPE_NORTH = Block.box(6.0, 0.0, 15.0, 10.0, 16.0, 16.0);
   protected static final VoxelShape SHAPE_EAST = Block.box(0.0, 0.0, 6.0, 1.0, 16.0, 10.0);
   protected static final VoxelShape SHAPE_SOUTH = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 1.0);
   protected static final VoxelShape SHAPE_WEST = Block.box(15.0, 0.0, 6.0, 16.0, 16.0, 10.0);

   public RedVerticalLEDBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.SOUTH));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      Direction direction = (Direction)state.getValue(FACING);
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
            return SHAPE_SOUTH;
      }
   }
}
