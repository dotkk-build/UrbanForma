package com.urbanforma;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UrbanForma.MODID);

    // 都市构方基础物品栏 (a_1)
    public static final RegistryObject<CreativeModeTab> URBANFORMA_BASE_TAB = CREATIVE_MODE_TABS.register("a_1_urbanforma_base",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.a_1_urbanforma_base"))
            .icon(() -> new ItemStack(ModBlocks.WHITE_BUILDING_BLOCK.get()))
            .displayItems((parameters, output) -> {
                // 白色系列方块
                output.accept(ModBlocks.WHITE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHITE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHITE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHITE_STAIRS_BUILDING_BLOCK.get());
                
                // 亮灰系列方块 (1-3)
                output.accept(ModBlocks.LIGHT_GRAY_1_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_1_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_1_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_1_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.LIGHT_GRAY_2_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_2_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_2_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_2_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.LIGHT_GRAY_3_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_3_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_3_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_GRAY_3_STAIRS_BUILDING_BLOCK.get());
                
                // 中灰系列方块 (1-3)
                output.accept(ModBlocks.MEDIUM_GRAY_1_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_1_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_1_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_1_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.MEDIUM_GRAY_2_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_2_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_2_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_2_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.MEDIUM_GRAY_3_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_3_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_3_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MEDIUM_GRAY_3_STAIRS_BUILDING_BLOCK.get());
                
                // 暗灰系列方块 (1-4)
                output.accept(ModBlocks.DARK_GRAY_1_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_1_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_1_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_1_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.DARK_GRAY_2_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_2_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_2_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_2_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.DARK_GRAY_3_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_3_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_3_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_3_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.DARK_GRAY_4_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_4_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_4_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DARK_GRAY_4_STAIRS_BUILDING_BLOCK.get());
                
                // 黑灰系列方块
                output.accept(ModBlocks.BLACKISH_GRAY_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLACKISH_GRAY_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLACKISH_GRAY_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLACKISH_GRAY_STAIRS_BUILDING_BLOCK.get());
                
                // 黑色系列方块
                output.accept(ModBlocks.BLACK_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLACK_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLACK_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLACK_STAIRS_BUILDING_BLOCK.get());
                
                // 新增72个颜色方块系列 - 第一批4个颜色
                output.accept(ModBlocks.N_HB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.N_HB_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.N_HB_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.N_HB_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.XY_BUILDING_BLOCK.get());
                output.accept(ModBlocks.XY_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.XY_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.XY_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.SC_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SC_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SC_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SC_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.YH_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YH_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YH_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YH_STAIRS_BUILDING_BLOCK.get());
                
                // 新增72个颜色方块系列 - 第二批4个颜色
                output.accept(ModBlocks.TB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.TB_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.TB_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.TB_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.SH_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SH_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SH_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SH_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.BK_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BK_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BK_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BK_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.T_BUILDING_BLOCK.get());
                output.accept(ModBlocks.T_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.T_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.T_STAIRS_BUILDING_BLOCK.get());
                
                // 新增72个颜色方块系列 - 第三批4个颜色
                output.accept(ModBlocks.BRM_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BRM_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BRM_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BRM_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.AZ_BUILDING_BLOCK.get());
                output.accept(ModBlocks.AZ_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.AZ_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.AZ_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.PN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.QW_BUILDING_BLOCK.get());
                output.accept(ModBlocks.QW_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.QW_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.QW_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列
                output.accept(ModBlocks.RED_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.RED_VERMILLION_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_VERMILLION_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_VERMILLION_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_VERMILLION_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.SCARLET_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SCARLET_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SCARLET_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SCARLET_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.DEEP_SCARLET_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DEEP_SCARLET_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DEEP_SCARLET_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DEEP_SCARLET_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列
                output.accept(ModBlocks.CHESTNUT_BUILDING_BLOCK.get());
                output.accept(ModBlocks.CHESTNUT_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.CHESTNUT_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.CHESTNUT_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.ROUGE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.ROUGE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.ROUGE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.ROUGE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.MODERN_RED_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MODERN_RED_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MODERN_RED_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MODERN_RED_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.GOLDEN_RED_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GOLDEN_RED_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GOLDEN_RED_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GOLDEN_RED_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.RED_ORANGE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_ORANGE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_ORANGE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_ORANGE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.RED_VERMILLION_2_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_VERMILLION_2_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_VERMILLION_2_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_VERMILLION_2_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.DAWN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DAWN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DAWN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DAWN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.BURNT_TEA_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BURNT_TEA_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BURNT_TEA_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BURNT_TEA_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.PLUM_DYE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PLUM_DYE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PLUM_DYE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PLUM_DYE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.RED_WHITE_OAK_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_WHITE_OAK_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_WHITE_OAK_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RED_WHITE_OAK_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.SKIN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SKIN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SKIN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SKIN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.WHEAT_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHEAT_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHEAT_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHEAT_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.GOLD_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GOLD_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GOLD_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GOLD_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.LIGHT_YELLOW_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_YELLOW_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_YELLOW_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.LIGHT_YELLOW_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.PHELLODENDRON_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PHELLODENDRON_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PHELLODENDRON_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PHELLODENDRON_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.TURMERIC_BUILDING_BLOCK.get());
                output.accept(ModBlocks.TURMERIC_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.TURMERIC_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.TURMERIC_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.YELLOW_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YELLOW_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YELLOW_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YELLOW_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.GREEN_YELLOW_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GREEN_YELLOW_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GREEN_YELLOW_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GREEN_YELLOW_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.NATIONAL_DEFENSE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.NATIONAL_DEFENSE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.NATIONAL_DEFENSE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.NATIONAL_DEFENSE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.BLUE_VERMILLION_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_VERMILLION_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_VERMILLION_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_VERMILLION_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.SEA_PINE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SEA_PINE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SEA_PINE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.SEA_PINE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.MOUNTAIN_DOVE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MOUNTAIN_DOVE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MOUNTAIN_DOVE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MOUNTAIN_DOVE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.RIKYU_GRAY_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RIKYU_GRAY_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RIKYU_GRAY_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.RIKYU_GRAY_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.WHITE_GREEN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHITE_GREEN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHITE_GREEN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.WHITE_GREEN_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.YOUNG_GREEN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YOUNG_GREEN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YOUNG_GREEN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.YOUNG_GREEN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.GREEN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GREEN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GREEN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.GREEN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.BLUE_GREEN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_GREEN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_GREEN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_GREEN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.MATCHA_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MATCHA_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MATCHA_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.MATCHA_STAIRS_BUILDING_BLOCK.get());
                
                // 新增4个颜色方块系列（简写ID）
                output.accept(ModBlocks.PINE_NEEDLE_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PINE_NEEDLE_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PINE_NEEDLE_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.PINE_NEEDLE_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.DEEP_GREEN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DEEP_GREEN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DEEP_GREEN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.DEEP_GREEN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.FOREST_GREEN_BUILDING_BLOCK.get());
                output.accept(ModBlocks.FOREST_GREEN_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.FOREST_GREEN_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.FOREST_GREEN_STAIRS_BUILDING_BLOCK.get());
                
                output.accept(ModBlocks.BLUE_SEA_PINE_TEA_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_SEA_PINE_TEA_GLOWING_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_SEA_PINE_TEA_SLAB_BUILDING_BLOCK.get());
                output.accept(ModBlocks.BLUE_SEA_PINE_TEA_STAIRS_BUILDING_BLOCK.get());

            })
            .build());

    // 都市构方道路物品栏 (a_2)
    public static final RegistryObject<CreativeModeTab> URBANFORMA_ROAD_TAB = CREATIVE_MODE_TABS.register("a_2_urbanforma_road",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.a_2_urbanforma_road"))
            .icon(() -> new ItemStack(ModBlocks.ROAD_A_GRAY.get()))
            .displayItems((parameters, output) -> {
                // 道路系列方块
                output.accept(ModBlocks.ROAD_A_GRAY.get());
                output.accept(ModBlocks.ROAD_A_GRAY_GLOWING.get());
                output.accept(ModBlocks.ROAD_A_GRAY_SLAB.get());
                output.accept(ModBlocks.ROAD_A_LIGHT_GRAY.get());
                output.accept(ModBlocks.ROAD_A_LIGHT_GRAY_GLOWING.get());
                output.accept(ModBlocks.ROAD_A_LIGHT_GRAY_SLAB.get());
                output.accept(ModBlocks.ROAD_A_WHITE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_GLOWING.get());
                output.accept(ModBlocks.ROAD_A_WHITE_SLAB.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LINE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_COMPENSATION.get());
                output.accept(ModBlocks.ROAD_A_WHITE_ZEBRA.get());
                output.accept(ModBlocks.ROAD_A_WHITE_CROSS.get());
                output.accept(ModBlocks.ROAD_A_WHITE_T_LINE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_CORNER.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LINE_END_1.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LINE_END_2.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_CORNER_LINE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_CORNER_LINE_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_THICK_BORDER.get());
                output.accept(ModBlocks.ROAD_A_WHITE_BORDER.get());
                output.accept(ModBlocks.ROAD_A_WHITE_THIN_BORDER.get());
                
                // 道路白小弯和道路白中弯系列
                output.accept(ModBlocks.ROAD_A_WHITE_SMALL_CURVE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_1.get());
                output.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_1_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_2.get());
                output.accept(ModBlocks.ROAD_A_WHITE_MEDIUM_CURVE_2_REVERSE.get());
                
                // 道路白45度弯系列
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_1.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_1_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_2.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_2_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_3.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_3_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_4.get());
                output.accept(ModBlocks.ROAD_A_WHITE_45_DEGREE_CURVE_4_REVERSE.get());
                
                // 道路白大弯系列
                output.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_1.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_1_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_2.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_2_REVERSE.get());
                output.accept(ModBlocks.ROAD_A_WHITE_LARGE_CURVE_3.get());
                
                // 灰色道路高系列方块 (高7到高1)
                output.accept(ModBlocks.ROAD_GRAY_H7.get());
                output.accept(ModBlocks.ROAD_GRAY_H6.get());
                output.accept(ModBlocks.ROAD_GRAY_H5.get());
                output.accept(ModBlocks.ROAD_GRAY_H4.get());
                output.accept(ModBlocks.ROAD_GRAY_H3.get());
                output.accept(ModBlocks.ROAD_GRAY_H2.get());
                output.accept(ModBlocks.ROAD_GRAY_H1.get());
                
                // 道路白中线高系列方块 (高7到高1)
                output.accept(ModBlocks.ROAD_WHITE_LINE_H7.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_H6.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_H5.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_H4.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_H3.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_H2.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_H1.get());
                
                // 道路白线头系列方块
                output.accept(ModBlocks.ROAD_WHITE_LINE_HEAD_3X.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_HEAD_6X.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_HEAD_3X_REVERSE.get());
                output.accept(ModBlocks.ROAD_WHITE_LINE_HEAD_6X_REVERSE.get());
                
                // 新增道路方块
                output.accept(ModBlocks.ROAD_DOUBLE_WHITE_LINE.get());
                output.accept(ModBlocks.ROAD_WHITE_DASHED_LINE.get());
                output.accept(ModBlocks.ROAD_WHITE_DECELERATION_LINE.get());
                output.accept(ModBlocks.ROAD_WHITE_DECELERATION_LINE_REVERSE.get());
                output.accept(ModBlocks.ROAD_YELLOW_DECELERATION_CONNECTION.get());
                output.accept(ModBlocks.ROAD_YELLOW_CENTER_LINE.get());
                output.accept(ModBlocks.ROAD_DOUBLE_YELLOW_LINE.get());
                output.accept(ModBlocks.ROAD_YELLOW_DASHED_LINE.get());
            })
            .build());

    // 都市构方其他物品栏 (a_3)
    public static final RegistryObject<CreativeModeTab> URBANFORMA_OTHER_TAB = CREATIVE_MODE_TABS.register("a_3_urbanforma_other",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.a_3_urbanforma_other"))
            .icon(() -> new ItemStack(ModBlocks.WHITE_BUILDING_BLOCK.get()))
            .displayItems((parameters, output) -> {
                // 这里可以添加其他物品
            })
            .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}