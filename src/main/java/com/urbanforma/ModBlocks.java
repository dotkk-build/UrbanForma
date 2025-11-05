package com.urbanforma;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, UrbanForma.MODID);
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, UrbanForma.MODID);
    
    // 通用方块属性配置
    private static final BlockBehaviour.Properties BASIC_PROPERTIES = BlockBehaviour.Properties.of()
        .mapColor(MapColor.STONE)
        .strength(2.0f)
        .requiresCorrectToolForDrops()
        .sound(SoundType.STONE);
    
    private static final BlockBehaviour.Properties GLOWING_PROPERTIES = BlockBehaviour.Properties.of()
        .mapColor(MapColor.STONE)
        .strength(2.0f)
        .requiresCorrectToolForDrops()
        .sound(SoundType.STONE)
        .lightLevel(state -> 15);
    
    
    // 辅助方法：简化方块注册
    private static RegistryObject<Block> registerBasicBlock(String name) {
        return registerBlock(name, () -> new Block(BASIC_PROPERTIES));
    }
    
    private static RegistryObject<Block> registerGlowingBlock(String name) {
        return registerBlock(name, () -> new Block(GLOWING_PROPERTIES));
    }
    
    private static RegistryObject<Block> registerSlabBlock(String name) {
        return registerBlock(name, () -> new SlabBlock(BASIC_PROPERTIES));
    }
    
    private static RegistryObject<Block> registerHeightRoadBlock(String name, float height) {
        return registerBlock(name, () -> new com.urbanforma.block.HeightRoadBlock(BASIC_PROPERTIES, height));
    }
    
    private static RegistryObject<Block> registerDirectionalHeightRoadBlock(String name, float height) {
        return registerBlock(name, () -> new com.urbanforma.block.DirectionalHeightRoadBlock(BASIC_PROPERTIES, height));
    }
    
    private static RegistryObject<Block> registerStairBlock(String name, Supplier<Block> baseBlock) {
        return registerBlock(name, () -> new StairBlock(() -> baseBlock.get().defaultBlockState(), BASIC_PROPERTIES));
    }
    
    private static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
    
    private static RegistryObject<Block> registerPlayerFacingBlock(String name) {
        return registerBlock(name, () -> new com.urbanforma.block.PlayerFacingBlock(BASIC_PROPERTIES));
    }
    
    private static RegistryObject<Block> registerSmartTextureBlock(String name) {
        return registerBlock(name, () -> new com.urbanforma.block.SmartTextureBlock(BASIC_PROPERTIES));
    }
    
    // 白色系列方块
    public static final RegistryObject<Block> WHITE_BUILDING_BLOCK = registerBasicBlock("w_bb");
    public static final RegistryObject<Block> WHITE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("w_gbb");
    public static final RegistryObject<Block> WHITE_SLAB_BUILDING_BLOCK = registerSlabBlock("w_sbb");
    public static final RegistryObject<Block> WHITE_STAIRS_BUILDING_BLOCK = registerStairBlock("w_stbb", WHITE_BUILDING_BLOCK);
    
    // 亮灰系列方块 (1-3)
    public static final RegistryObject<Block> LIGHT_GRAY_1_BUILDING_BLOCK = registerBasicBlock("lg_1_bb");
    public static final RegistryObject<Block> LIGHT_GRAY_1_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lg_1_gbb");
    public static final RegistryObject<Block> LIGHT_GRAY_1_SLAB_BUILDING_BLOCK = registerSlabBlock("lg_1_sbb");
    public static final RegistryObject<Block> LIGHT_GRAY_1_STAIRS_BUILDING_BLOCK = registerStairBlock("lg_1_stbb", LIGHT_GRAY_1_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> LIGHT_GRAY_2_BUILDING_BLOCK = registerBasicBlock("lg_2_bb");
    public static final RegistryObject<Block> LIGHT_GRAY_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lg_2_gbb");
    public static final RegistryObject<Block> LIGHT_GRAY_2_SLAB_BUILDING_BLOCK = registerSlabBlock("lg_2_sbb");
    public static final RegistryObject<Block> LIGHT_GRAY_2_STAIRS_BUILDING_BLOCK = registerStairBlock("lg_2_stbb", LIGHT_GRAY_2_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> LIGHT_GRAY_3_BUILDING_BLOCK = registerBasicBlock("lg_3_bb");
    public static final RegistryObject<Block> LIGHT_GRAY_3_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lg_3_gbb");
    public static final RegistryObject<Block> LIGHT_GRAY_3_SLAB_BUILDING_BLOCK = registerSlabBlock("lg_3_sbb");
    public static final RegistryObject<Block> LIGHT_GRAY_3_STAIRS_BUILDING_BLOCK = registerStairBlock("lg_3_stbb", LIGHT_GRAY_3_BUILDING_BLOCK);
    
    // 中灰系列方块 (1-3)
    public static final RegistryObject<Block> MEDIUM_GRAY_1_BUILDING_BLOCK = registerBasicBlock("mg_1_bb");
    public static final RegistryObject<Block> MEDIUM_GRAY_1_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mg_1_gbb");
    public static final RegistryObject<Block> MEDIUM_GRAY_1_SLAB_BUILDING_BLOCK = registerSlabBlock("mg_1_sbb");
    public static final RegistryObject<Block> MEDIUM_GRAY_1_STAIRS_BUILDING_BLOCK = registerStairBlock("mg_1_stbb", MEDIUM_GRAY_1_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> MEDIUM_GRAY_2_BUILDING_BLOCK = registerBasicBlock("mg_2_bb");
    public static final RegistryObject<Block> MEDIUM_GRAY_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mg_2_gbb");
    public static final RegistryObject<Block> MEDIUM_GRAY_2_SLAB_BUILDING_BLOCK = registerSlabBlock("mg_2_sbb");
    public static final RegistryObject<Block> MEDIUM_GRAY_2_STAIRS_BUILDING_BLOCK = registerStairBlock("mg_2_stbb", MEDIUM_GRAY_2_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> MEDIUM_GRAY_3_BUILDING_BLOCK = registerBasicBlock("mg_3_bb");
    public static final RegistryObject<Block> MEDIUM_GRAY_3_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mg_3_gbb");
    public static final RegistryObject<Block> MEDIUM_GRAY_3_SLAB_BUILDING_BLOCK = registerSlabBlock("mg_3_sbb");
    public static final RegistryObject<Block> MEDIUM_GRAY_3_STAIRS_BUILDING_BLOCK = registerStairBlock("mg_3_stbb", MEDIUM_GRAY_3_BUILDING_BLOCK);
    
    // 暗灰系列方块 (1-4)
    public static final RegistryObject<Block> DARK_GRAY_1_BUILDING_BLOCK = registerBasicBlock("dg_1_bb");
    public static final RegistryObject<Block> DARK_GRAY_1_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_1_gbb");
    public static final RegistryObject<Block> DARK_GRAY_1_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_1_sbb");
    public static final RegistryObject<Block> DARK_GRAY_1_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_1_stbb", DARK_GRAY_1_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DARK_GRAY_2_BUILDING_BLOCK = registerBasicBlock("dg_2_bb");
    public static final RegistryObject<Block> DARK_GRAY_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_2_gbb");
    public static final RegistryObject<Block> DARK_GRAY_2_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_2_sbb");
    public static final RegistryObject<Block> DARK_GRAY_2_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_2_stbb", DARK_GRAY_2_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DARK_GRAY_3_BUILDING_BLOCK = registerBasicBlock("dg_3_bb");
    public static final RegistryObject<Block> DARK_GRAY_3_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_3_gbb");
    public static final RegistryObject<Block> DARK_GRAY_3_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_3_sbb");
    public static final RegistryObject<Block> DARK_GRAY_3_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_3_stbb", DARK_GRAY_3_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DARK_GRAY_4_BUILDING_BLOCK = registerBasicBlock("dg_4_bb");
    public static final RegistryObject<Block> DARK_GRAY_4_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_4_gbb");
    public static final RegistryObject<Block> DARK_GRAY_4_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_4_sbb");
    public static final RegistryObject<Block> DARK_GRAY_4_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_4_stbb", DARK_GRAY_4_BUILDING_BLOCK);
    
    // 黑灰系列方块
    public static final RegistryObject<Block> BLACKISH_GRAY_BUILDING_BLOCK = registerBasicBlock("bg_bb");
    public static final RegistryObject<Block> BLACKISH_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bg_gbb");
    public static final RegistryObject<Block> BLACKISH_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("bg_sbb");
    public static final RegistryObject<Block> BLACKISH_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("bg_stbb", BLACKISH_GRAY_BUILDING_BLOCK);
    
    // 黑色系列方块
    public static final RegistryObject<Block> BLACK_BUILDING_BLOCK = registerBasicBlock("b_bb");
    public static final RegistryObject<Block> BLACK_GLOWING_BUILDING_BLOCK = registerGlowingBlock("b_gbb");
    public static final RegistryObject<Block> BLACK_SLAB_BUILDING_BLOCK = registerSlabBlock("b_sbb");
    public static final RegistryObject<Block> BLACK_STAIRS_BUILDING_BLOCK = registerStairBlock("b_stbb", BLACK_BUILDING_BLOCK);
    
    // 道路系列方块
    public static final RegistryObject<Block> ROAD_A_GRAY = registerBasicBlock("r_gray");
    public static final RegistryObject<Block> ROAD_A_GRAY_GLOWING = registerGlowingBlock("r_gray_g");
    public static final RegistryObject<Block> ROAD_A_GRAY_SLAB = registerSlabBlock("r_gray_s");
    
    public static final RegistryObject<Block> ROAD_A_LIGHT_GRAY = registerBasicBlock("r_lgray");
    public static final RegistryObject<Block> ROAD_A_LIGHT_GRAY_GLOWING = registerGlowingBlock("r_lgray_g");
    public static final RegistryObject<Block> ROAD_A_LIGHT_GRAY_SLAB = registerSlabBlock("r_lgray_s");
    
    public static final RegistryObject<Block> ROAD_A_WHITE = registerBasicBlock("r_white");
    public static final RegistryObject<Block> ROAD_A_WHITE_GLOWING = registerGlowingBlock("r_white_g");
    public static final RegistryObject<Block> ROAD_A_WHITE_SLAB = registerSlabBlock("r_white_s");
    
    public static final RegistryObject<Block> ROAD_A_WHITE_LINE = registerBlock("r_wl1", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE = registerBlock("r_wl2", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_COMPENSATION = registerBlock("r_wl3", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_ZEBRA = registerBlock("r_wl4", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_CROSS = registerBlock("r_wl5", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_T_LINE = registerBlock("r_wl6", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_CORNER = registerBlock("r_wl7", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION = registerBlock("r_wl8", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_REVERSE = registerBlock("r_wl9", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_LINE_END_1 = registerBlock("r_wl10", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_LINE_END_2 = registerBlock("r_wl11", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION = registerBlock("r_wl12", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_REVERSE = registerBlock("r_wl13", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION = registerBlock("r_wl14", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION_REVERSE = registerBlock("r_wl15", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    public static final RegistryObject<Block> ROAD_A_WHITE_CORNER_LINE = registerBlock("r_wl16", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_CORNER_LINE_REVERSE = registerBlock("r_wl17", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    public static final RegistryObject<Block> ROAD_A_WHITE_THICK_BORDER = registerBlock("r_wl1a", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_BORDER = registerBlock("r_wl1b", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_THIN_BORDER = registerBlock("r_wl1c", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    // 道路白小弯和道路白中弯系列
    public static final RegistryObject<Block> ROAD_A_WHITE_SMALL_CURVE = registerBlock("r_wl18", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_MEDIUM_CURVE_1 = registerBlock("r_wl19", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_MEDIUM_CURVE_1_REVERSE = registerBlock("r_wl20", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_MEDIUM_CURVE_2 = registerBlock("r_wl21", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_MEDIUM_CURVE_2_REVERSE = registerBlock("r_wl22", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    // 道路白45度弯系列
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_1 = registerBlock("r_wl23", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_1_REVERSE = registerBlock("r_wl24", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_2 = registerBlock("r_wl25", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_2_REVERSE = registerBlock("r_wl26", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_3 = registerBlock("r_wl27", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_3_REVERSE = registerBlock("r_wl28", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_4 = registerBlock("r_wl29", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_45_DEGREE_CURVE_4_REVERSE = registerBlock("r_wl30", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    // 道路白大弯系列
    public static final RegistryObject<Block> ROAD_A_WHITE_LARGE_CURVE_1 = registerBlock("r_wl31", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_LARGE_CURVE_1_REVERSE = registerBlock("r_wl32", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_LARGE_CURVE_2 = registerBlock("r_wl33", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_LARGE_CURVE_2_REVERSE = registerBlock("r_wl34", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_A_WHITE_LARGE_CURVE_3 = registerBlock("r_wl35", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    // 灰色道路高系列方块 (高7到高1)
    public static final RegistryObject<Block> ROAD_GRAY_H7 = registerHeightRoadBlock("r_gray_h7", 14.0f);
    public static final RegistryObject<Block> ROAD_GRAY_H6 = registerHeightRoadBlock("r_gray_h6", 12.0f);
    public static final RegistryObject<Block> ROAD_GRAY_H5 = registerHeightRoadBlock("r_gray_h5", 10.0f);
    public static final RegistryObject<Block> ROAD_GRAY_H4 = registerHeightRoadBlock("r_gray_h4", 8.0f);
    public static final RegistryObject<Block> ROAD_GRAY_H3 = registerHeightRoadBlock("r_gray_h3", 6.0f);
    public static final RegistryObject<Block> ROAD_GRAY_H2 = registerHeightRoadBlock("r_gray_h2", 4.0f);
    public static final RegistryObject<Block> ROAD_GRAY_H1 = registerHeightRoadBlock("r_gray_h1", 2.0f);
    
    // 道路白中线高系列方块 (高7到高1)
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H7 = registerDirectionalHeightRoadBlock("r_wl_h7", 14.0f);
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H6 = registerDirectionalHeightRoadBlock("r_wl_h6", 12.0f);
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H5 = registerDirectionalHeightRoadBlock("r_wl_h5", 10.0f);
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H4 = registerDirectionalHeightRoadBlock("r_wl_h4", 8.0f);
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H3 = registerDirectionalHeightRoadBlock("r_wl_h3", 6.0f);
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H2 = registerDirectionalHeightRoadBlock("r_wl_h2", 4.0f);
    public static final RegistryObject<Block> ROAD_WHITE_LINE_H1 = registerDirectionalHeightRoadBlock("r_wl_h1", 2.0f);
    
    // 道路白线头系列方块
    public static final RegistryObject<Block> ROAD_WHITE_LINE_HEAD_3X = registerBlock("r_xt1x", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_WHITE_LINE_HEAD_6X = registerBlock("r_xt2x", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    // 道路白线头反向系列方块
    public static final RegistryObject<Block> ROAD_WHITE_LINE_HEAD_3X_REVERSE = registerBlock("r_xt1xd", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_WHITE_LINE_HEAD_6X_REVERSE = registerBlock("r_xt2xd", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    
    // 新增道路方块
    public static final RegistryObject<Block> ROAD_DOUBLE_WHITE_LINE = registerBlock("r_ll1", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_WHITE_DASHED_LINE = registerBlock("r_x", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_WHITE_DECELERATION_LINE = registerBlock("r_js1", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_WHITE_DECELERATION_LINE_REVERSE = registerBlock("r_js2", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_YELLOW_DECELERATION_CONNECTION = registerBlock("r_l1_yj", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_YELLOW_CENTER_LINE = registerBlock("r_l1_y", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_DOUBLE_YELLOW_LINE = registerBlock("r_ll1_y", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    public static final RegistryObject<Block> ROAD_YELLOW_DASHED_LINE = registerBlock("r_x_y", () -> new com.urbanforma.block.DirectionalRoadBlock(BASIC_PROPERTIES));
    

    

    


    // 新增72个颜色方块系列 - 第一批4个颜色（简写）
    public static final RegistryObject<Block> N_HB_BUILDING_BLOCK = registerBasicBlock("n_hb_bb");
    public static final RegistryObject<Block> N_HB_GLOWING_BUILDING_BLOCK = registerGlowingBlock("n_hb_gbb");
    public static final RegistryObject<Block> N_HB_SLAB_BUILDING_BLOCK = registerSlabBlock("n_hb_sbb");
    public static final RegistryObject<Block> N_HB_STAIRS_BUILDING_BLOCK = registerStairBlock("n_hb_stbb", N_HB_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> XY_BUILDING_BLOCK = registerBasicBlock("xy_bb");
    public static final RegistryObject<Block> XY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("xy_gbb");
    public static final RegistryObject<Block> XY_SLAB_BUILDING_BLOCK = registerSlabBlock("xy_sbb");
    public static final RegistryObject<Block> XY_STAIRS_BUILDING_BLOCK = registerStairBlock("xy_stbb", XY_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> SC_BUILDING_BLOCK = registerBasicBlock("sc_bb");
    public static final RegistryObject<Block> SC_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sc_gbb");
    public static final RegistryObject<Block> SC_SLAB_BUILDING_BLOCK = registerSlabBlock("sc_sbb");
    public static final RegistryObject<Block> SC_STAIRS_BUILDING_BLOCK = registerStairBlock("sc_stbb", SC_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> YH_BUILDING_BLOCK = registerBasicBlock("yh_bb");
    public static final RegistryObject<Block> YH_GLOWING_BUILDING_BLOCK = registerGlowingBlock("yh_gbb");
    public static final RegistryObject<Block> YH_SLAB_BUILDING_BLOCK = registerSlabBlock("yh_sbb");
    public static final RegistryObject<Block> YH_STAIRS_BUILDING_BLOCK = registerStairBlock("yh_stbb", YH_BUILDING_BLOCK);
    
    // 新增72个颜色方块系列 - 第二批4个颜色（简写）
    public static final RegistryObject<Block> TB_BUILDING_BLOCK = registerBasicBlock("tb_bb");
    public static final RegistryObject<Block> TB_GLOWING_BUILDING_BLOCK = registerGlowingBlock("tb_gbb");
    public static final RegistryObject<Block> TB_SLAB_BUILDING_BLOCK = registerSlabBlock("tb_sbb");
    public static final RegistryObject<Block> TB_STAIRS_BUILDING_BLOCK = registerStairBlock("tb_stbb", TB_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> SH_BUILDING_BLOCK = registerBasicBlock("sh_bb");
    public static final RegistryObject<Block> SH_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sh_gbb");
    public static final RegistryObject<Block> SH_SLAB_BUILDING_BLOCK = registerSlabBlock("sh_sbb");
    public static final RegistryObject<Block> SH_STAIRS_BUILDING_BLOCK = registerStairBlock("sh_stbb", SH_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BK_BUILDING_BLOCK = registerBasicBlock("bk_bb");
    public static final RegistryObject<Block> BK_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bk_gbb");
    public static final RegistryObject<Block> BK_SLAB_BUILDING_BLOCK = registerSlabBlock("bk_sbb");
    public static final RegistryObject<Block> BK_STAIRS_BUILDING_BLOCK = registerStairBlock("bk_stbb", BK_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> T_BUILDING_BLOCK = registerBasicBlock("t_bb");
    public static final RegistryObject<Block> T_GLOWING_BUILDING_BLOCK = registerGlowingBlock("t_gbb");
    public static final RegistryObject<Block> T_SLAB_BUILDING_BLOCK = registerSlabBlock("t_sbb");
    public static final RegistryObject<Block> T_STAIRS_BUILDING_BLOCK = registerStairBlock("t_stbb", T_BUILDING_BLOCK);
    
    // 新增72个颜色方块系列 - 第三批4个颜色（简写）
    public static final RegistryObject<Block> BRM_BUILDING_BLOCK = registerBasicBlock("brm_bb");
    public static final RegistryObject<Block> BRM_GLOWING_BUILDING_BLOCK = registerGlowingBlock("brm_gbb");
    public static final RegistryObject<Block> BRM_SLAB_BUILDING_BLOCK = registerSlabBlock("brm_sbb");
    public static final RegistryObject<Block> BRM_STAIRS_BUILDING_BLOCK = registerStairBlock("brm_stbb", BRM_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> AZ_BUILDING_BLOCK = registerBasicBlock("az_bb");
    public static final RegistryObject<Block> AZ_GLOWING_BUILDING_BLOCK = registerGlowingBlock("az_gbb");
    public static final RegistryObject<Block> AZ_SLAB_BUILDING_BLOCK = registerSlabBlock("az_sbb");
    public static final RegistryObject<Block> AZ_STAIRS_BUILDING_BLOCK = registerStairBlock("az_stbb", AZ_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> PN_BUILDING_BLOCK = registerBasicBlock("pn_bb");
    public static final RegistryObject<Block> PN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pn_gbb");
    public static final RegistryObject<Block> PN_SLAB_BUILDING_BLOCK = registerSlabBlock("pn_sbb");
    public static final RegistryObject<Block> PN_STAIRS_BUILDING_BLOCK = registerStairBlock("pn_stbb", PN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> QW_BUILDING_BLOCK = registerBasicBlock("qw_bb");
    public static final RegistryObject<Block> QW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("qw_gbb");
    public static final RegistryObject<Block> QW_SLAB_BUILDING_BLOCK = registerSlabBlock("qw_sbb");
    public static final RegistryObject<Block> QW_STAIRS_BUILDING_BLOCK = registerStairBlock("qw_stbb", QW_BUILDING_BLOCK);
    
    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> RED_BUILDING_BLOCK = registerBasicBlock("r_bb");
    public static final RegistryObject<Block> RED_GLOWING_BUILDING_BLOCK = registerGlowingBlock("r_gbb");
    public static final RegistryObject<Block> RED_SLAB_BUILDING_BLOCK = registerSlabBlock("r_sbb");
    public static final RegistryObject<Block> RED_STAIRS_BUILDING_BLOCK = registerStairBlock("r_stbb", RED_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> RED_VERMILLION_BUILDING_BLOCK = registerBasicBlock("rv_bb");
    public static final RegistryObject<Block> RED_VERMILLION_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rv_gbb");
    public static final RegistryObject<Block> RED_VERMILLION_SLAB_BUILDING_BLOCK = registerSlabBlock("rv_sbb");
    public static final RegistryObject<Block> RED_VERMILLION_STAIRS_BUILDING_BLOCK = registerStairBlock("rv_stbb", RED_VERMILLION_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> SCARLET_BUILDING_BLOCK = registerBasicBlock("s_bb");
    public static final RegistryObject<Block> SCARLET_GLOWING_BUILDING_BLOCK = registerGlowingBlock("s_gbb");
    public static final RegistryObject<Block> SCARLET_SLAB_BUILDING_BLOCK = registerSlabBlock("s_sbb");
    public static final RegistryObject<Block> SCARLET_STAIRS_BUILDING_BLOCK = registerStairBlock("s_stbb", SCARLET_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DEEP_SCARLET_BUILDING_BLOCK = registerBasicBlock("ds_bb");
    public static final RegistryObject<Block> DEEP_SCARLET_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ds_gbb");
    public static final RegistryObject<Block> DEEP_SCARLET_SLAB_BUILDING_BLOCK = registerSlabBlock("ds_sbb");
    public static final RegistryObject<Block> DEEP_SCARLET_STAIRS_BUILDING_BLOCK = registerStairBlock("ds_stbb", DEEP_SCARLET_BUILDING_BLOCK);
    
    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> CHESTNUT_BUILDING_BLOCK = registerBasicBlock("ls_bb");
    public static final RegistryObject<Block> CHESTNUT_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ls_gbb");
    public static final RegistryObject<Block> CHESTNUT_SLAB_BUILDING_BLOCK = registerSlabBlock("ls_sbb");
    public static final RegistryObject<Block> CHESTNUT_STAIRS_BUILDING_BLOCK = registerStairBlock("ls_stbb", CHESTNUT_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> ROUGE_BUILDING_BLOCK = registerBasicBlock("rz_bb");
    public static final RegistryObject<Block> ROUGE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rz_gbb");
    public static final RegistryObject<Block> ROUGE_SLAB_BUILDING_BLOCK = registerSlabBlock("rz_sbb");
    public static final RegistryObject<Block> ROUGE_STAIRS_BUILDING_BLOCK = registerStairBlock("rz_stbb", ROUGE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> MODERN_RED_BUILDING_BLOCK = registerBasicBlock("jy_bb");
    public static final RegistryObject<Block> MODERN_RED_GLOWING_BUILDING_BLOCK = registerGlowingBlock("jy_gbb");
    public static final RegistryObject<Block> MODERN_RED_SLAB_BUILDING_BLOCK = registerSlabBlock("jy_sbb");
    public static final RegistryObject<Block> MODERN_RED_STAIRS_BUILDING_BLOCK = registerStairBlock("jy_stbb", MODERN_RED_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> GOLDEN_RED_BUILDING_BLOCK = registerBasicBlock("jc_bb");
    public static final RegistryObject<Block> GOLDEN_RED_GLOWING_BUILDING_BLOCK = registerGlowingBlock("jc_gbb");
    public static final RegistryObject<Block> GOLDEN_RED_SLAB_BUILDING_BLOCK = registerSlabBlock("jc_sbb");
    public static final RegistryObject<Block> GOLDEN_RED_STAIRS_BUILDING_BLOCK = registerStairBlock("jc_stbb", GOLDEN_RED_BUILDING_BLOCK);
    
    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> RED_ORANGE_BUILDING_BLOCK = registerBasicBlock("ro_bb");
    public static final RegistryObject<Block> RED_ORANGE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ro_gbb");
    public static final RegistryObject<Block> RED_ORANGE_SLAB_BUILDING_BLOCK = registerSlabBlock("ro_sbb");
    public static final RegistryObject<Block> RED_ORANGE_STAIRS_BUILDING_BLOCK = registerStairBlock("ro_stbb", RED_ORANGE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> RED_VERMILLION_2_BUILDING_BLOCK = registerBasicBlock("rv2_bb");
    public static final RegistryObject<Block> RED_VERMILLION_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rv2_gbb");
    public static final RegistryObject<Block> RED_VERMILLION_2_SLAB_BUILDING_BLOCK = registerSlabBlock("rv2_sbb");
    public static final RegistryObject<Block> RED_VERMILLION_2_STAIRS_BUILDING_BLOCK = registerStairBlock("rv2_stbb", RED_VERMILLION_2_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DAWN_BUILDING_BLOCK = registerBasicBlock("d_bb");
    public static final RegistryObject<Block> DAWN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("d_gbb");
    public static final RegistryObject<Block> DAWN_SLAB_BUILDING_BLOCK = registerSlabBlock("d_sbb");
    public static final RegistryObject<Block> DAWN_STAIRS_BUILDING_BLOCK = registerStairBlock("d_stbb", DAWN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BURNT_TEA_BUILDING_BLOCK = registerBasicBlock("bt_bb");
    public static final RegistryObject<Block> BURNT_TEA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bt_gbb");
    public static final RegistryObject<Block> BURNT_TEA_SLAB_BUILDING_BLOCK = registerSlabBlock("bt_sbb");
    public static final RegistryObject<Block> BURNT_TEA_STAIRS_BUILDING_BLOCK = registerStairBlock("bt_stbb", BURNT_TEA_BUILDING_BLOCK);
    
    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> PLUM_DYE_BUILDING_BLOCK = registerBasicBlock("mr_bb");
    public static final RegistryObject<Block> PLUM_DYE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mr_gbb");
    public static final RegistryObject<Block> PLUM_DYE_SLAB_BUILDING_BLOCK = registerSlabBlock("mr_sbb");
    public static final RegistryObject<Block> PLUM_DYE_STAIRS_BUILDING_BLOCK = registerStairBlock("mr_stbb", PLUM_DYE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> RED_WHITE_OAK_BUILDING_BLOCK = registerBasicBlock("rwo_bb");
    public static final RegistryObject<Block> RED_WHITE_OAK_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rwo_gbb");
    public static final RegistryObject<Block> RED_WHITE_OAK_SLAB_BUILDING_BLOCK = registerSlabBlock("rwo_sbb");
    public static final RegistryObject<Block> RED_WHITE_OAK_STAIRS_BUILDING_BLOCK = registerStairBlock("rwo_stbb", RED_WHITE_OAK_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> SKIN_BUILDING_BLOCK = registerBasicBlock("js_bb");
    public static final RegistryObject<Block> SKIN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("js_gbb");
    public static final RegistryObject<Block> SKIN_SLAB_BUILDING_BLOCK = registerSlabBlock("js_sbb");
    public static final RegistryObject<Block> SKIN_STAIRS_BUILDING_BLOCK = registerStairBlock("js_stbb", SKIN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WHEAT_BUILDING_BLOCK = registerBasicBlock("xm_bb");
    public static final RegistryObject<Block> WHEAT_GLOWING_BUILDING_BLOCK = registerGlowingBlock("xm_gbb");
    public static final RegistryObject<Block> WHEAT_SLAB_BUILDING_BLOCK = registerSlabBlock("xm_sbb");
    public static final RegistryObject<Block> WHEAT_STAIRS_BUILDING_BLOCK = registerStairBlock("xm_stbb", WHEAT_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> GOLD_BUILDING_BLOCK = registerBasicBlock("go_bb");
    public static final RegistryObject<Block> GOLD_GLOWING_BUILDING_BLOCK = registerGlowingBlock("go_gbb");
    public static final RegistryObject<Block> GOLD_SLAB_BUILDING_BLOCK = registerSlabBlock("go_sbb");
    public static final RegistryObject<Block> GOLD_STAIRS_BUILDING_BLOCK = registerStairBlock("go_stbb", GOLD_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> LIGHT_YELLOW_BUILDING_BLOCK = registerBasicBlock("ly_bb");
    public static final RegistryObject<Block> LIGHT_YELLOW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ly_gbb");
    public static final RegistryObject<Block> LIGHT_YELLOW_SLAB_BUILDING_BLOCK = registerSlabBlock("ly_sbb");
    public static final RegistryObject<Block> LIGHT_YELLOW_STAIRS_BUILDING_BLOCK = registerStairBlock("ly_stbb", LIGHT_YELLOW_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> PHELLODENDRON_BUILDING_BLOCK = registerBasicBlock("ph_bb");
    public static final RegistryObject<Block> PHELLODENDRON_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ph_gbb");
    public static final RegistryObject<Block> PHELLODENDRON_SLAB_BUILDING_BLOCK = registerSlabBlock("ph_sbb");
    public static final RegistryObject<Block> PHELLODENDRON_STAIRS_BUILDING_BLOCK = registerStairBlock("ph_stbb", PHELLODENDRON_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> TURMERIC_BUILDING_BLOCK = registerBasicBlock("tu_bb");
    public static final RegistryObject<Block> TURMERIC_GLOWING_BUILDING_BLOCK = registerGlowingBlock("tu_gbb");
    public static final RegistryObject<Block> TURMERIC_SLAB_BUILDING_BLOCK = registerSlabBlock("tu_sbb");
    public static final RegistryObject<Block> TURMERIC_STAIRS_BUILDING_BLOCK = registerStairBlock("tu_stbb", TURMERIC_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> YELLOW_BUILDING_BLOCK = registerBasicBlock("y_bb");
    public static final RegistryObject<Block> YELLOW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("y_gbb");
    public static final RegistryObject<Block> YELLOW_SLAB_BUILDING_BLOCK = registerSlabBlock("y_sbb");
    public static final RegistryObject<Block> YELLOW_STAIRS_BUILDING_BLOCK = registerStairBlock("y_stbb", YELLOW_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> GREEN_YELLOW_BUILDING_BLOCK = registerBasicBlock("gy_bb");
    public static final RegistryObject<Block> GREEN_YELLOW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("gy_gbb");
    public static final RegistryObject<Block> GREEN_YELLOW_SLAB_BUILDING_BLOCK = registerSlabBlock("gy_sbb");
    public static final RegistryObject<Block> GREEN_YELLOW_STAIRS_BUILDING_BLOCK = registerStairBlock("gy_stbb", GREEN_YELLOW_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> NATIONAL_DEFENSE_BUILDING_BLOCK = registerBasicBlock("nd_bb");
    public static final RegistryObject<Block> NATIONAL_DEFENSE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("nd_gbb");
    public static final RegistryObject<Block> NATIONAL_DEFENSE_SLAB_BUILDING_BLOCK = registerSlabBlock("nd_sbb");
    public static final RegistryObject<Block> NATIONAL_DEFENSE_STAIRS_BUILDING_BLOCK = registerStairBlock("nd_stbb", NATIONAL_DEFENSE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BLUE_VERMILLION_BUILDING_BLOCK = registerBasicBlock("bv_bb");
    public static final RegistryObject<Block> BLUE_VERMILLION_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bv_gbb");
    public static final RegistryObject<Block> BLUE_VERMILLION_SLAB_BUILDING_BLOCK = registerSlabBlock("bv_sbb");
    public static final RegistryObject<Block> BLUE_VERMILLION_STAIRS_BUILDING_BLOCK = registerStairBlock("bv_stbb", BLUE_VERMILLION_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> SEA_PINE_BUILDING_BLOCK = registerBasicBlock("sp_bb");
    public static final RegistryObject<Block> SEA_PINE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sp_gbb");
    public static final RegistryObject<Block> SEA_PINE_SLAB_BUILDING_BLOCK = registerSlabBlock("sp_sbb");
    public static final RegistryObject<Block> SEA_PINE_STAIRS_BUILDING_BLOCK = registerStairBlock("sp_stbb", SEA_PINE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> MOUNTAIN_DOVE_BUILDING_BLOCK = registerBasicBlock("md_bb");
    public static final RegistryObject<Block> MOUNTAIN_DOVE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("md_gbb");
    public static final RegistryObject<Block> MOUNTAIN_DOVE_SLAB_BUILDING_BLOCK = registerSlabBlock("md_sbb");
    public static final RegistryObject<Block> MOUNTAIN_DOVE_STAIRS_BUILDING_BLOCK = registerStairBlock("md_stbb", MOUNTAIN_DOVE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> RIKYU_GRAY_BUILDING_BLOCK = registerBasicBlock("rg_bb");
    public static final RegistryObject<Block> RIKYU_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rg_gbb");
    public static final RegistryObject<Block> RIKYU_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("rg_sbb");
    public static final RegistryObject<Block> RIKYU_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("rg_stbb", RIKYU_GRAY_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WHITE_GREEN_BUILDING_BLOCK = registerBasicBlock("wg_bb");
    public static final RegistryObject<Block> WHITE_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wg_gbb");
    public static final RegistryObject<Block> WHITE_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("wg_sbb");
    public static final RegistryObject<Block> WHITE_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("wg_stbb", WHITE_GREEN_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> YOUNG_GREEN_BUILDING_BLOCK = registerBasicBlock("yg_bb");
    public static final RegistryObject<Block> YOUNG_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("yg_gbb");
    public static final RegistryObject<Block> YOUNG_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("yg_sbb");
    public static final RegistryObject<Block> YOUNG_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("yg_stbb", YOUNG_GREEN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> GREEN_BUILDING_BLOCK = registerBasicBlock("gr_bb");
    public static final RegistryObject<Block> GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("gr_gbb");
    public static final RegistryObject<Block> GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("gr_sbb");
    public static final RegistryObject<Block> GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("gr_stbb", GREEN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BLUE_GREEN_BUILDING_BLOCK = registerBasicBlock("bgr_bb");
    public static final RegistryObject<Block> BLUE_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bgr_gbb");
    public static final RegistryObject<Block> BLUE_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("bgr_sbb");
    public static final RegistryObject<Block> BLUE_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("bgr_stbb", BLUE_GREEN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> MATCHA_BUILDING_BLOCK = registerBasicBlock("mt_bb");
    public static final RegistryObject<Block> MATCHA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mt_gbb");
    public static final RegistryObject<Block> MATCHA_SLAB_BUILDING_BLOCK = registerSlabBlock("mt_sbb");
    public static final RegistryObject<Block> MATCHA_STAIRS_BUILDING_BLOCK = registerStairBlock("mt_stbb", MATCHA_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> PINE_NEEDLE_BUILDING_BLOCK = registerBasicBlock("pnd_bb");
    public static final RegistryObject<Block> PINE_NEEDLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pnd_gbb");
    public static final RegistryObject<Block> PINE_NEEDLE_SLAB_BUILDING_BLOCK = registerSlabBlock("pnd_sbb");
    public static final RegistryObject<Block> PINE_NEEDLE_STAIRS_BUILDING_BLOCK = registerStairBlock("pnd_stbb", PINE_NEEDLE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DEEP_GREEN_BUILDING_BLOCK = registerBasicBlock("dgr_bb");
    public static final RegistryObject<Block> DEEP_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dgr_gbb");
    public static final RegistryObject<Block> DEEP_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("dgr_sbb");
    public static final RegistryObject<Block> DEEP_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("dgr_stbb", DEEP_GREEN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> FOREST_GREEN_BUILDING_BLOCK = registerBasicBlock("fg_bb");
    public static final RegistryObject<Block> FOREST_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("fg_gbb");
    public static final RegistryObject<Block> FOREST_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("fg_sbb");
    public static final RegistryObject<Block> FOREST_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("fg_stbb", FOREST_GREEN_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BLUE_SEA_PINE_TEA_BUILDING_BLOCK = registerBasicBlock("bst_bb");
    public static final RegistryObject<Block> BLUE_SEA_PINE_TEA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bst_gbb");
    public static final RegistryObject<Block> BLUE_SEA_PINE_TEA_SLAB_BUILDING_BLOCK = registerSlabBlock("bst_sbb");
    public static final RegistryObject<Block> BLUE_SEA_PINE_TEA_STAIRS_BUILDING_BLOCK = registerStairBlock("bst_stbb", BLUE_SEA_PINE_TEA_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> SENCHA_BUILDING_BLOCK = registerBasicBlock("sen_bb");
    public static final RegistryObject<Block> SENCHA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sen_gbb");
    public static final RegistryObject<Block> SENCHA_SLAB_BUILDING_BLOCK = registerSlabBlock("sen_sbb");
    public static final RegistryObject<Block> SENCHA_STAIRS_BUILDING_BLOCK = registerStairBlock("sen_stbb", SENCHA_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> IRON_GRAY_BUILDING_BLOCK = registerBasicBlock("ir_bb");
    public static final RegistryObject<Block> IRON_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ir_gbb");
    public static final RegistryObject<Block> IRON_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("ir_sbb");
    public static final RegistryObject<Block> IRON_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("ir_stbb", IRON_GRAY_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WATER_BUILDING_BLOCK = registerBasicBlock("wa_bb");
    public static final RegistryObject<Block> WATER_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wa_gbb");
    public static final RegistryObject<Block> WATER_SLAB_BUILDING_BLOCK = registerSlabBlock("wa_sbb");
    public static final RegistryObject<Block> WATER_STAIRS_BUILDING_BLOCK = registerStairBlock("wa_stbb", WATER_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WHITE_BLUE_BUILDING_BLOCK = registerBasicBlock("wb_bb");
    public static final RegistryObject<Block> WHITE_BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wb_gbb");
    public static final RegistryObject<Block> WHITE_BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("wb_sbb");
    public static final RegistryObject<Block> WHITE_BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("wb_stbb", WHITE_BLUE_BUILDING_BLOCK);

    // 新增8个颜色方块系列（简写ID）
    public static final RegistryObject<Block> GRAY_NANDO_BUILDING_BLOCK = registerBasicBlock("gn_bb");
    public static final RegistryObject<Block> GRAY_NANDO_GLOWING_BUILDING_BLOCK = registerGlowingBlock("gn_gbb");
    public static final RegistryObject<Block> GRAY_NANDO_SLAB_BUILDING_BLOCK = registerSlabBlock("gn_sbb");
    public static final RegistryObject<Block> GRAY_NANDO_STAIRS_BUILDING_BLOCK = registerStairBlock("gn_stbb", GRAY_NANDO_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> SKY_BUILDING_BLOCK = registerBasicBlock("sk_bb");
    public static final RegistryObject<Block> SKY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sk_gbb");
    public static final RegistryObject<Block> SKY_SLAB_BUILDING_BLOCK = registerSlabBlock("sk_sbb");
    public static final RegistryObject<Block> SKY_STAIRS_BUILDING_BLOCK = registerStairBlock("sk_stbb", SKY_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BLUE_BUILDING_BLOCK = registerBasicBlock("bu_bb");
    public static final RegistryObject<Block> BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bu_gbb");
    public static final RegistryObject<Block> BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("bu_sbb");
    public static final RegistryObject<Block> BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("bu_stbb", BLUE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> LIGHT_BLUE_BUILDING_BLOCK = registerBasicBlock("lb_bb");
    public static final RegistryObject<Block> LIGHT_BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lb_gbb");
    public static final RegistryObject<Block> LIGHT_BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("lb_sbb");
    public static final RegistryObject<Block> LIGHT_BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("lb_stbb", LIGHT_BLUE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BLUE_COLOR_BUILDING_BLOCK = registerBasicBlock("bc_bb");
    public static final RegistryObject<Block> BLUE_COLOR_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bc_gbb");
    public static final RegistryObject<Block> BLUE_COLOR_SLAB_BUILDING_BLOCK = registerSlabBlock("bc_sbb");
    public static final RegistryObject<Block> BLUE_COLOR_STAIRS_BUILDING_BLOCK = registerStairBlock("bc_stbb", BLUE_COLOR_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> DARK_BLUE_BUILDING_BLOCK = registerBasicBlock("db_bb");
    public static final RegistryObject<Block> DARK_BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("db_gbb");
    public static final RegistryObject<Block> DARK_BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("db_sbb");
    public static final RegistryObject<Block> DARK_BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("db_stbb", DARK_BLUE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> FLOWER_BUILDING_BLOCK = registerBasicBlock("fl_bb");
    public static final RegistryObject<Block> FLOWER_GLOWING_BUILDING_BLOCK = registerGlowingBlock("fl_gbb");
    public static final RegistryObject<Block> FLOWER_SLAB_BUILDING_BLOCK = registerSlabBlock("fl_sbb");
    public static final RegistryObject<Block> FLOWER_STAIRS_BUILDING_BLOCK = registerStairBlock("fl_stbb", FLOWER_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> NAVY_VIOLET_BUILDING_BLOCK = registerBasicBlock("nv_bb");
    public static final RegistryObject<Block> NAVY_VIOLET_GLOWING_BUILDING_BLOCK = registerGlowingBlock("nv_gbb");
    public static final RegistryObject<Block> NAVY_VIOLET_SLAB_BUILDING_BLOCK = registerSlabBlock("nv_sbb");
    public static final RegistryObject<Block> NAVY_VIOLET_STAIRS_BUILDING_BLOCK = registerStairBlock("nv_stbb", NAVY_VIOLET_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> ULTRAMARINE_BUILDING_BLOCK = registerBasicBlock("ul_bb");
    public static final RegistryObject<Block> ULTRAMARINE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ul_gbb");
    public static final RegistryObject<Block> ULTRAMARINE_SLAB_BUILDING_BLOCK = registerSlabBlock("ul_sbb");
    public static final RegistryObject<Block> ULTRAMARINE_STAIRS_BUILDING_BLOCK = registerStairBlock("ul_stbb", ULTRAMARINE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WISTERIA_GRAY_BUILDING_BLOCK = registerBasicBlock("wgr_bb");
    public static final RegistryObject<Block> WISTERIA_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wgr_gbb");
    public static final RegistryObject<Block> WISTERIA_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("wgr_sbb");
    public static final RegistryObject<Block> WISTERIA_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("wgr_stbb", WISTERIA_GRAY_BUILDING_BLOCK);
    
    // 新增4个颜色方块系列（菖蒲色、葡萄、葡鼠、浓色）
    public static final RegistryObject<Block> CB_BUILDING_BLOCK = registerBasicBlock("cb_bb");
    public static final RegistryObject<Block> CB_GLOWING_BUILDING_BLOCK = registerGlowingBlock("cb_gbb");
    public static final RegistryObject<Block> CB_SLAB_BUILDING_BLOCK = registerSlabBlock("cb_sbb");
    public static final RegistryObject<Block> CB_STAIRS_BUILDING_BLOCK = registerStairBlock("cb_stbb", CB_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> PT_BUILDING_BLOCK = registerBasicBlock("pt_bb");
    public static final RegistryObject<Block> PT_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pt_gbb");
    public static final RegistryObject<Block> PT_SLAB_BUILDING_BLOCK = registerSlabBlock("pt_sbb");
    public static final RegistryObject<Block> PT_STAIRS_BUILDING_BLOCK = registerStairBlock("pt_stbb", PT_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> PS_BUILDING_BLOCK = registerBasicBlock("ps_bb");
    public static final RegistryObject<Block> PS_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ps_gbb");
    public static final RegistryObject<Block> PS_SLAB_BUILDING_BLOCK = registerSlabBlock("ps_sbb");
    public static final RegistryObject<Block> PS_STAIRS_BUILDING_BLOCK = registerStairBlock("ps_stbb", PS_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> NS_BUILDING_BLOCK = registerBasicBlock("ns_bb");
    public static final RegistryObject<Block> NS_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ns_gbb");
    public static final RegistryObject<Block> NS_SLAB_BUILDING_BLOCK = registerSlabBlock("ns_sbb");
    public static final RegistryObject<Block> NS_STAIRS_BUILDING_BLOCK = registerStairBlock("ns_stbb", NS_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WISTERIA_BUILDING_BLOCK = registerBasicBlock("wi_bb");
    public static final RegistryObject<Block> WISTERIA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wi_gbb");
    public static final RegistryObject<Block> WISTERIA_SLAB_BUILDING_BLOCK = registerSlabBlock("wi_sbb");
    public static final RegistryObject<Block> WISTERIA_STAIRS_BUILDING_BLOCK = registerStairBlock("wi_stbb", WISTERIA_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> WISTERIA_PURPLE_BUILDING_BLOCK = registerBasicBlock("wp_bb");
    public static final RegistryObject<Block> WISTERIA_PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wp_gbb");
    public static final RegistryObject<Block> WISTERIA_PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("wp_sbb");
    public static final RegistryObject<Block> WISTERIA_PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("wp_stbb", WISTERIA_PURPLE_BUILDING_BLOCK);

    // 新增4个颜色方块系列（简写ID）
    public static final RegistryObject<Block> DOVE_BUILDING_BLOCK = registerBasicBlock("dv_bb");
    public static final RegistryObject<Block> DOVE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dv_gbb");
    public static final RegistryObject<Block> DOVE_SLAB_BUILDING_BLOCK = registerSlabBlock("dv_sbb");
    public static final RegistryObject<Block> DOVE_STAIRS_BUILDING_BLOCK = registerStairBlock("dv_stbb", DOVE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> BLUE_PURPLE_BUILDING_BLOCK = registerBasicBlock("bp_bb");
    public static final RegistryObject<Block> BLUE_PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bp_gbb");
    public static final RegistryObject<Block> BLUE_PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("bp_sbb");
    public static final RegistryObject<Block> BLUE_PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("bp_stbb", BLUE_PURPLE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> EDO_PURPLE_BUILDING_BLOCK = registerBasicBlock("ep_bb");
    public static final RegistryObject<Block> EDO_PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ep_gbb");
    public static final RegistryObject<Block> EDO_PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("ep_sbb");
    public static final RegistryObject<Block> EDO_PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("ep_stbb", EDO_PURPLE_BUILDING_BLOCK);
    
    public static final RegistryObject<Block> PURPLE_BUILDING_BLOCK = registerBasicBlock("pu_bb");
    public static final RegistryObject<Block> PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pu_gbb");
    public static final RegistryObject<Block> PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("pu_sbb");
    public static final RegistryObject<Block> PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("pu_stbb", PURPLE_BUILDING_BLOCK);




    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}