package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class UrbanTintedGlassBlock extends TransparentBlock {
   public UrbanTintedGlassBlock() {
      super(
         Properties.of()
            .strength(0.3F)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .isRedstoneConductor((state, level, pos) -> false)
            .isSuffocating((state, level, pos) -> false)
            .isViewBlocking((state, level, pos) -> false)
            .hasPostProcess((state, level, pos) -> false)
            .forceSolidOff()
      );
   }

   public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
      return 15;
   }
}
