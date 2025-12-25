package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

// 城市遮光玻璃方块类 - 基于原版玻璃方块，添加遮光特性
public class UrbanTintedGlassBlock extends GlassBlock {
    
    public UrbanTintedGlassBlock() {
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
    
    /**
     * 重写此方法以设置光线阻挡等级
     * 返回15表示完全阻挡光线（最高等级）
     */
    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 15;
    }
}