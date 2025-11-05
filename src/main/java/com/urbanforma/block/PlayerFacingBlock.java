package com.urbanforma.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class PlayerFacingBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());
    
    public PlayerFacingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // 获取玩家放置方块时的朝向，包括上下方向
        Direction direction = context.getClickedFace();
        
        // 如果玩家点击的是方块的上下面，则使用玩家的水平朝向
        if (direction == Direction.UP || direction == Direction.DOWN) {
            direction = context.getHorizontalDirection().getOpposite();
        }
        
        return this.defaultBlockState().setValue(FACING, direction);
    }
}