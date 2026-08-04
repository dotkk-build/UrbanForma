package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CeilingFloorBlock extends Block {
   public static final BooleanProperty TYPE = BlockStateProperties.UP;
   protected static final VoxelShape SHAPE_UP = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
   protected static final VoxelShape SHAPE_DOWN = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

   public CeilingFloorBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(TYPE, true));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(TYPE);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)this.defaultBlockState().setValue(TYPE, context.getClickedFace() == Direction.DOWN);
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      boolean isUp = (Boolean)state.getValue(TYPE);
      return isUp ? SHAPE_UP : SHAPE_DOWN;
   }
}
