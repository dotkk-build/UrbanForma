package com.urbanforma.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * 红石钟方块
 * 使用世界时同步，定期发出红石信号
 * 
 * 工作原理：
 * - 方块放置后，需要接收到第一次红石信号才会启动
 * - 启动后，每N个tick发出一次满格红石信号（持续2个tick）
 * - 所有相同类型的红石钟在同一世界时间发出信号
 * - 信号向上下左右前后六个方向发出
 * - 使用方块状态跟踪信号状态，并在状态改变时更新相邻方块
 */
public class RedstoneClockBlock extends Block {
    
    // 信号间隔（以tick为单位）
    private final int intervalInTicks;
    
    // 信号状态属性
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    
    // 启动状态属性（是否已接收到第一次红石信号）
    public static final BooleanProperty STARTED = BooleanProperty.create("started");
    
    /**
     * 构造函数
     * @param properties 方块属性
     * @param intervalInTicks 信号间隔（tick数）
     */
    public RedstoneClockBlock(Properties properties, int intervalInTicks) {
        super(properties);
        this.intervalInTicks = intervalInTicks;
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(POWERED, false)
            .setValue(STARTED, false));
    }
    
    /**
     * 创建方块状态定义
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, STARTED);
    }
    
    /**
     * 获取直接红石信号强度
     * 只有在启动后才返回信号强度
     */
    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(STARTED) && state.getValue(POWERED) ? 15 : 0;
    }
    
    /**
     * 获取红石信号强度
     */
    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getDirectSignal(state, level, pos, direction);
    }
    
    /**
     * 判断是否为红石信号源
     */
    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }
    
    /**
     * 相邻方块改变时，检测是否接收到红石信号
     */
    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!world.isClientSide && !state.getValue(STARTED)) {
            // 检查是否接收到红石信号
            boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
            if (hasSignal) {
                // 启动红石钟
                BlockState newState = state.setValue(STARTED, true);
                world.setBlock(pos, newState, 3);
                // 开始计时
                world.scheduleTick(pos, this, 1);
            }
        }
    }
    
    /**
     * 方块被放置时，检查是否应该启动
     */
    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!state.is(oldState.getBlock()) && !world.isClientSide && !state.getValue(STARTED)) {
            // 检查放置时是否接收到红石信号
            boolean hasSignal = world.getBestNeighborSignal(pos) > 0;
            if (hasSignal) {
                // 启动红石钟
                BlockState newState = state.setValue(STARTED, true);
                world.setBlock(pos, newState, 3);
                // 开始计时
                world.scheduleTick(pos, this, 1);
            }
        }
    }
    
    /**
     * 方块被移除时，通知相邻方块更新红石信号
     */
    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock()) && state.getValue(STARTED) && state.getValue(POWERED)) {
            world.updateNeighborsAt(pos, this);
        }
    }
    
    /**
     * 方块tick事件，更新信号状态
     */
    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(STARTED)) {
            updateSignalState(state, world, pos);
        }
    }
    
    /**
     * 更新信号状态
     * 根据世界时间判断是否应该发出信号，并在状态改变时更新相邻方块
     */
    private void updateSignalState(BlockState state, ServerLevel world, BlockPos pos) {
        long gameTime = world.getGameTime();
        long tickInInterval = gameTime % intervalInTicks;
        boolean shouldBePowered = (tickInInterval == 0 || tickInInterval == 1);
        boolean isPowered = state.getValue(POWERED);
        
        // 如果信号状态改变，更新方块状态并通知相邻方块
        if (shouldBePowered != isPowered) {
            BlockState newState = state.setValue(POWERED, shouldBePowered);
            world.setBlock(pos, newState, 3);
            world.updateNeighborsAt(pos, this);
        }
        
        // 调度下一个tick的更新
        world.scheduleTick(pos, this, 1);
    }
    
}
