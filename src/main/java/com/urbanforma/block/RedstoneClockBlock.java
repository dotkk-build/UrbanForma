package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class RedstoneClockBlock extends Block {
   private final int intervalInTicks;
   public static final BooleanProperty POWERED = BooleanProperty.create("powered");
   public static final BooleanProperty STARTED = BooleanProperty.create("started");

   public RedstoneClockBlock(Properties properties, int intervalInTicks) {
      super(properties);
      this.intervalInTicks = intervalInTicks;
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(POWERED, false)).setValue(STARTED, false));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(POWERED, STARTED);
   }

   public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
      return state.getValue(STARTED) && state.getValue(POWERED) ? 15 : 0;
   }

   public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
      return this.getSignal(state, level, pos, direction);
   }

   public boolean isSignalSource(BlockState state) {
      return true;
   }

   public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
      if (!world.isClientSide && !(Boolean)state.getValue(STARTED)) {
         boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
         if (hasSignal) {
            BlockState newState = (BlockState)state.setValue(STARTED, true);
            world.setBlock(pos, newState, 3);
            world.scheduleTick(pos, this, 1);
         }
      }
   }

   public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
      if (!state.is(oldState.getBlock()) && !world.isClientSide && !(Boolean)state.getValue(STARTED)) {
         boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
         if (hasSignal) {
            BlockState newState = (BlockState)state.setValue(STARTED, true);
            world.setBlock(pos, newState, 3);
            world.scheduleTick(pos, this, 1);
         }
      }
   }

   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (!state.is(newState.getBlock()) && (Boolean)state.getValue(STARTED) && (Boolean)state.getValue(POWERED)) {
         world.updateNeighborsAt(pos, this);
      }
   }

   protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
      if ((Boolean)state.getValue(STARTED)) {
         this.updateSignalState(state, world, pos);
      }
   }

   private void updateSignalState(BlockState state, ServerLevel world, BlockPos pos) {
      long gameTime = world.getGameTime();
      long tickInInterval = gameTime % (long)this.intervalInTicks;
      boolean shouldBePowered = tickInInterval == 0L || tickInInterval == 1L;
      boolean isPowered = (Boolean)state.getValue(POWERED);
      if (shouldBePowered != isPowered) {
         BlockState newState = (BlockState)state.setValue(POWERED, shouldBePowered);
         world.setBlock(pos, newState, 3);
         world.updateNeighborsAt(pos, this);
      }

      world.scheduleTick(pos, this, 1);
   }
}
