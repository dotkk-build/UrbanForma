package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SmartTextureBlock extends Block {
   private static final Logger LOGGER = LogManager.getLogger();
   public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());
   public static final IntegerProperty TEXTURE_VARIANT = IntegerProperty.create("texture_variant", 0, 15);

   public SmartTextureBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(TEXTURE_VARIANT, 0));
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING, TEXTURE_VARIANT);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      Direction direction = context.getClickedFace();
      if (direction == Direction.UP || direction == Direction.DOWN) {
         direction = context.getHorizontalDirection().getOpposite();
      }

      return (BlockState)this.defaultBlockState().setValue(FACING, direction);
   }

   public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
      if (neighborState.getBlock() instanceof SmartTextureBlock) {
         LOGGER.debug("检测到相邻SmartTextureBlock变化");
         return this.calculateTextureVariant(state, level, currentPos);
      } else {
         return state;
      }
   }

   public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
      super.onPlace(state, level, pos, oldState, isMoving);
      if (!level.isClientSide()) {
         BlockState newState = this.calculateTextureVariant(state, level, pos);
         if (!newState.equals(state)) {
            level.setBlock(pos, newState, 3);
         }

         for (Direction dir : Direction.values()) {
            BlockPos adjacentPos = pos.relative(dir);
            BlockState adjacentState = level.getBlockState(adjacentPos);
            if (adjacentState.getBlock() instanceof SmartTextureBlock) {
               BlockState updatedAdjacentState = this.calculateTextureVariant(adjacentState, level, adjacentPos);
               if (!updatedAdjacentState.equals(adjacentState)) {
                  level.setBlock(adjacentPos, updatedAdjacentState, 3);
               }
            }
         }
      }
   }

   private BlockState calculateTextureVariant(BlockState state, LevelAccessor level, BlockPos pos) {
      int variant = 0;
      boolean north = level.getBlockState(pos.north()).getBlock() instanceof SmartTextureBlock;
      boolean south = level.getBlockState(pos.south()).getBlock() instanceof SmartTextureBlock;
      boolean east = level.getBlockState(pos.east()).getBlock() instanceof SmartTextureBlock;
      boolean west = level.getBlockState(pos.west()).getBlock() instanceof SmartTextureBlock;
      if (north) {
         variant |= 1;
      }

      if (south) {
         variant |= 2;
      }

      if (east) {
         variant |= 4;
      }

      if (west) {
         variant |= 8;
      }

      LOGGER.debug("计算贴图变体: pos={}, variant={}, connections=[north={}, south={}, east={}, west={}]", pos, variant, north, south, east, west);
      return (BlockState)state.setValue(TEXTURE_VARIANT, variant);
   }
}
