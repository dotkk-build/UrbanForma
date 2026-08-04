package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AntiCollisionLightBlock extends Block {
   public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());
   public static final BooleanProperty LIT = BooleanProperty.create("lit");
   private static final int GLOW_DURATION_TICKS = 40;
   private static final VoxelShape SHAPE_DOWN = Block.box(6.0, 0.0, 6.0, 10.0, 2.0, 10.0);
   private static final VoxelShape SHAPE_UP = Block.box(6.0, 14.0, 6.0, 10.0, 16.0, 10.0);
   private static final VoxelShape SHAPE_NORTH = Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 2.0);
   private static final VoxelShape SHAPE_SOUTH = Block.box(6.0, 6.0, 14.0, 10.0, 10.0, 16.0);
   private static final VoxelShape SHAPE_WEST = Block.box(0.0, 6.0, 6.0, 2.0, 10.0, 10.0);
   private static final VoxelShape SHAPE_EAST = Block.box(14.0, 6.0, 6.0, 16.0, 10.0, 10.0);

   public AntiCollisionLightBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.UP)).setValue(LIT, false));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING, LIT);
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      return switch ((Direction)state.getValue(FACING)) {
         case DOWN -> SHAPE_DOWN;
         case UP -> SHAPE_UP;
         case NORTH -> SHAPE_NORTH;
         case SOUTH -> SHAPE_SOUTH;
         case WEST -> SHAPE_WEST;
         case EAST -> SHAPE_EAST;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
      return state.getValue(LIT) ? 15 : 0;
   }

   public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
      if (!world.isClientSide) {
         boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
         boolean isLit = (Boolean)state.getValue(LIT);
         if (hasSignal && !isLit) {
            BlockState newState = (BlockState)state.setValue(LIT, true);
            world.setBlock(pos, newState, 3);
            world.scheduleTick(pos, this, 40);
         }
      }
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      Direction clickedFace = context.getClickedFace();

      Direction facing = switch (clickedFace) {
         case DOWN -> Direction.UP;
         case UP -> Direction.DOWN;
         case NORTH -> Direction.SOUTH;
         case SOUTH -> Direction.NORTH;
         case WEST -> Direction.EAST;
         case EAST -> Direction.WEST;
         default -> throw new IncompatibleClassChangeError();
      };
      return (BlockState)this.defaultBlockState().setValue(FACING, facing);
   }

   public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
      if (!state.is(oldState.getBlock()) && !world.isClientSide) {
         boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
         if (hasSignal && !(Boolean)state.getValue(LIT)) {
            BlockState newState = (BlockState)state.setValue(LIT, true);
            world.setBlock(pos, newState, 3);
            world.scheduleTick(pos, this, 40);
         }
      }
   }

   public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
      return true;
   }

   public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
      return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
   }

   protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
      if ((Boolean)state.getValue(LIT)) {
         boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
         if (!hasSignal) {
            BlockState newState = (BlockState)state.setValue(LIT, false);
            world.setBlock(pos, newState, 3);
         }
      }
   }
}
