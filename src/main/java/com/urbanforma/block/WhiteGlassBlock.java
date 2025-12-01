package com.urbanforma.block;

import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;

// 白色玻璃方块类 - 基于原版玻璃方块，使用白色贴图
public class WhiteGlassBlock extends GlassBlock {
    
    public WhiteGlassBlock() {
        super(Properties.of()
                .strength(0.3f)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isRedstoneConductor((state, level, pos) -> false)
                .isSuffocating((state, level, pos) -> false)
                .isViewBlocking((state, level, pos) -> false));
    }
}