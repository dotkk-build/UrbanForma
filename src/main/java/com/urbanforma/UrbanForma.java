package com.urbanforma;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(UrbanForma.MODID)
public class UrbanForma {
    public static final String MODID = "urbanforma";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UrbanForma() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("UrbanForma 模组加载完成 - 作者: Dotkk");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeTabs.URBANFORMA_BASE_TAB.getKey()) {
            // 白色系列方块
            event.accept(ModBlocks.WHITE_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_STAIRS_BUILDING_BLOCK);
            
            // 亮灰系列方块 (1-3)
            event.accept(ModBlocks.LIGHT_GRAY_1_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_1_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_1_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_1_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.LIGHT_GRAY_2_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_2_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_2_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_2_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.LIGHT_GRAY_3_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_3_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_3_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_3_STAIRS_BUILDING_BLOCK);
            
            // 中灰系列方块 (1-3)
            event.accept(ModBlocks.MEDIUM_GRAY_1_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_1_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_1_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_1_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.MEDIUM_GRAY_2_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_2_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_2_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_2_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.MEDIUM_GRAY_3_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_3_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_3_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.MEDIUM_GRAY_3_STAIRS_BUILDING_BLOCK);
            
            // 暗灰系列方块 (1-4)
            event.accept(ModBlocks.DARK_GRAY_1_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_1_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_1_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_1_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.DARK_GRAY_2_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_2_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_2_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_2_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.DARK_GRAY_3_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_3_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_3_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_3_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.DARK_GRAY_4_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_4_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_4_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_GRAY_4_STAIRS_BUILDING_BLOCK);
            
            // 黑灰系列方块
            event.accept(ModBlocks.BLACKISH_GRAY_BUILDING_BLOCK);
            event.accept(ModBlocks.BLACKISH_GRAY_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.BLACKISH_GRAY_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.BLACKISH_GRAY_STAIRS_BUILDING_BLOCK);
            
            // 黑色系列方块
            event.accept(ModBlocks.BLACK_BUILDING_BLOCK);
            event.accept(ModBlocks.BLACK_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.BLACK_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.BLACK_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色系列方块
            // 海松色系列
            event.accept(ModBlocks.SEA_PINE_BUILDING_BLOCK);
            event.accept(ModBlocks.SEA_PINE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.SEA_PINE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.SEA_PINE_STAIRS_BUILDING_BLOCK);
            
            // 山鸠色系列
            event.accept(ModBlocks.MOUNTAIN_DOVE_BUILDING_BLOCK);
            event.accept(ModBlocks.MOUNTAIN_DOVE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.MOUNTAIN_DOVE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.MOUNTAIN_DOVE_STAIRS_BUILDING_BLOCK);
            
            // 利休鼠系列
            event.accept(ModBlocks.RIKYU_GRAY_BUILDING_BLOCK);
            event.accept(ModBlocks.RIKYU_GRAY_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.RIKYU_GRAY_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.RIKYU_GRAY_STAIRS_BUILDING_BLOCK);
            
            // 白緑系列
            event.accept(ModBlocks.WHITE_GREEN_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_GREEN_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_GREEN_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_GREEN_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色方块系列（简写ID）
            // 若緑系列
            event.accept(ModBlocks.YOUNG_GREEN_BUILDING_BLOCK);
            event.accept(ModBlocks.YOUNG_GREEN_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.YOUNG_GREEN_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.YOUNG_GREEN_STAIRS_BUILDING_BLOCK);
            
            // 绿系列
            event.accept(ModBlocks.GREEN_BUILDING_BLOCK);
            event.accept(ModBlocks.GREEN_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.GREEN_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.GREEN_STAIRS_BUILDING_BLOCK);
            
            // 青緑系列
            event.accept(ModBlocks.BLUE_GREEN_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_GREEN_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_GREEN_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_GREEN_STAIRS_BUILDING_BLOCK);
            
            // 抹茶色系列
            event.accept(ModBlocks.MATCHA_BUILDING_BLOCK);
            event.accept(ModBlocks.MATCHA_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.MATCHA_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.MATCHA_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色系列方块
            // 煎茶色系列
            event.accept(ModBlocks.SENCHA_BUILDING_BLOCK);
            event.accept(ModBlocks.SENCHA_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.SENCHA_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.SENCHA_STAIRS_BUILDING_BLOCK);
            
            // 铁灰色系列
            event.accept(ModBlocks.IRON_GRAY_BUILDING_BLOCK);
            event.accept(ModBlocks.IRON_GRAY_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.IRON_GRAY_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.IRON_GRAY_STAIRS_BUILDING_BLOCK);
            
            // 水色系列
            event.accept(ModBlocks.WATER_BUILDING_BLOCK);
            event.accept(ModBlocks.WATER_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WATER_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WATER_STAIRS_BUILDING_BLOCK);
            
            // 白蓝色系列
            event.accept(ModBlocks.WHITE_BLUE_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_BLUE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_BLUE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WHITE_BLUE_STAIRS_BUILDING_BLOCK);
            
            // 新增8个颜色方块系列（简写ID）
            event.accept(ModBlocks.GRAY_NANDO_BUILDING_BLOCK);
            event.accept(ModBlocks.GRAY_NANDO_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.GRAY_NANDO_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.GRAY_NANDO_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.SKY_BUILDING_BLOCK);
            event.accept(ModBlocks.SKY_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.SKY_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.SKY_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.BLUE_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.LIGHT_BLUE_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.BLUE_COLOR_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_COLOR_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_COLOR_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_COLOR_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.DARK_BLUE_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_BLUE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_BLUE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.DARK_BLUE_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.FLOWER_BUILDING_BLOCK);
            event.accept(ModBlocks.FLOWER_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.FLOWER_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.FLOWER_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.NAVY_VIOLET_BUILDING_BLOCK);
            event.accept(ModBlocks.NAVY_VIOLET_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.NAVY_VIOLET_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.NAVY_VIOLET_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色方块系列
            event.accept(ModBlocks.ULTRAMARINE_BUILDING_BLOCK);
            event.accept(ModBlocks.ULTRAMARINE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.ULTRAMARINE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.ULTRAMARINE_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.WISTERIA_GRAY_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GRAY_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GRAY_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GRAY_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.WISTERIA_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.WISTERIA_PURPLE_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_PURPLE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_PURPLE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_PURPLE_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色方块系列
            event.accept(ModBlocks.ULTRAMARINE_BUILDING_BLOCK);
            event.accept(ModBlocks.ULTRAMARINE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.ULTRAMARINE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.ULTRAMARINE_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.WISTERIA_GRAY_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GRAY_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GRAY_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GRAY_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.WISTERIA_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.WISTERIA_PURPLE_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_PURPLE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_PURPLE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.WISTERIA_PURPLE_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色方块系列（简写ID）
            // 鸠羽色系列
            event.accept(ModBlocks.DOVE_BUILDING_BLOCK);
            event.accept(ModBlocks.DOVE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.DOVE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.DOVE_STAIRS_BUILDING_BLOCK);
            
            // 青紫系列
            event.accept(ModBlocks.BLUE_PURPLE_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_PURPLE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_PURPLE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.BLUE_PURPLE_STAIRS_BUILDING_BLOCK);
            
            // 江戸紫系列
            event.accept(ModBlocks.EDO_PURPLE_BUILDING_BLOCK);
            event.accept(ModBlocks.EDO_PURPLE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.EDO_PURPLE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.EDO_PURPLE_STAIRS_BUILDING_BLOCK);
            
            // 紫系列
            event.accept(ModBlocks.PURPLE_BUILDING_BLOCK);
            event.accept(ModBlocks.PURPLE_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.PURPLE_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.PURPLE_STAIRS_BUILDING_BLOCK);
            
            // 新增4个颜色方块系列（菖蒲色、葡萄、葡鼠、浓色）
            event.accept(ModBlocks.CB_BUILDING_BLOCK);
            event.accept(ModBlocks.CB_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.CB_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.CB_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.PT_BUILDING_BLOCK);
            event.accept(ModBlocks.PT_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.PT_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.PT_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.PS_BUILDING_BLOCK);
            event.accept(ModBlocks.PS_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.PS_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.PS_STAIRS_BUILDING_BLOCK);
            
            event.accept(ModBlocks.NS_BUILDING_BLOCK);
            event.accept(ModBlocks.NS_GLOWING_BUILDING_BLOCK);
            event.accept(ModBlocks.NS_SLAB_BUILDING_BLOCK);
            event.accept(ModBlocks.NS_STAIRS_BUILDING_BLOCK);

        } else if (event.getTabKey() == ModCreativeTabs.URBANFORMA_ROAD_TAB.getKey()) {
            // 道路系列方块
            event.accept(ModBlocks.ROAD_A_GRAY);
            event.accept(ModBlocks.ROAD_A_GRAY_GLOWING);
            event.accept(ModBlocks.ROAD_A_GRAY_SLAB);
            event.accept(ModBlocks.ROAD_A_LIGHT_GRAY);
            event.accept(ModBlocks.ROAD_A_LIGHT_GRAY_GLOWING);
            event.accept(ModBlocks.ROAD_A_LIGHT_GRAY_SLAB);
            event.accept(ModBlocks.ROAD_A_WHITE);
            event.accept(ModBlocks.ROAD_A_WHITE_GLOWING);
            event.accept(ModBlocks.ROAD_A_WHITE_SLAB);
            event.accept(ModBlocks.ROAD_A_WHITE_LINE);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_COMPENSATION);
            event.accept(ModBlocks.ROAD_A_WHITE_ZEBRA);
            event.accept(ModBlocks.ROAD_A_WHITE_CROSS);
            event.accept(ModBlocks.ROAD_A_WHITE_T_LINE);
            event.accept(ModBlocks.ROAD_A_WHITE_CORNER);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_LINE_END_1);
            event.accept(ModBlocks.ROAD_A_WHITE_LINE_END_2);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_CORNER_LINE);
            event.accept(ModBlocks.ROAD_A_WHITE_CORNER_LINE_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_THICK_BORDER);
            event.accept(ModBlocks.ROAD_A_WHITE_BORDER);
            event.accept(ModBlocks.ROAD_A_WHITE_THIN_BORDER);
            
            // 道路白小弯和道路白中弯系列
            event.accept(ModBlocks.ROAD_A_WHITE_SMALL_CURVE);
            event.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_1);
            event.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_1_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_2);
            event.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_2_REVERSE);
            
            // 道路白45度弯系列
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_1);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_1_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_2);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_2_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_3);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_3_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_4);
            event.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_4_REVERSE);
            
            // 道路白大弯系列
            event.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_1);
            event.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_1_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_2);
            event.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_2_REVERSE);
            event.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_3);
            
            // 灰色道路高系列方块 (高7到高1)
            event.accept(ModBlocks.ROAD_GRAY_H7);
            event.accept(ModBlocks.ROAD_GRAY_H6);
            event.accept(ModBlocks.ROAD_GRAY_H5);
            event.accept(ModBlocks.ROAD_GRAY_H4);
            event.accept(ModBlocks.ROAD_GRAY_H3);
            event.accept(ModBlocks.ROAD_GRAY_H2);
            event.accept(ModBlocks.ROAD_GRAY_H1);
            
            // 道路白中线高系列方块 (高7到高1)
            event.accept(ModBlocks.ROAD_WHITE_LINE_H7);
            event.accept(ModBlocks.ROAD_WHITE_LINE_H6);
            event.accept(ModBlocks.ROAD_WHITE_LINE_H5);
            event.accept(ModBlocks.ROAD_WHITE_LINE_H4);
            event.accept(ModBlocks.ROAD_WHITE_LINE_H3);
            event.accept(ModBlocks.ROAD_WHITE_LINE_H2);
            event.accept(ModBlocks.ROAD_WHITE_LINE_H1);
            
            // 新增道路方块
            event.accept(ModBlocks.ROAD_DOUBLE_WHITE_LINE);
            event.accept(ModBlocks.ROAD_WHITE_DASHED_LINE);
            event.accept(ModBlocks.ROAD_WHITE_DECELERATION_LINE);
            event.accept(ModBlocks.ROAD_WHITE_DECELERATION_LINE_REVERSE);
            event.accept(ModBlocks.ROAD_YELLOW_DECELERATION_CONNECTION);
            event.accept(ModBlocks.ROAD_YELLOW_CENTER_LINE);
            event.accept(ModBlocks.ROAD_DOUBLE_YELLOW_LINE);
            event.accept(ModBlocks.ROAD_YELLOW_DASHED_LINE);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}