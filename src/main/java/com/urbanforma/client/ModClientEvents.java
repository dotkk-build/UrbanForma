package com.urbanforma.client;

import com.urbanforma.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.ModelEvent.ModifyBakingResult;
import net.neoforged.neoforge.client.event.ModelEvent.RegisterAdditional;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   modid = "urbanforma",
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class ModClientEvents {
   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.WHITE_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.WHITE_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_1_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_1_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_2_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_2_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_3_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_3_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.MEDIUM_GRAY_1_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.MEDIUM_GRAY_1_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.MEDIUM_GRAY_2_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.MEDIUM_GRAY_2_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.MEDIUM_GRAY_3_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.MEDIUM_GRAY_3_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_1_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_1_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_2_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_2_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_3_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_3_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_4_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.DARK_GRAY_4_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.BLACKISH_GRAY_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.BLACKISH_GRAY_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.BLACK_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.BLACK_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_LIGHT_1_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_LIGHT_1_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_LIGHT_2_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_LIGHT_2_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_TINTED_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_TINTED_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_1_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_1_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_1_TINTED_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_1_TINTED_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_2_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_2_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_2_TINTED_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_BLUE_2_TINTED_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.WHITE_TINTED_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.WHITE_TINTED_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_1_TINTED_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.LIGHT_GRAY_1_TINTED_GLASS_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.BLUE_GLASS_2.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.BLUE_GLASS_2_PANE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_GLASS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.CYAN_GLASS_PANE.get(), RenderType.translucent());
      });
   }

   @SubscribeEvent
   public static void registerRenderTypes(RegisterAdditional event) {
   }

   @SubscribeEvent
   public static void modifyBakingResults(ModifyBakingResult event) {
   }
}
