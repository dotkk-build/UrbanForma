package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 建筑板方块 - 天花板/地板
 * TYPE属性：
 * - up: 天花板（位于方块顶部，y:15-16）
 * - down: 地板（位于方块底部，y:0-1）
 */
public class CeilingFloorBlock extends Block {
    
    public static final BooleanProperty TYPE = BlockStateProperties.UP;
    
    // 定义两种状态的碰撞箱（16x16x1）
    // UP状态：位于顶部（x:0-16, y:15-16, z:0-16）
    protected static final VoxelShape SHAPE_UP = Block.box(0, 15, 0, 16, 16, 16);
    
    // DOWN状态：位于底部（x:0-16, y:0-1, z:0-16）
    protected static final VoxelShape SHAPE_DOWN = Block.box(0, 0, 0, 16, 1, 16);
    
    public CeilingFloorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TYPE, true));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // 根据点击的面决定放置方向
        // 点击下方（DOWN）时放置天花板（UP = true）
        // 点击上方（UP）时放置地板（UP = false）
        return this.defaultBlockState().setValue(TYPE, context.getClickedFace() == net.minecraft.core.Direction.DOWN);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        boolean isUp = state.getValue(TYPE);
        return isUp ? SHAPE_UP : SHAPE_DOWN;
    }
}
