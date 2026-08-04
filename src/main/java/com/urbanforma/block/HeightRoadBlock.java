package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeightRoadBlock extends Block {
   private final float height;

   public HeightRoadBlock(Properties properties, float height) {
      super(properties);
      this.height = height;
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      return Block.box(0.0, 0.0, 0.0, 16.0, (double)this.height, 16.0);
   }

   public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      return Block.box(0.0, 0.0, 0.0, 16.0, (double)this.height, 16.0);
   }

   public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      return Block.box(0.0, 0.0, 0.0, 16.0, (double)this.height, 16.0);
   }
}
