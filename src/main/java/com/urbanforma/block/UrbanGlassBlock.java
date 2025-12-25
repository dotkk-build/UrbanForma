package com.urbanforma.block;

import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;

// 城市玻璃方块类 - 基于原版玻璃方块，可使用不同贴图
public class UrbanGlassBlock extends GlassBlock {
    
    public UrbanGlassBlock() {
        super(Properties.of()
                .strength(0.3f)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isRedstoneConductor((state, level, pos) -> false)
                .isSuffocating((state, level, pos) -> false)
                .isViewBlocking((state, level, pos) -> false)
                .isValidSpawn((state, level, pos, type) -> false)
                .forceSolidOn());
    }
}