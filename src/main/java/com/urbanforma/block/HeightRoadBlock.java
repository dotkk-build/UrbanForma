package com.urbanforma.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;

public class HeightRoadBlock extends Block {
    private final float height;
    
    public HeightRoadBlock(Properties properties, float height) {
        super(properties);
        this.height = height;
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // 根据高度设置碰撞箱，高度以像素为单位（1像素 = 1/16方块）
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, height, 16.0D);
    }
    
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // 碰撞箱与视觉形状一致
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, height, 16.0D);
    }
    
    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        // 遮挡形状也与视觉一致
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, height, 16.0D);
    }
}