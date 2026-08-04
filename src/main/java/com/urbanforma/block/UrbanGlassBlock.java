package com.urbanforma.block;

import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class UrbanGlassBlock extends TransparentBlock {
   public UrbanGlassBlock() {
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
}
