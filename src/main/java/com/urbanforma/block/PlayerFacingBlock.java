package com.urbanforma.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class PlayerFacingBlock extends Block {
   public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());

   public PlayerFacingBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      Direction direction = context.getClickedFace();
      if (direction == Direction.UP || direction == Direction.DOWN) {
         direction = context.getHorizontalDirection().getOpposite();
      }

      return (BlockState)this.defaultBlockState().setValue(FACING, direction);
   }
}
