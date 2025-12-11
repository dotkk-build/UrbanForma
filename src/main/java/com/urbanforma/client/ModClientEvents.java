package com.urbanforma.client;

import com.urbanforma.ModBlocks;
import com.urbanforma.UrbanForma;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = UrbanForma.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // 为所有玻璃方块设置透明渲染层
        event.enqueueWork(() -> {
            // 白色玻璃
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_GLASS_PANE.get(), RenderType.translucent());
            
            // 亮灰玻璃
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_1_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_1_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_2_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_2_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_3_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_3_GLASS_PANE.get(), RenderType.translucent());
            
            // 中灰玻璃
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_GRAY_1_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_GRAY_1_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_GRAY_2_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_GRAY_2_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_GRAY_3_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_GRAY_3_GLASS_PANE.get(), RenderType.translucent());
            
            // 暗灰玻璃
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_1_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_1_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_2_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_2_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_3_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_3_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_4_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_GRAY_4_GLASS_PANE.get(), RenderType.translucent());
            
            // 黑灰和黑色玻璃
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACKISH_GRAY_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACKISH_GRAY_GLASS_PANE.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_GLASS.get(), RenderType.translucent());
            net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_GLASS_PANE.get(), RenderType.translucent());
        });
    }
    
    @SubscribeEvent
    public static void registerRenderTypes(ModelEvent.RegisterAdditional event) {
        // 注册自定义渲染类型
    }
    
    @SubscribeEvent
    public static void modifyBakingResults(ModelEvent.ModifyBakingResult event) {
        // 修改模型烘焙结果
    }
}