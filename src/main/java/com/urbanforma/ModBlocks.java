package com.urbanforma;

import com.urbanforma.block.AntiCollisionLightBlock;
import com.urbanforma.block.BorderWallBlock;
import com.urbanforma.block.CeilingFloorBlock;
import com.urbanforma.block.CenterCrossGlassSeamBlock;
import com.urbanforma.block.CenterGlassSeamBlock;
import com.urbanforma.block.CenterHorizontalGlassSeamBlock;
import com.urbanforma.block.CornerBlock;
import com.urbanforma.block.DirectionalHeightRoadBlock;
import com.urbanforma.block.DirectionalRoadBlock;
import com.urbanforma.block.HeightRoadBlock;
import com.urbanforma.block.HorizontalLEDBlock;
import com.urbanforma.block.OfficeLightBlock;
import com.urbanforma.block.OfficeRoundLightBlock;
import com.urbanforma.block.PlayerFacingBlock;
import com.urbanforma.block.RedstoneClockBlock;
import com.urbanforma.block.SmartTextureBlock;
import com.urbanforma.block.ThinBorderWallBlock;
import com.urbanforma.block.ThinVerticalSlabBlock;
import com.urbanforma.block.UrbanGlassBlock;
import com.urbanforma.block.UrbanGlassPaneBlock;
import com.urbanforma.block.UrbanTintedGlassBlock;
import com.urbanforma.block.UrbanTintedGlassPaneBlock;
import com.urbanforma.block.VerticalLEDBlock;
import com.urbanforma.block.VerticalSlabBlock;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlocks {
   public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("urbanforma");
   public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("urbanforma");
   private static final Properties BASIC_PROPERTIES = Properties.of()
      .mapColor(MapColor.STONE)
      .strength(2.0F)
      .requiresCorrectToolForDrops()
      .sound(SoundType.STONE);
   private static final Properties GLOWING_PROPERTIES = Properties.of()
      .mapColor(MapColor.STONE)
      .strength(2.0F)
      .requiresCorrectToolForDrops()
      .sound(SoundType.STONE)
      .lightLevel(state -> 15);
   private static final Properties METAL_PROPERTIES = Properties.of()
      .mapColor(MapColor.METAL)
      .strength(2.0F)
      .requiresCorrectToolForDrops()
      .sound(SoundType.METAL);
   private static final Properties METAL_GLOWING_PROPERTIES = Properties.of()
      .mapColor(MapColor.METAL)
      .strength(2.0F)
      .requiresCorrectToolForDrops()
      .sound(SoundType.METAL)
      .lightLevel(state -> 15);
   public static final DeferredBlock<Block> WHITE_BUILDING_BLOCK = registerBasicBlock("w_bb");
   public static final DeferredBlock<Block> WHITE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("w_gbb");
   public static final DeferredBlock<Block> WHITE_SLAB_BUILDING_BLOCK = registerSlabBlock("w_sbb");
   public static final DeferredBlock<Block> WHITE_STAIRS_BUILDING_BLOCK = registerStairBlock("w_stbb", WHITE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WHITE_BORDER_WALL = registerBorderWallBlock("w_bb_border");
   public static final DeferredBlock<Block> WHITE_THIN_BORDER_WALL = registerThinBorderWallBlock("w_bb_thin_border");
   public static final DeferredBlock<Block> WHITE_VERTICAL_SLAB = registerVerticalSlabBlock("w_vertical_slab");
   public static final DeferredBlock<Block> WHITE_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("w_thin_vertical_slab");
   public static final DeferredBlock<Block> WHITE_CORNER_BLOCK = registerCornerBlock("w_corner");
   public static final DeferredBlock<Block> WHITE_CEILING_FLOOR = registerCeilingFloorBlock("white_ceiling_floor");
   public static final DeferredBlock<Block> SILVER_BUILDING_BLOCK = registerMetalBasicBlock("silver_bb");
   public static final DeferredBlock<Block> SILVER_GLOWING_BUILDING_BLOCK = registerMetalGlowingBlock("silver_gbb");
   public static final DeferredBlock<Block> SILVER_SLAB_BUILDING_BLOCK = registerMetalSlabBlock("silver_sbb");
   public static final DeferredBlock<Block> SILVER_STAIRS_BUILDING_BLOCK = registerMetalStairBlock("silver_stbb", SILVER_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SILVER_BORDER_WALL = registerBorderWallBlock("silver_bb_border");
   public static final DeferredBlock<Block> SILVER_THIN_BORDER_WALL = registerThinBorderWallBlock("silver_bb_thin_border");
   public static final DeferredBlock<Block> SILVER_VERTICAL_SLAB = registerVerticalSlabBlock("silver_vertical_slab");
   public static final DeferredBlock<Block> SILVER_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("silver_thin_vertical_slab");
   public static final DeferredBlock<Block> SILVER_CORNER_BLOCK = registerCornerBlock("silver_corner");
   public static final DeferredBlock<Block> SILVER_CEILING_FLOOR = registerCeilingFloorBlock("silver_ceiling_floor");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_CEILING_FLOOR = registerCeilingFloorBlock("light_gray_1_ceiling_floor");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_CEILING_FLOOR = registerCeilingFloorBlock("light_gray_2_ceiling_floor");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_CEILING_FLOOR = registerCeilingFloorBlock("light_gray_3_ceiling_floor");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_CEILING_FLOOR = registerCeilingFloorBlock("medium_gray_1_ceiling_floor");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_CEILING_FLOOR = registerCeilingFloorBlock("medium_gray_2_ceiling_floor");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_CEILING_FLOOR = registerCeilingFloorBlock("medium_gray_3_ceiling_floor");
   public static final DeferredBlock<Block> DARK_GRAY_1_CEILING_FLOOR = registerCeilingFloorBlock("dark_gray_1_ceiling_floor");
   public static final DeferredBlock<Block> DARK_GRAY_2_CEILING_FLOOR = registerCeilingFloorBlock("dark_gray_2_ceiling_floor");
   public static final DeferredBlock<Block> DARK_GRAY_3_CEILING_FLOOR = registerCeilingFloorBlock("dark_gray_3_ceiling_floor");
   public static final DeferredBlock<Block> DARK_GRAY_4_CEILING_FLOOR = registerCeilingFloorBlock("dark_gray_4_ceiling_floor");
   public static final DeferredBlock<Block> BLACKISH_GRAY_CEILING_FLOOR = registerCeilingFloorBlock("blackish_gray_ceiling_floor");
   public static final DeferredBlock<Block> BLACK_CEILING_FLOOR = registerCeilingFloorBlock("black_ceiling_floor");
   public static final DeferredBlock<Block> DENSE_GRAY_WHITE_CEILING_FLOOR = registerCeilingFloorBlock("dense_gray_white_ceiling_floor");
   public static final DeferredBlock<Block> IVORY_CEILING_FLOOR = registerCeilingFloorBlock("ivory_ceiling_floor");
   public static final DeferredBlock<Block> SPAWN_COLOR_CEILING_FLOOR = registerCeilingFloorBlock("spawn_color_ceiling_floor");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_BORDER_WALL = registerBorderWallBlock("lg_1_bb_border");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_THIN_BORDER_WALL = registerThinBorderWallBlock("lg_1_bb_thin_border");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_BORDER_WALL = registerBorderWallBlock("lg_2_bb_border");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_THIN_BORDER_WALL = registerThinBorderWallBlock("lg_2_bb_thin_border");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_BORDER_WALL = registerBorderWallBlock("lg_3_bb_border");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_THIN_BORDER_WALL = registerThinBorderWallBlock("lg_3_bb_thin_border");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_BORDER_WALL = registerBorderWallBlock("mg_1_bb_border");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_THIN_BORDER_WALL = registerThinBorderWallBlock("mg_1_bb_thin_border");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_BORDER_WALL = registerBorderWallBlock("mg_2_bb_border");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_THIN_BORDER_WALL = registerThinBorderWallBlock("mg_2_bb_thin_border");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_BORDER_WALL = registerBorderWallBlock("mg_3_bb_border");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_THIN_BORDER_WALL = registerThinBorderWallBlock("mg_3_bb_thin_border");
   public static final DeferredBlock<Block> DARK_GRAY_1_BORDER_WALL = registerBorderWallBlock("dg_1_bb_border");
   public static final DeferredBlock<Block> DARK_GRAY_1_THIN_BORDER_WALL = registerThinBorderWallBlock("dg_1_bb_thin_border");
   public static final DeferredBlock<Block> DARK_GRAY_2_BORDER_WALL = registerBorderWallBlock("dg_2_bb_border");
   public static final DeferredBlock<Block> DARK_GRAY_2_THIN_BORDER_WALL = registerThinBorderWallBlock("dg_2_bb_thin_border");
   public static final DeferredBlock<Block> DARK_GRAY_3_BORDER_WALL = registerBorderWallBlock("dg_3_bb_border");
   public static final DeferredBlock<Block> DARK_GRAY_3_THIN_BORDER_WALL = registerThinBorderWallBlock("dg_3_bb_thin_border");
   public static final DeferredBlock<Block> DARK_GRAY_4_BORDER_WALL = registerBorderWallBlock("dg_4_bb_border");
   public static final DeferredBlock<Block> DARK_GRAY_4_THIN_BORDER_WALL = registerThinBorderWallBlock("dg_4_bb_thin_border");
   public static final DeferredBlock<Block> BLACKISH_GRAY_BORDER_WALL = registerBorderWallBlock("bg_bb_border");
   public static final DeferredBlock<Block> BLACKISH_GRAY_THIN_BORDER_WALL = registerThinBorderWallBlock("bg_bb_thin_border");
   public static final DeferredBlock<Block> BLACK_BORDER_WALL = registerBorderWallBlock("b_bb_border");
   public static final DeferredBlock<Block> BLACK_THIN_BORDER_WALL = registerThinBorderWallBlock("b_bb_thin_border");
   public static final DeferredBlock<Block> WHITE_GLASS = registerBlock("w_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> WHITE_GLASS_PANE = registerBlock("w_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> WHITE_TINTED_GLASS = registerBlock("w_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> WHITE_TINTED_GLASS_PANE = registerBlock("w_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> CYAN_GLASS = registerBlock("bl_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> CYAN_GLASS_PANE = registerBlock("bl_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> CYAN_TINTED_GLASS = registerBlock("bl_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> CYAN_TINTED_GLASS_PANE = registerBlock("bl_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_1_GLASS = registerBlock("bl_g1_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_1_GLASS_PANE = registerBlock("bl_g1_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_1_TINTED_GLASS = registerBlock("bl_1_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_1_TINTED_GLASS_PANE = registerBlock("bl_1_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_2_GLASS = registerBlock("bl_g2_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_2_GLASS_PANE = registerBlock("bl_g2_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_2_TINTED_GLASS = registerBlock("bl_2_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> CYAN_LIGHT_2_TINTED_GLASS_PANE = registerBlock("bl_2_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> BLUE_TINTED_GLASS = registerBlock("bl_blue_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> BLUE_TINTED_GLASS_PANE = registerBlock("bl_blue_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_GLASS = registerBlock("bls_g3_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_GLASS_PANE = registerBlock("bls_g3_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_1_GLASS = registerBlock("bls_g3_1_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_1_GLASS_PANE = registerBlock("bls_g3_1_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_1_TINTED_GLASS = registerBlock("bls_g3_1_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_1_TINTED_GLASS_PANE = registerBlock("bls_g3_1_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_2_GLASS = registerBlock("bls_g3_2_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_2_GLASS_PANE = registerBlock("bls_g3_2_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_2_TINTED_GLASS = registerBlock("bls_g3_2_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_2_TINTED_GLASS_PANE = registerBlock("bls_g3_2_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_TINTED_GLASS = registerBlock("bl_light_blue_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> LIGHT_BLUE_TINTED_GLASS_PANE = registerBlock(
      "bl_light_blue_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock()
   );
   public static final DeferredBlock<Block> LIGHT_GRAY_1_GLASS = registerBlock("lg_1_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_1_GLASS_PANE = registerBlock("lg_1_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_1_TINTED_GLASS = registerBlock("lg_1_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_1_TINTED_GLASS_PANE = registerBlock("lg_1_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_2_GLASS = registerBlock("lg_2_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_2_GLASS_PANE = registerBlock("lg_2_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_2_TINTED_GLASS = registerBlock("lg_2_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_2_TINTED_GLASS_PANE = registerBlock("lg_2_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_3_GLASS = registerBlock("lg_3_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_3_GLASS_PANE = registerBlock("lg_3_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_3_TINTED_GLASS = registerBlock("lg_3_tinted_glass", () -> new UrbanTintedGlassBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_3_TINTED_GLASS_PANE = registerBlock("lg_3_tinted_glass_pane", () -> new UrbanTintedGlassPaneBlock());
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_GLASS = registerBlock("mg_1_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_GLASS_PANE = registerBlock("mg_1_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_GLASS = registerBlock("mg_2_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_GLASS_PANE = registerBlock("mg_2_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_GLASS = registerBlock("mg_3_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_GLASS_PANE = registerBlock("mg_3_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> DARK_GRAY_1_GLASS = registerBlock("dg_1_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> DARK_GRAY_1_GLASS_PANE = registerBlock("dg_1_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> DARK_GRAY_2_GLASS = registerBlock("dg_2_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> DARK_GRAY_2_GLASS_PANE = registerBlock("dg_2_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> DARK_GRAY_3_GLASS = registerBlock("dg_3_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> DARK_GRAY_3_GLASS_PANE = registerBlock("dg_3_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> DARK_GRAY_4_GLASS = registerBlock("dg_4_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> DARK_GRAY_4_GLASS_PANE = registerBlock("dg_4_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> BLACKISH_GRAY_GLASS = registerBlock("bgr_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> BLACKISH_GRAY_GLASS_PANE = registerBlock("bgr_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> BLACK_GLASS = registerBlock("bla_glass", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> BLACK_GLASS_PANE = registerBlock("bla_glass_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> LIGHT_GRAY_1_BUILDING_BLOCK = registerBasicBlock("lg_1_bb");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lg_1_gbb");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_SLAB_BUILDING_BLOCK = registerSlabBlock("lg_1_sbb");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_STAIRS_BUILDING_BLOCK = registerStairBlock("lg_1_stbb", LIGHT_GRAY_1_BUILDING_BLOCK);
   public static final DeferredBlock<Block> LIGHT_GRAY_1_VERTICAL_SLAB = registerVerticalSlabBlock("lg_1_vertical_slab");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("lg_1_thin_vertical_slab");
   public static final DeferredBlock<Block> LIGHT_GRAY_1_CORNER_BLOCK = registerCornerBlock("lg_1_corner");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_BUILDING_BLOCK = registerBasicBlock("lg_2_bb");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lg_2_gbb");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_SLAB_BUILDING_BLOCK = registerSlabBlock("lg_2_sbb");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_STAIRS_BUILDING_BLOCK = registerStairBlock("lg_2_stbb", LIGHT_GRAY_2_BUILDING_BLOCK);
   public static final DeferredBlock<Block> LIGHT_GRAY_2_VERTICAL_SLAB = registerVerticalSlabBlock("lg_2_vertical_slab");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("lg_2_thin_vertical_slab");
   public static final DeferredBlock<Block> LIGHT_GRAY_2_CORNER_BLOCK = registerCornerBlock("lg_2_corner");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_BUILDING_BLOCK = registerBasicBlock("lg_3_bb");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lg_3_gbb");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_SLAB_BUILDING_BLOCK = registerSlabBlock("lg_3_sbb");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_STAIRS_BUILDING_BLOCK = registerStairBlock("lg_3_stbb", LIGHT_GRAY_3_BUILDING_BLOCK);
   public static final DeferredBlock<Block> LIGHT_GRAY_3_VERTICAL_SLAB = registerVerticalSlabBlock("lg_3_vertical_slab");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("lg_3_thin_vertical_slab");
   public static final DeferredBlock<Block> LIGHT_GRAY_3_CORNER_BLOCK = registerCornerBlock("lg_3_corner");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_BUILDING_BLOCK = registerBasicBlock("mg_1_bb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mg_1_gbb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_SLAB_BUILDING_BLOCK = registerSlabBlock("mg_1_sbb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_STAIRS_BUILDING_BLOCK = registerStairBlock("mg_1_stbb", MEDIUM_GRAY_1_BUILDING_BLOCK);
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_VERTICAL_SLAB = registerVerticalSlabBlock("mg_1_vertical_slab");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("mg_1_thin_vertical_slab");
   public static final DeferredBlock<Block> MEDIUM_GRAY_1_CORNER_BLOCK = registerCornerBlock("mg_1_corner");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_BUILDING_BLOCK = registerBasicBlock("mg_2_bb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mg_2_gbb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_SLAB_BUILDING_BLOCK = registerSlabBlock("mg_2_sbb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_STAIRS_BUILDING_BLOCK = registerStairBlock("mg_2_stbb", MEDIUM_GRAY_2_BUILDING_BLOCK);
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_VERTICAL_SLAB = registerVerticalSlabBlock("mg_2_vertical_slab");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("mg_2_thin_vertical_slab");
   public static final DeferredBlock<Block> MEDIUM_GRAY_2_CORNER_BLOCK = registerCornerBlock("mg_2_corner");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_BUILDING_BLOCK = registerBasicBlock("mg_3_bb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mg_3_gbb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_SLAB_BUILDING_BLOCK = registerSlabBlock("mg_3_sbb");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_STAIRS_BUILDING_BLOCK = registerStairBlock("mg_3_stbb", MEDIUM_GRAY_3_BUILDING_BLOCK);
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_VERTICAL_SLAB = registerVerticalSlabBlock("mg_3_vertical_slab");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("mg_3_thin_vertical_slab");
   public static final DeferredBlock<Block> MEDIUM_GRAY_3_CORNER_BLOCK = registerCornerBlock("mg_3_corner");
   public static final DeferredBlock<Block> DARK_GRAY_1_BUILDING_BLOCK = registerBasicBlock("dg_1_bb");
   public static final DeferredBlock<Block> DARK_GRAY_1_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_1_gbb");
   public static final DeferredBlock<Block> DARK_GRAY_1_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_1_sbb");
   public static final DeferredBlock<Block> DARK_GRAY_1_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_1_stbb", DARK_GRAY_1_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DARK_GRAY_1_VERTICAL_SLAB = registerVerticalSlabBlock("dg_1_vertical_slab");
   public static final DeferredBlock<Block> DARK_GRAY_1_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("dg_1_thin_vertical_slab");
   public static final DeferredBlock<Block> DARK_GRAY_1_CORNER_BLOCK = registerCornerBlock("dg_1_corner");
   public static final DeferredBlock<Block> DARK_GRAY_2_BUILDING_BLOCK = registerBasicBlock("dg_2_bb");
   public static final DeferredBlock<Block> DARK_GRAY_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_2_gbb");
   public static final DeferredBlock<Block> DARK_GRAY_2_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_2_sbb");
   public static final DeferredBlock<Block> DARK_GRAY_2_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_2_stbb", DARK_GRAY_2_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DARK_GRAY_2_VERTICAL_SLAB = registerVerticalSlabBlock("dg_2_vertical_slab");
   public static final DeferredBlock<Block> DARK_GRAY_2_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("dg_2_thin_vertical_slab");
   public static final DeferredBlock<Block> DARK_GRAY_2_CORNER_BLOCK = registerCornerBlock("dg_2_corner");
   public static final DeferredBlock<Block> DARK_GRAY_3_BUILDING_BLOCK = registerBasicBlock("dg_3_bb");
   public static final DeferredBlock<Block> DARK_GRAY_3_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_3_gbb");
   public static final DeferredBlock<Block> DARK_GRAY_3_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_3_sbb");
   public static final DeferredBlock<Block> DARK_GRAY_3_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_3_stbb", DARK_GRAY_3_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DARK_GRAY_3_VERTICAL_SLAB = registerVerticalSlabBlock("dg_3_vertical_slab");
   public static final DeferredBlock<Block> DARK_GRAY_3_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("dg_3_thin_vertical_slab");
   public static final DeferredBlock<Block> DARK_GRAY_3_CORNER_BLOCK = registerCornerBlock("dg_3_corner");
   public static final DeferredBlock<Block> DARK_GRAY_4_BUILDING_BLOCK = registerBasicBlock("dg_4_bb");
   public static final DeferredBlock<Block> DARK_GRAY_4_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dg_4_gbb");
   public static final DeferredBlock<Block> DARK_GRAY_4_SLAB_BUILDING_BLOCK = registerSlabBlock("dg_4_sbb");
   public static final DeferredBlock<Block> DARK_GRAY_4_STAIRS_BUILDING_BLOCK = registerStairBlock("dg_4_stbb", DARK_GRAY_4_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DARK_GRAY_4_VERTICAL_SLAB = registerVerticalSlabBlock("dg_4_vertical_slab");
   public static final DeferredBlock<Block> ROAD_STONE_1 = registerBasicBlock("z_46");
   public static final DeferredBlock<Block> ROAD_STONE_2 = registerBasicBlock("z_47");
   public static final DeferredBlock<Block> ROAD_STONE_3 = registerBasicBlock("z_48");
   public static final DeferredBlock<Block> CEMENT_1 = registerBasicBlock("z_49");
   public static final DeferredBlock<Block> CEMENT_2 = registerBasicBlock("z_50");
   public static final DeferredBlock<Block> CEMENT_3 = registerBasicBlock("z_51");
   public static final DeferredBlock<Block> CEMENT_4 = registerBasicBlock("z_52");
   public static final DeferredBlock<Block> CEMENT_5 = registerBasicBlock("z_53");
   public static final DeferredBlock<Block> CEMENT_6 = registerBasicBlock("z_54");
   public static final DeferredBlock<Block> FLOOR_1 = registerBasicBlock("z_55");
   public static final DeferredBlock<Block> FLOOR_2 = registerBasicBlock("z_56");
   public static final DeferredBlock<Block> FLOOR_3 = registerBasicBlock("z_57");
   public static final DeferredBlock<Block> FLOOR_4 = registerBasicBlock("z_58");
   public static final DeferredBlock<Block> FLOOR_5 = registerBasicBlock("z_59");
   public static final DeferredBlock<Block> FLOOR_6 = registerBasicBlock("z_60");
   public static final DeferredBlock<Block> FLOOR_7 = registerBasicBlock("z_61");
   public static final DeferredBlock<Block> FLOOR_8 = registerBasicBlock("z_62");
   public static final DeferredBlock<Block> FLOOR_9 = registerBasicBlock("z_63");
   public static final DeferredBlock<Block> FLOOR_10 = registerBasicBlock("z_64");
   public static final DeferredBlock<Block> WOOD_PLANK_1 = registerBasicBlock("z_65");
   public static final DeferredBlock<Block> WOOD_PLANK_2 = registerBasicBlock("z_66");
   public static final DeferredBlock<Block> WOOD_PLANK_3 = registerBasicBlock("z_67");
   public static final DeferredBlock<Block> WOOD_FLOOR_1 = registerBasicBlock("z_68");
   public static final DeferredBlock<Block> WOOD_FLOOR_2 = registerBasicBlock("z_69");
   public static final DeferredBlock<Block> WOOD_FLOOR_3 = registerBasicBlock("z_70");
   public static final DeferredBlock<Block> WOOD_FLOOR_4 = registerBasicBlock("z_71");
   public static final DeferredBlock<Block> WOOD_FLOOR_5 = registerBasicBlock("z_72");
   public static final DeferredBlock<Block> WOOD_FLOOR_6 = registerBasicBlock("z_76");
   public static final DeferredBlock<Block> WOOD_FLOOR_7 = registerBasicBlock("z_77");
   public static final DeferredBlock<Block> WOOD_FLOOR_8 = registerBasicBlock("z_78");
   public static final DeferredBlock<Block> WOOD_FLOOR_9 = registerBasicBlock("z_79");
   public static final DeferredBlock<Block> WOOD_FLOOR_10 = registerBasicBlock("z_80");
   public static final DeferredBlock<Block> WOOD_FLOOR_11 = registerBasicBlock("z_81");
   public static final DeferredBlock<Block> WOOD_FLOOR_12 = registerBasicBlock("z_82");
   public static final DeferredBlock<Block> WALLPAPER_1 = registerBasicBlock("z_83");
   public static final DeferredBlock<Block> WALLPAPER_2 = registerBasicBlock("z_84");
   public static final DeferredBlock<Block> WALLPAPER_3 = registerBasicBlock("z_85");
   public static final DeferredBlock<Block> WALLPAPER_4 = registerBasicBlock("z_86");
   public static final DeferredBlock<Block> WALLPAPER_5 = registerBasicBlock("z_87");
   public static final DeferredBlock<Block> WALLPAPER_6 = registerBasicBlock("z_88");
   public static final DeferredBlock<Block> WALLPAPER_7 = registerBasicBlock("z_89");
   public static final DeferredBlock<Block> OTHER_1 = registerBasicBlock("z_90");
   public static final DeferredBlock<Block> OTHER_2 = registerBasicBlock("z_91");
   public static final DeferredBlock<Block> OTHER_3 = registerBasicBlock("z_92");
   public static final DeferredBlock<Block> OTHER_4 = registerBasicBlock("z_93");
   public static final DeferredBlock<Block> OTHER_5 = registerBasicBlock("z_94");
   public static final DeferredBlock<Block> OTHER_6 = registerBasicBlock("z_95");
   public static final DeferredBlock<Block> OTHER_7 = registerBasicBlock("z_96");
   public static final DeferredBlock<Block> OTHER_8 = registerBasicBlock("z_97");
   public static final DeferredBlock<Block> OTHER_9 = registerBasicBlock("z_98");
   public static final DeferredBlock<Block> OTHER_10 = registerBasicBlock("z_99");
   public static final DeferredBlock<Block> OTHER_11 = registerBasicBlock("z_100");
   public static final DeferredBlock<Block> OTHER_12 = registerBasicBlock("z_101");
   public static final DeferredBlock<Block> OTHER_13 = registerBasicBlock("z_102");
   public static final DeferredBlock<Block> OTHER_14 = registerBasicBlock("z_103");
   public static final DeferredBlock<Block> OTHER_15 = registerBasicBlock("z_104");
   public static final DeferredBlock<Block> OTHER_16 = registerBasicBlock("z_105");
   public static final DeferredBlock<Block> METAL_1 = registerBasicBlock("zs_1");
   public static final DeferredBlock<Block> METAL_2 = registerBasicBlock("zs_2");
   public static final DeferredBlock<Block> METAL_3 = registerBasicBlock("zs_3");
   public static final DeferredBlock<Block> METAL_4 = registerBasicBlock("zs_4");
   public static final DeferredBlock<Block> METAL_5 = registerBasicBlock("zs_5");
   public static final DeferredBlock<Block> METAL_6 = registerBasicBlock("zs_6");
   public static final DeferredBlock<Block> METAL_7 = registerBasicBlock("zs_7");
   public static final DeferredBlock<Block> METAL_8 = registerBasicBlock("zs_8");
   public static final DeferredBlock<Block> METAL_9 = registerBasicBlock("zs_9");
   public static final DeferredBlock<Block> TERRAZZO_7 = registerBasicBlock("zs_10");
   public static final DeferredBlock<Block> TERRAZZO_8 = registerBasicBlock("zs_11");
   public static final DeferredBlock<Block> TERRAZZO_9 = registerBasicBlock("zs_12");
   public static final DeferredBlock<Block> TERRAZZO_10 = registerBasicBlock("zs_13");
   public static final DeferredBlock<Block> TERRAZZO_11 = registerBasicBlock("zs_14");
   public static final DeferredBlock<Block> TERRAZZO_12 = registerBasicBlock("zs_15");
   public static final DeferredBlock<Block> FLOOR_11 = registerBasicBlock("zs_16");
   public static final DeferredBlock<Block> LEATHER_1 = registerBasicBlock("z_73");
   public static final DeferredBlock<Block> LEATHER_2 = registerBasicBlock("z_74");
   public static final DeferredBlock<Block> LEATHER_3 = registerBasicBlock("z_75");
   public static final DeferredBlock<Block> DARK_GRAY_4_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("dg_4_thin_vertical_slab");
   public static final DeferredBlock<Block> OFFICE_LIGHT_STRIP_5000K = registerOfficeLightBlock("office_light_strip_5000k");
   public static final DeferredBlock<Block> OFFICE_LIGHT_STRIP_3500K = registerOfficeLightBlock("office_light_strip_3500k");
   public static final DeferredBlock<Block> OFFICE_LIGHT_STRIP_4500K = registerOfficeLightBlock("office_light_strip_4500k");
   public static final DeferredBlock<Block> OFFICE_LIGHT_STRIP_6000K = registerOfficeLightBlock("office_light_strip_6000k");
   public static final DeferredBlock<Block> OFFICE_LIGHT_STRIP_7000K = registerOfficeLightBlock("office_light_strip_7000k");
   public static final DeferredBlock<Block> OFFICE_ROUND_LIGHT_5000K = registerOfficeRoundLightBlock("office_round_light_5000k");
   public static final DeferredBlock<Block> DARK_GRAY_4_CORNER_BLOCK = registerCornerBlock("dg_4_corner");
   public static final DeferredBlock<Block> BLACKISH_GRAY_BUILDING_BLOCK = registerBasicBlock("bg_bb");
   public static final DeferredBlock<Block> BLACKISH_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bg_gbb");
   public static final DeferredBlock<Block> BLACKISH_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("bg_sbb");
   public static final DeferredBlock<Block> BLACKISH_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("bg_stbb", BLACKISH_GRAY_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLACKISH_GRAY_VERTICAL_SLAB = registerVerticalSlabBlock("bg_vertical_slab");
   public static final DeferredBlock<Block> BLACKISH_GRAY_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("bg_thin_vertical_slab");
   public static final DeferredBlock<Block> BLACKISH_GRAY_CORNER_BLOCK = registerCornerBlock("bg_corner");
   public static final DeferredBlock<Block> BLACK_BUILDING_BLOCK = registerBasicBlock("b_bb");
   public static final DeferredBlock<Block> BLACK_GLOWING_BUILDING_BLOCK = registerGlowingBlock("b_gbb");
   public static final DeferredBlock<Block> BLACK_SLAB_BUILDING_BLOCK = registerSlabBlock("b_sbb");
   public static final DeferredBlock<Block> BLACK_STAIRS_BUILDING_BLOCK = registerStairBlock("b_stbb", BLACK_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLACK_VERTICAL_SLAB = registerVerticalSlabBlock("b_vertical_slab");
   public static final DeferredBlock<Block> BLACK_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("b_thin_vertical_slab");
   public static final DeferredBlock<Block> BLACK_CORNER_BLOCK = registerCornerBlock("b_corner");
   public static final DeferredBlock<Block> ROAD_A_GRAY = registerBasicBlock("r_gray");
   public static final DeferredBlock<Block> ROAD_A_GRAY_GLOWING = registerGlowingBlock("r_gray_g");
   public static final DeferredBlock<Block> ROAD_A_GRAY_SLAB = registerSlabBlock("r_gray_s");
   public static final DeferredBlock<Block> ROAD_A_LIGHT_GRAY = registerBasicBlock("r_lgray");
   public static final DeferredBlock<Block> ROAD_A_LIGHT_GRAY_GLOWING = registerGlowingBlock("r_lgray_g");
   public static final DeferredBlock<Block> ROAD_A_LIGHT_GRAY_SLAB = registerSlabBlock("r_lgray_s");
   public static final DeferredBlock<Block> ROAD_A_WHITE = registerBasicBlock("r_white");
   public static final DeferredBlock<Block> ROAD_A_WHITE_GLOWING = registerGlowingBlock("r_white_g");
   public static final DeferredBlock<Block> ROAD_A_WHITE_SLAB = registerSlabBlock("r_white_s");
   public static final DeferredBlock<Block> ROAD_A_WHITE_LINE = registerBlock("r_wl1", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE = registerBlock("r_wl2", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_COMPENSATION = registerBlock("r_wl3", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_ZEBRA = registerBlock("r_wl4", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_CROSS = registerBlock("r_wl5", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_T_LINE = registerBlock("r_wl6", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_CORNER = registerBlock("r_wl7", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION = registerBlock("r_wl8", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_REVERSE = registerBlock(
      "r_wl9", () -> new DirectionalRoadBlock(BASIC_PROPERTIES)
   );
   public static final DeferredBlock<Block> ROAD_A_WHITE_LINE_END_1 = registerBlock("r_wl10", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_LINE_END_2 = registerBlock("r_wl11", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION = registerBlock(
      "r_wl12", () -> new DirectionalRoadBlock(BASIC_PROPERTIES)
   );
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_REVERSE = registerBlock(
      "r_wl13", () -> new DirectionalRoadBlock(BASIC_PROPERTIES)
   );
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION = registerBlock(
      "r_wl14", () -> new DirectionalRoadBlock(BASIC_PROPERTIES)
   );
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CONNECTION_EXTENSION_COMPENSATION_REVERSE = registerBlock(
      "r_wl15", () -> new DirectionalRoadBlock(BASIC_PROPERTIES)
   );
   public static final DeferredBlock<Block> ROAD_A_WHITE_CORNER_LINE = registerBlock("r_wl16", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_CORNER_LINE_REVERSE = registerBlock("r_wl17", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_THICK_BORDER = registerBlock("r_wl1a", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_BORDER = registerBlock("r_wl1b", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_THIN_BORDER = registerBlock("r_wl1c", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_SMALL_CURVE = registerBlock("r_wl18", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_MEDIUM_CURVE_1 = registerBlock("r_wl19", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_MEDIUM_CURVE_1_REVERSE = registerBlock("r_wl20", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_MEDIUM_CURVE_2 = registerBlock("r_wl21", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_MEDIUM_CURVE_2_REVERSE = registerBlock("r_wl22", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_1 = registerBlock("r_wl23", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_1_REVERSE = registerBlock("r_wl24", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_2 = registerBlock("r_wl25", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_2_REVERSE = registerBlock("r_wl26", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_3 = registerBlock("r_wl27", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_3_REVERSE = registerBlock("r_wl28", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_4 = registerBlock("r_wl29", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_45_DEGREE_CURVE_4_REVERSE = registerBlock("r_wl30", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_LARGE_CURVE_1 = registerBlock("r_wl31", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_LARGE_CURVE_1_REVERSE = registerBlock("r_wl32", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_LARGE_CURVE_2 = registerBlock("r_wl33", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_LARGE_CURVE_2_REVERSE = registerBlock("r_wl34", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_A_WHITE_LARGE_CURVE_3 = registerBlock("r_wl35", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_GRAY_H7 = registerHeightRoadBlock("r_gray_h7", 14.0F);
   public static final DeferredBlock<Block> ROAD_GRAY_H6 = registerHeightRoadBlock("r_gray_h6", 12.0F);
   public static final DeferredBlock<Block> ROAD_GRAY_H5 = registerHeightRoadBlock("r_gray_h5", 10.0F);
   public static final DeferredBlock<Block> ROAD_GRAY_H4 = registerHeightRoadBlock("r_gray_h4", 8.0F);
   public static final DeferredBlock<Block> ROAD_GRAY_H3 = registerHeightRoadBlock("r_gray_h3", 6.0F);
   public static final DeferredBlock<Block> ROAD_GRAY_H2 = registerHeightRoadBlock("r_gray_h2", 4.0F);
   public static final DeferredBlock<Block> ROAD_GRAY_H1 = registerHeightRoadBlock("r_gray_h1", 2.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H7 = registerDirectionalHeightRoadBlock("r_wl_h7", 14.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H6 = registerDirectionalHeightRoadBlock("r_wl_h6", 12.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H5 = registerDirectionalHeightRoadBlock("r_wl_h5", 10.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H4 = registerDirectionalHeightRoadBlock("r_wl_h4", 8.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H3 = registerDirectionalHeightRoadBlock("r_wl_h3", 6.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H2 = registerDirectionalHeightRoadBlock("r_wl_h2", 4.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_H1 = registerDirectionalHeightRoadBlock("r_wl_h1", 2.0F);
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_HEAD_3X = registerBlock("r_xt1x", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_HEAD_6X = registerBlock("r_xt2x", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_HEAD_3X_REVERSE = registerBlock("r_xt1xd", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_WHITE_LINE_HEAD_6X_REVERSE = registerBlock("r_xt2xd", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_DOUBLE_WHITE_LINE = registerBlock("r_ll1", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_WHITE_DASHED_LINE = registerBlock("r_x", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_WHITE_DECELERATION_LINE = registerBlock("r_js1", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_WHITE_DECELERATION_LINE_REVERSE = registerBlock("r_js2", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_YELLOW_DECELERATION_CONNECTION = registerBlock("r_l1_yj", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_YELLOW_CENTER_LINE = registerBlock("r_l1_y", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_DOUBLE_YELLOW_LINE = registerBlock("r_ll1_y", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> ROAD_YELLOW_DASHED_LINE = registerBlock("r_x_y", () -> new DirectionalRoadBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> N_HB_BUILDING_BLOCK = registerBasicBlock("n_hb_bb");
   public static final DeferredBlock<Block> N_HB_GLOWING_BUILDING_BLOCK = registerGlowingBlock("n_hb_gbb");
   public static final DeferredBlock<Block> N_HB_SLAB_BUILDING_BLOCK = registerSlabBlock("n_hb_sbb");
   public static final DeferredBlock<Block> N_HB_STAIRS_BUILDING_BLOCK = registerStairBlock("n_hb_stbb", N_HB_BUILDING_BLOCK);
   public static final DeferredBlock<Block> N_HB_VERTICAL_SLAB = registerVerticalSlabBlock("n_hb_vertical_slab");
   public static final DeferredBlock<Block> N_HB_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("n_hb_thin_vertical_slab");
   public static final DeferredBlock<Block> N_HB_CORNER_BLOCK = registerCornerBlock("n_hb_corner");
   public static final DeferredBlock<Block> N_HB_BORDER_WALL = registerBorderWallBlock("n_hb_bb_border");
   public static final DeferredBlock<Block> N_HB_THIN_BORDER_WALL = registerThinBorderWallBlock("n_hb_bb_thin_border");
   public static final DeferredBlock<Block> XY_BUILDING_BLOCK = registerBasicBlock("xy_bb");
   public static final DeferredBlock<Block> XY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("xy_gbb");
   public static final DeferredBlock<Block> XY_SLAB_BUILDING_BLOCK = registerSlabBlock("xy_sbb");
   public static final DeferredBlock<Block> XY_STAIRS_BUILDING_BLOCK = registerStairBlock("xy_stbb", XY_BUILDING_BLOCK);
   public static final DeferredBlock<Block> XY_VERTICAL_SLAB = registerVerticalSlabBlock("xy_vertical_slab");
   public static final DeferredBlock<Block> XY_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("xy_thin_vertical_slab");
   public static final DeferredBlock<Block> XY_CORNER_BLOCK = registerCornerBlock("xy_corner");
   public static final DeferredBlock<Block> XY_BORDER_WALL = registerBorderWallBlock("xy_bb_border");
   public static final DeferredBlock<Block> XY_THIN_BORDER_WALL = registerThinBorderWallBlock("xy_bb_thin_border");
   public static final DeferredBlock<Block> SC_BUILDING_BLOCK = registerBasicBlock("sc_bb");
   public static final DeferredBlock<Block> SC_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sc_gbb");
   public static final DeferredBlock<Block> SC_SLAB_BUILDING_BLOCK = registerSlabBlock("sc_sbb");
   public static final DeferredBlock<Block> SC_STAIRS_BUILDING_BLOCK = registerStairBlock("sc_stbb", SC_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SC_VERTICAL_SLAB = registerVerticalSlabBlock("sc_vertical_slab");
   public static final DeferredBlock<Block> SC_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("sc_thin_vertical_slab");
   public static final DeferredBlock<Block> SC_CORNER_BLOCK = registerCornerBlock("sc_corner");
   public static final DeferredBlock<Block> SC_BORDER_WALL = registerBorderWallBlock("sc_bb_border");
   public static final DeferredBlock<Block> SC_THIN_BORDER_WALL = registerThinBorderWallBlock("sc_bb_thin_border");
   public static final DeferredBlock<Block> YH_BUILDING_BLOCK = registerBasicBlock("yh_bb");
   public static final DeferredBlock<Block> YH_GLOWING_BUILDING_BLOCK = registerGlowingBlock("yh_gbb");
   public static final DeferredBlock<Block> YH_SLAB_BUILDING_BLOCK = registerSlabBlock("yh_sbb");
   public static final DeferredBlock<Block> YH_STAIRS_BUILDING_BLOCK = registerStairBlock("yh_stbb", YH_BUILDING_BLOCK);
   public static final DeferredBlock<Block> YH_BORDER_WALL = registerBorderWallBlock("yh_bb_border");
   public static final DeferredBlock<Block> YH_THIN_BORDER_WALL = registerThinBorderWallBlock("yh_bb_thin_border");
   public static final DeferredBlock<Block> YH_VERTICAL_SLAB = registerVerticalSlabBlock("yh_vertical_slab");
   public static final DeferredBlock<Block> YH_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("yh_thin_vertical_slab");
   public static final DeferredBlock<Block> YH_CORNER_BLOCK = registerCornerBlock("yh_corner");
   public static final DeferredBlock<Block> YH_CEILING_FLOOR = registerBlock("yh_ceiling_floor", () -> new CeilingFloorBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> TB_BUILDING_BLOCK = registerBasicBlock("tb_bb");
   public static final DeferredBlock<Block> TB_GLOWING_BUILDING_BLOCK = registerGlowingBlock("tb_gbb");
   public static final DeferredBlock<Block> TB_SLAB_BUILDING_BLOCK = registerSlabBlock("tb_sbb");
   public static final DeferredBlock<Block> TB_STAIRS_BUILDING_BLOCK = registerStairBlock("tb_stbb", TB_BUILDING_BLOCK);
   public static final DeferredBlock<Block> TB_BORDER_WALL = registerBorderWallBlock("tb_bb_border");
   public static final DeferredBlock<Block> TB_THIN_BORDER_WALL = registerThinBorderWallBlock("tb_bb_thin_border");
   public static final DeferredBlock<Block> TB_VERTICAL_SLAB = registerVerticalSlabBlock("tb_vertical_slab");
   public static final DeferredBlock<Block> TB_THIN_VERTICAL_SLAB = registerThinVerticalSlabBlock("tb_thin_vertical_slab");
   public static final DeferredBlock<Block> TB_CORNER_BLOCK = registerCornerBlock("tb_corner");
   public static final DeferredBlock<Block> TB_CEILING_FLOOR = registerBlock("tb_ceiling_floor", () -> new CeilingFloorBlock(BASIC_PROPERTIES));
   public static final DeferredBlock<Block> SH_BUILDING_BLOCK = registerBasicBlock("sh_bb");
   public static final DeferredBlock<Block> SH_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sh_gbb");
   public static final DeferredBlock<Block> SH_SLAB_BUILDING_BLOCK = registerSlabBlock("sh_sbb");
   public static final DeferredBlock<Block> SH_STAIRS_BUILDING_BLOCK = registerStairBlock("sh_stbb", SH_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BK_BUILDING_BLOCK = registerBasicBlock("bk_bb");
   public static final DeferredBlock<Block> BK_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bk_gbb");
   public static final DeferredBlock<Block> BK_SLAB_BUILDING_BLOCK = registerSlabBlock("bk_sbb");
   public static final DeferredBlock<Block> BK_STAIRS_BUILDING_BLOCK = registerStairBlock("bk_stbb", BK_BUILDING_BLOCK);
   public static final DeferredBlock<Block> T_BUILDING_BLOCK = registerBasicBlock("t_bb");
   public static final DeferredBlock<Block> T_GLOWING_BUILDING_BLOCK = registerGlowingBlock("t_gbb");
   public static final DeferredBlock<Block> T_SLAB_BUILDING_BLOCK = registerSlabBlock("t_sbb");
   public static final DeferredBlock<Block> T_STAIRS_BUILDING_BLOCK = registerStairBlock("t_stbb", T_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BRM_BUILDING_BLOCK = registerBasicBlock("brm_bb");
   public static final DeferredBlock<Block> BRM_GLOWING_BUILDING_BLOCK = registerGlowingBlock("brm_gbb");
   public static final DeferredBlock<Block> BRM_SLAB_BUILDING_BLOCK = registerSlabBlock("brm_sbb");
   public static final DeferredBlock<Block> BRM_STAIRS_BUILDING_BLOCK = registerStairBlock("brm_stbb", BRM_BUILDING_BLOCK);
   public static final DeferredBlock<Block> AZ_BUILDING_BLOCK = registerBasicBlock("az_bb");
   public static final DeferredBlock<Block> AZ_GLOWING_BUILDING_BLOCK = registerGlowingBlock("az_gbb");
   public static final DeferredBlock<Block> AZ_SLAB_BUILDING_BLOCK = registerSlabBlock("az_sbb");
   public static final DeferredBlock<Block> AZ_STAIRS_BUILDING_BLOCK = registerStairBlock("az_stbb", AZ_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PN_BUILDING_BLOCK = registerBasicBlock("pn_bb");
   public static final DeferredBlock<Block> PN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pn_gbb");
   public static final DeferredBlock<Block> PN_SLAB_BUILDING_BLOCK = registerSlabBlock("pn_sbb");
   public static final DeferredBlock<Block> PN_STAIRS_BUILDING_BLOCK = registerStairBlock("pn_stbb", PN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> QW_BUILDING_BLOCK = registerBasicBlock("qw_bb");
   public static final DeferredBlock<Block> QW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("qw_gbb");
   public static final DeferredBlock<Block> QW_SLAB_BUILDING_BLOCK = registerSlabBlock("qw_sbb");
   public static final DeferredBlock<Block> QW_STAIRS_BUILDING_BLOCK = registerStairBlock("qw_stbb", QW_BUILDING_BLOCK);
   public static final DeferredBlock<Block> RED_BUILDING_BLOCK = registerBasicBlock("r_bb");
   public static final DeferredBlock<Block> RED_GLOWING_BUILDING_BLOCK = registerGlowingBlock("r_gbb");
   public static final DeferredBlock<Block> RED_SLAB_BUILDING_BLOCK = registerSlabBlock("r_sbb");
   public static final DeferredBlock<Block> RED_STAIRS_BUILDING_BLOCK = registerStairBlock("r_stbb", RED_BUILDING_BLOCK);
   public static final DeferredBlock<Block> RED_VERMILLION_BUILDING_BLOCK = registerBasicBlock("rv_bb");
   public static final DeferredBlock<Block> RED_VERMILLION_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rv_gbb");
   public static final DeferredBlock<Block> RED_VERMILLION_SLAB_BUILDING_BLOCK = registerSlabBlock("rv_sbb");
   public static final DeferredBlock<Block> RED_VERMILLION_STAIRS_BUILDING_BLOCK = registerStairBlock("rv_stbb", RED_VERMILLION_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SCARLET_BUILDING_BLOCK = registerBasicBlock("s_bb");
   public static final DeferredBlock<Block> SCARLET_GLOWING_BUILDING_BLOCK = registerGlowingBlock("s_gbb");
   public static final DeferredBlock<Block> SCARLET_SLAB_BUILDING_BLOCK = registerSlabBlock("s_sbb");
   public static final DeferredBlock<Block> SCARLET_STAIRS_BUILDING_BLOCK = registerStairBlock("s_stbb", SCARLET_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DEEP_SCARLET_BUILDING_BLOCK = registerBasicBlock("ds_bb");
   public static final DeferredBlock<Block> DEEP_SCARLET_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ds_gbb");
   public static final DeferredBlock<Block> DEEP_SCARLET_SLAB_BUILDING_BLOCK = registerSlabBlock("ds_sbb");
   public static final DeferredBlock<Block> DEEP_SCARLET_STAIRS_BUILDING_BLOCK = registerStairBlock("ds_stbb", DEEP_SCARLET_BUILDING_BLOCK);
   public static final DeferredBlock<Block> CHESTNUT_BUILDING_BLOCK = registerBasicBlock("ls_bb");
   public static final DeferredBlock<Block> CHESTNUT_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ls_gbb");
   public static final DeferredBlock<Block> CHESTNUT_SLAB_BUILDING_BLOCK = registerSlabBlock("ls_sbb");
   public static final DeferredBlock<Block> CHESTNUT_STAIRS_BUILDING_BLOCK = registerStairBlock("ls_stbb", CHESTNUT_BUILDING_BLOCK);
   public static final DeferredBlock<Block> ROUGE_BUILDING_BLOCK = registerBasicBlock("rz_bb");
   public static final DeferredBlock<Block> ROUGE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rz_gbb");
   public static final DeferredBlock<Block> ROUGE_SLAB_BUILDING_BLOCK = registerSlabBlock("rz_sbb");
   public static final DeferredBlock<Block> ROUGE_STAIRS_BUILDING_BLOCK = registerStairBlock("rz_stbb", ROUGE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> MODERN_RED_BUILDING_BLOCK = registerBasicBlock("jy_bb");
   public static final DeferredBlock<Block> MODERN_RED_GLOWING_BUILDING_BLOCK = registerGlowingBlock("jy_gbb");
   public static final DeferredBlock<Block> MODERN_RED_SLAB_BUILDING_BLOCK = registerSlabBlock("jy_sbb");
   public static final DeferredBlock<Block> MODERN_RED_STAIRS_BUILDING_BLOCK = registerStairBlock("jy_stbb", MODERN_RED_BUILDING_BLOCK);
   public static final DeferredBlock<Block> GOLDEN_RED_BUILDING_BLOCK = registerBasicBlock("jc_bb");
   public static final DeferredBlock<Block> GOLDEN_RED_GLOWING_BUILDING_BLOCK = registerGlowingBlock("jc_gbb");
   public static final DeferredBlock<Block> GOLDEN_RED_SLAB_BUILDING_BLOCK = registerSlabBlock("jc_sbb");
   public static final DeferredBlock<Block> GOLDEN_RED_STAIRS_BUILDING_BLOCK = registerStairBlock("jc_stbb", GOLDEN_RED_BUILDING_BLOCK);
   public static final DeferredBlock<Block> RED_ORANGE_BUILDING_BLOCK = registerBasicBlock("ro_bb");
   public static final DeferredBlock<Block> RED_ORANGE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ro_gbb");
   public static final DeferredBlock<Block> RED_ORANGE_SLAB_BUILDING_BLOCK = registerSlabBlock("ro_sbb");
   public static final DeferredBlock<Block> RED_ORANGE_STAIRS_BUILDING_BLOCK = registerStairBlock("ro_stbb", RED_ORANGE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> RED_VERMILLION_2_BUILDING_BLOCK = registerBasicBlock("rv2_bb");
   public static final DeferredBlock<Block> RED_VERMILLION_2_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rv2_gbb");
   public static final DeferredBlock<Block> RED_VERMILLION_2_SLAB_BUILDING_BLOCK = registerSlabBlock("rv2_sbb");
   public static final DeferredBlock<Block> RED_VERMILLION_2_STAIRS_BUILDING_BLOCK = registerStairBlock("rv2_stbb", RED_VERMILLION_2_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DAWN_BUILDING_BLOCK = registerBasicBlock("d_bb");
   public static final DeferredBlock<Block> DAWN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("d_gbb");
   public static final DeferredBlock<Block> DAWN_SLAB_BUILDING_BLOCK = registerSlabBlock("d_sbb");
   public static final DeferredBlock<Block> DAWN_STAIRS_BUILDING_BLOCK = registerStairBlock("d_stbb", DAWN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BURNT_TEA_BUILDING_BLOCK = registerBasicBlock("bt_bb");
   public static final DeferredBlock<Block> BURNT_TEA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bt_gbb");
   public static final DeferredBlock<Block> BURNT_TEA_SLAB_BUILDING_BLOCK = registerSlabBlock("bt_sbb");
   public static final DeferredBlock<Block> BURNT_TEA_STAIRS_BUILDING_BLOCK = registerStairBlock("bt_stbb", BURNT_TEA_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PLUM_DYE_BUILDING_BLOCK = registerBasicBlock("mr_bb");
   public static final DeferredBlock<Block> PLUM_DYE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mr_gbb");
   public static final DeferredBlock<Block> PLUM_DYE_SLAB_BUILDING_BLOCK = registerSlabBlock("mr_sbb");
   public static final DeferredBlock<Block> PLUM_DYE_STAIRS_BUILDING_BLOCK = registerStairBlock("mr_stbb", PLUM_DYE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> RED_WHITE_OAK_BUILDING_BLOCK = registerBasicBlock("rwo_bb");
   public static final DeferredBlock<Block> RED_WHITE_OAK_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rwo_gbb");
   public static final DeferredBlock<Block> RED_WHITE_OAK_SLAB_BUILDING_BLOCK = registerSlabBlock("rwo_sbb");
   public static final DeferredBlock<Block> RED_WHITE_OAK_STAIRS_BUILDING_BLOCK = registerStairBlock("rwo_stbb", RED_WHITE_OAK_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SKIN_BUILDING_BLOCK = registerBasicBlock("js_bb");
   public static final DeferredBlock<Block> SKIN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("js_gbb");
   public static final DeferredBlock<Block> SKIN_SLAB_BUILDING_BLOCK = registerSlabBlock("js_sbb");
   public static final DeferredBlock<Block> SKIN_STAIRS_BUILDING_BLOCK = registerStairBlock("js_stbb", SKIN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WHEAT_BUILDING_BLOCK = registerBasicBlock("xm_bb");
   public static final DeferredBlock<Block> WHEAT_GLOWING_BUILDING_BLOCK = registerGlowingBlock("xm_gbb");
   public static final DeferredBlock<Block> WHEAT_SLAB_BUILDING_BLOCK = registerSlabBlock("xm_sbb");
   public static final DeferredBlock<Block> WHEAT_STAIRS_BUILDING_BLOCK = registerStairBlock("xm_stbb", WHEAT_BUILDING_BLOCK);
   public static final DeferredBlock<Block> GOLD_BUILDING_BLOCK = registerBasicBlock("go_bb");
   public static final DeferredBlock<Block> GOLD_GLOWING_BUILDING_BLOCK = registerGlowingBlock("go_gbb");
   public static final DeferredBlock<Block> GOLD_SLAB_BUILDING_BLOCK = registerSlabBlock("go_sbb");
   public static final DeferredBlock<Block> GOLD_STAIRS_BUILDING_BLOCK = registerStairBlock("go_stbb", GOLD_BUILDING_BLOCK);
   public static final DeferredBlock<Block> LIGHT_YELLOW_BUILDING_BLOCK = registerBasicBlock("ly_bb");
   public static final DeferredBlock<Block> LIGHT_YELLOW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ly_gbb");
   public static final DeferredBlock<Block> LIGHT_YELLOW_SLAB_BUILDING_BLOCK = registerSlabBlock("ly_sbb");
   public static final DeferredBlock<Block> LIGHT_YELLOW_STAIRS_BUILDING_BLOCK = registerStairBlock("ly_stbb", LIGHT_YELLOW_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PHELLODENDRON_BUILDING_BLOCK = registerBasicBlock("ph_bb");
   public static final DeferredBlock<Block> PHELLODENDRON_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ph_gbb");
   public static final DeferredBlock<Block> PHELLODENDRON_SLAB_BUILDING_BLOCK = registerSlabBlock("ph_sbb");
   public static final DeferredBlock<Block> PHELLODENDRON_STAIRS_BUILDING_BLOCK = registerStairBlock("ph_stbb", PHELLODENDRON_BUILDING_BLOCK);
   public static final DeferredBlock<Block> TURMERIC_BUILDING_BLOCK = registerBasicBlock("tu_bb");
   public static final DeferredBlock<Block> TURMERIC_GLOWING_BUILDING_BLOCK = registerGlowingBlock("tu_gbb");
   public static final DeferredBlock<Block> TURMERIC_SLAB_BUILDING_BLOCK = registerSlabBlock("tu_sbb");
   public static final DeferredBlock<Block> TURMERIC_STAIRS_BUILDING_BLOCK = registerStairBlock("tu_stbb", TURMERIC_BUILDING_BLOCK);
   public static final DeferredBlock<Block> YELLOW_BUILDING_BLOCK = registerBasicBlock("y_bb");
   public static final DeferredBlock<Block> YELLOW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("y_gbb");
   public static final DeferredBlock<Block> YELLOW_SLAB_BUILDING_BLOCK = registerSlabBlock("y_sbb");
   public static final DeferredBlock<Block> YELLOW_STAIRS_BUILDING_BLOCK = registerStairBlock("y_stbb", YELLOW_BUILDING_BLOCK);
   public static final DeferredBlock<Block> GREEN_YELLOW_BUILDING_BLOCK = registerBasicBlock("gy_bb");
   public static final DeferredBlock<Block> GREEN_YELLOW_GLOWING_BUILDING_BLOCK = registerGlowingBlock("gy_gbb");
   public static final DeferredBlock<Block> GREEN_YELLOW_SLAB_BUILDING_BLOCK = registerSlabBlock("gy_sbb");
   public static final DeferredBlock<Block> GREEN_YELLOW_STAIRS_BUILDING_BLOCK = registerStairBlock("gy_stbb", GREEN_YELLOW_BUILDING_BLOCK);
   public static final DeferredBlock<Block> NATIONAL_DEFENSE_BUILDING_BLOCK = registerBasicBlock("nd_bb");
   public static final DeferredBlock<Block> NATIONAL_DEFENSE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("nd_gbb");
   public static final DeferredBlock<Block> NATIONAL_DEFENSE_SLAB_BUILDING_BLOCK = registerSlabBlock("nd_sbb");
   public static final DeferredBlock<Block> NATIONAL_DEFENSE_STAIRS_BUILDING_BLOCK = registerStairBlock("nd_stbb", NATIONAL_DEFENSE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLUE_VERMILLION_BUILDING_BLOCK = registerBasicBlock("bv_bb");
   public static final DeferredBlock<Block> BLUE_VERMILLION_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bv_gbb");
   public static final DeferredBlock<Block> BLUE_VERMILLION_SLAB_BUILDING_BLOCK = registerSlabBlock("bv_sbb");
   public static final DeferredBlock<Block> BLUE_VERMILLION_STAIRS_BUILDING_BLOCK = registerStairBlock("bv_stbb", BLUE_VERMILLION_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SEA_PINE_BUILDING_BLOCK = registerBasicBlock("sp_bb");
   public static final DeferredBlock<Block> SEA_PINE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sp_gbb");
   public static final DeferredBlock<Block> SEA_PINE_SLAB_BUILDING_BLOCK = registerSlabBlock("sp_sbb");
   public static final DeferredBlock<Block> SEA_PINE_STAIRS_BUILDING_BLOCK = registerStairBlock("sp_stbb", SEA_PINE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> MOUNTAIN_DOVE_BUILDING_BLOCK = registerBasicBlock("md_bb");
   public static final DeferredBlock<Block> MOUNTAIN_DOVE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("md_gbb");
   public static final DeferredBlock<Block> MOUNTAIN_DOVE_SLAB_BUILDING_BLOCK = registerSlabBlock("md_sbb");
   public static final DeferredBlock<Block> MOUNTAIN_DOVE_STAIRS_BUILDING_BLOCK = registerStairBlock("md_stbb", MOUNTAIN_DOVE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> RIKYU_GRAY_BUILDING_BLOCK = registerBasicBlock("rg_bb");
   public static final DeferredBlock<Block> RIKYU_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("rg_gbb");
   public static final DeferredBlock<Block> RIKYU_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("rg_sbb");
   public static final DeferredBlock<Block> RIKYU_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("rg_stbb", RIKYU_GRAY_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WHITE_GREEN_BUILDING_BLOCK = registerBasicBlock("wg_bb");
   public static final DeferredBlock<Block> WHITE_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wg_gbb");
   public static final DeferredBlock<Block> WHITE_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("wg_sbb");
   public static final DeferredBlock<Block> WHITE_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("wg_stbb", WHITE_GREEN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> YOUNG_GREEN_BUILDING_BLOCK = registerBasicBlock("yg_bb");
   public static final DeferredBlock<Block> YOUNG_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("yg_gbb");
   public static final DeferredBlock<Block> YOUNG_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("yg_sbb");
   public static final DeferredBlock<Block> YOUNG_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("yg_stbb", YOUNG_GREEN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> GREEN_BUILDING_BLOCK = registerBasicBlock("gr_bb");
   public static final DeferredBlock<Block> GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("gr_gbb");
   public static final DeferredBlock<Block> GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("gr_sbb");
   public static final DeferredBlock<Block> GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("gr_stbb", GREEN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLUE_GREEN_BUILDING_BLOCK = registerBasicBlock("bgr_bb");
   public static final DeferredBlock<Block> BLUE_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bgr_gbb");
   public static final DeferredBlock<Block> BLUE_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("bgr_sbb");
   public static final DeferredBlock<Block> BLUE_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("bgr_stbb", BLUE_GREEN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> MATCHA_BUILDING_BLOCK = registerBasicBlock("mt_bb");
   public static final DeferredBlock<Block> MATCHA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("mt_gbb");
   public static final DeferredBlock<Block> MATCHA_SLAB_BUILDING_BLOCK = registerSlabBlock("mt_sbb");
   public static final DeferredBlock<Block> MATCHA_STAIRS_BUILDING_BLOCK = registerStairBlock("mt_stbb", MATCHA_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PINE_NEEDLE_BUILDING_BLOCK = registerBasicBlock("pnd_bb");
   public static final DeferredBlock<Block> PINE_NEEDLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pnd_gbb");
   public static final DeferredBlock<Block> PINE_NEEDLE_SLAB_BUILDING_BLOCK = registerSlabBlock("pnd_sbb");
   public static final DeferredBlock<Block> PINE_NEEDLE_STAIRS_BUILDING_BLOCK = registerStairBlock("pnd_stbb", PINE_NEEDLE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DEEP_GREEN_BUILDING_BLOCK = registerBasicBlock("dgr_bb");
   public static final DeferredBlock<Block> DEEP_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dgr_gbb");
   public static final DeferredBlock<Block> DEEP_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("dgr_sbb");
   public static final DeferredBlock<Block> DEEP_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("dgr_stbb", DEEP_GREEN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> FOREST_GREEN_BUILDING_BLOCK = registerBasicBlock("fg_bb");
   public static final DeferredBlock<Block> FOREST_GREEN_GLOWING_BUILDING_BLOCK = registerGlowingBlock("fg_gbb");
   public static final DeferredBlock<Block> FOREST_GREEN_SLAB_BUILDING_BLOCK = registerSlabBlock("fg_sbb");
   public static final DeferredBlock<Block> FOREST_GREEN_STAIRS_BUILDING_BLOCK = registerStairBlock("fg_stbb", FOREST_GREEN_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLUE_SEA_PINE_TEA_BUILDING_BLOCK = registerBasicBlock("bst_bb");
   public static final DeferredBlock<Block> BLUE_SEA_PINE_TEA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bst_gbb");
   public static final DeferredBlock<Block> BLUE_SEA_PINE_TEA_SLAB_BUILDING_BLOCK = registerSlabBlock("bst_sbb");
   public static final DeferredBlock<Block> BLUE_SEA_PINE_TEA_STAIRS_BUILDING_BLOCK = registerStairBlock("bst_stbb", BLUE_SEA_PINE_TEA_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SENCHA_BUILDING_BLOCK = registerBasicBlock("sen_bb");
   public static final DeferredBlock<Block> SENCHA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sen_gbb");
   public static final DeferredBlock<Block> SENCHA_SLAB_BUILDING_BLOCK = registerSlabBlock("sen_sbb");
   public static final DeferredBlock<Block> SENCHA_STAIRS_BUILDING_BLOCK = registerStairBlock("sen_stbb", SENCHA_BUILDING_BLOCK);
   public static final DeferredBlock<Block> IRON_GRAY_BUILDING_BLOCK = registerBasicBlock("ir_bb");
   public static final DeferredBlock<Block> IRON_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ir_gbb");
   public static final DeferredBlock<Block> IRON_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("ir_sbb");
   public static final DeferredBlock<Block> IRON_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("ir_stbb", IRON_GRAY_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WATER_BUILDING_BLOCK = registerBasicBlock("wa_bb");
   public static final DeferredBlock<Block> WATER_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wa_gbb");
   public static final DeferredBlock<Block> WATER_SLAB_BUILDING_BLOCK = registerSlabBlock("wa_sbb");
   public static final DeferredBlock<Block> WATER_STAIRS_BUILDING_BLOCK = registerStairBlock("wa_stbb", WATER_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WHITE_BLUE_BUILDING_BLOCK = registerBasicBlock("wb_bb");
   public static final DeferredBlock<Block> WHITE_BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wb_gbb");
   public static final DeferredBlock<Block> WHITE_BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("wb_sbb");
   public static final DeferredBlock<Block> WHITE_BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("wb_stbb", WHITE_BLUE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> GRAY_NANDO_BUILDING_BLOCK = registerBasicBlock("gn_bb");
   public static final DeferredBlock<Block> GRAY_NANDO_GLOWING_BUILDING_BLOCK = registerGlowingBlock("gn_gbb");
   public static final DeferredBlock<Block> GRAY_NANDO_SLAB_BUILDING_BLOCK = registerSlabBlock("gn_sbb");
   public static final DeferredBlock<Block> GRAY_NANDO_STAIRS_BUILDING_BLOCK = registerStairBlock("gn_stbb", GRAY_NANDO_BUILDING_BLOCK);
   public static final DeferredBlock<Block> SKY_BUILDING_BLOCK = registerBasicBlock("sk_bb");
   public static final DeferredBlock<Block> SKY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("sk_gbb");
   public static final DeferredBlock<Block> SKY_SLAB_BUILDING_BLOCK = registerSlabBlock("sk_sbb");
   public static final DeferredBlock<Block> SKY_STAIRS_BUILDING_BLOCK = registerStairBlock("sk_stbb", SKY_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLUE_BUILDING_BLOCK = registerBasicBlock("bu_bb");
   public static final DeferredBlock<Block> BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bu_gbb");
   public static final DeferredBlock<Block> BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("bu_sbb");
   public static final DeferredBlock<Block> BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("bu_stbb", BLUE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> LIGHT_BLUE_BUILDING_BLOCK = registerBasicBlock("lb_bb");
   public static final DeferredBlock<Block> LIGHT_BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("lb_gbb");
   public static final DeferredBlock<Block> LIGHT_BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("lb_sbb");
   public static final DeferredBlock<Block> LIGHT_BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("lb_stbb", LIGHT_BLUE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLUE_COLOR_BUILDING_BLOCK = registerBasicBlock("bc_bb");
   public static final DeferredBlock<Block> BLUE_COLOR_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bc_gbb");
   public static final DeferredBlock<Block> BLUE_COLOR_SLAB_BUILDING_BLOCK = registerSlabBlock("bc_sbb");
   public static final DeferredBlock<Block> BLUE_COLOR_STAIRS_BUILDING_BLOCK = registerStairBlock("bc_stbb", BLUE_COLOR_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DARK_BLUE_BUILDING_BLOCK = registerBasicBlock("db_bb");
   public static final DeferredBlock<Block> DARK_BLUE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("db_gbb");
   public static final DeferredBlock<Block> DARK_BLUE_SLAB_BUILDING_BLOCK = registerSlabBlock("db_sbb");
   public static final DeferredBlock<Block> DARK_BLUE_STAIRS_BUILDING_BLOCK = registerStairBlock("db_stbb", DARK_BLUE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> FLOWER_BUILDING_BLOCK = registerBasicBlock("fl_bb");
   public static final DeferredBlock<Block> FLOWER_GLOWING_BUILDING_BLOCK = registerGlowingBlock("fl_gbb");
   public static final DeferredBlock<Block> FLOWER_SLAB_BUILDING_BLOCK = registerSlabBlock("fl_sbb");
   public static final DeferredBlock<Block> FLOWER_STAIRS_BUILDING_BLOCK = registerStairBlock("fl_stbb", FLOWER_BUILDING_BLOCK);
   public static final DeferredBlock<Block> NAVY_VIOLET_BUILDING_BLOCK = registerBasicBlock("nv_bb");
   public static final DeferredBlock<Block> NAVY_VIOLET_GLOWING_BUILDING_BLOCK = registerGlowingBlock("nv_gbb");
   public static final DeferredBlock<Block> NAVY_VIOLET_SLAB_BUILDING_BLOCK = registerSlabBlock("nv_sbb");
   public static final DeferredBlock<Block> NAVY_VIOLET_STAIRS_BUILDING_BLOCK = registerStairBlock("nv_stbb", NAVY_VIOLET_BUILDING_BLOCK);
   public static final DeferredBlock<Block> ULTRAMARINE_BUILDING_BLOCK = registerBasicBlock("ul_bb");
   public static final DeferredBlock<Block> ULTRAMARINE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ul_gbb");
   public static final DeferredBlock<Block> ULTRAMARINE_SLAB_BUILDING_BLOCK = registerSlabBlock("ul_sbb");
   public static final DeferredBlock<Block> ULTRAMARINE_STAIRS_BUILDING_BLOCK = registerStairBlock("ul_stbb", ULTRAMARINE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WISTERIA_GRAY_BUILDING_BLOCK = registerBasicBlock("wgr_bb");
   public static final DeferredBlock<Block> WISTERIA_GRAY_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wgr_gbb");
   public static final DeferredBlock<Block> WISTERIA_GRAY_SLAB_BUILDING_BLOCK = registerSlabBlock("wgr_sbb");
   public static final DeferredBlock<Block> WISTERIA_GRAY_STAIRS_BUILDING_BLOCK = registerStairBlock("wgr_stbb", WISTERIA_GRAY_BUILDING_BLOCK);
   public static final DeferredBlock<Block> CB_BUILDING_BLOCK = registerBasicBlock("cb_bb");
   public static final DeferredBlock<Block> CB_GLOWING_BUILDING_BLOCK = registerGlowingBlock("cb_gbb");
   public static final DeferredBlock<Block> CB_SLAB_BUILDING_BLOCK = registerSlabBlock("cb_sbb");
   public static final DeferredBlock<Block> CB_STAIRS_BUILDING_BLOCK = registerStairBlock("cb_stbb", CB_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PT_BUILDING_BLOCK = registerBasicBlock("pt_bb");
   public static final DeferredBlock<Block> PT_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pt_gbb");
   public static final DeferredBlock<Block> PT_SLAB_BUILDING_BLOCK = registerSlabBlock("pt_sbb");
   public static final DeferredBlock<Block> PT_STAIRS_BUILDING_BLOCK = registerStairBlock("pt_stbb", PT_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PS_BUILDING_BLOCK = registerBasicBlock("ps_bb");
   public static final DeferredBlock<Block> PS_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ps_gbb");
   public static final DeferredBlock<Block> PS_SLAB_BUILDING_BLOCK = registerSlabBlock("ps_sbb");
   public static final DeferredBlock<Block> PS_STAIRS_BUILDING_BLOCK = registerStairBlock("ps_stbb", PS_BUILDING_BLOCK);
   public static final DeferredBlock<Block> NS_BUILDING_BLOCK = registerBasicBlock("ns_bb");
   public static final DeferredBlock<Block> NS_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ns_gbb");
   public static final DeferredBlock<Block> NS_SLAB_BUILDING_BLOCK = registerSlabBlock("ns_sbb");
   public static final DeferredBlock<Block> NS_STAIRS_BUILDING_BLOCK = registerStairBlock("ns_stbb", NS_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WISTERIA_BUILDING_BLOCK = registerBasicBlock("wi_bb");
   public static final DeferredBlock<Block> WISTERIA_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wi_gbb");
   public static final DeferredBlock<Block> WISTERIA_SLAB_BUILDING_BLOCK = registerSlabBlock("wi_sbb");
   public static final DeferredBlock<Block> WISTERIA_STAIRS_BUILDING_BLOCK = registerStairBlock("wi_stbb", WISTERIA_BUILDING_BLOCK);
   public static final DeferredBlock<Block> WISTERIA_PURPLE_BUILDING_BLOCK = registerBasicBlock("wp_bb");
   public static final DeferredBlock<Block> WISTERIA_PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("wp_gbb");
   public static final DeferredBlock<Block> WISTERIA_PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("wp_sbb");
   public static final DeferredBlock<Block> WISTERIA_PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("wp_stbb", WISTERIA_PURPLE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> DOVE_BUILDING_BLOCK = registerBasicBlock("dv_bb");
   public static final DeferredBlock<Block> DOVE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("dv_gbb");
   public static final DeferredBlock<Block> DOVE_SLAB_BUILDING_BLOCK = registerSlabBlock("dv_sbb");
   public static final DeferredBlock<Block> DOVE_STAIRS_BUILDING_BLOCK = registerStairBlock("dv_stbb", DOVE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> BLUE_PURPLE_BUILDING_BLOCK = registerBasicBlock("bp_bb");
   public static final DeferredBlock<Block> BLUE_PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("bp_gbb");
   public static final DeferredBlock<Block> BLUE_PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("bp_sbb");
   public static final DeferredBlock<Block> BLUE_PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("bp_stbb", BLUE_PURPLE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> EDO_PURPLE_BUILDING_BLOCK = registerBasicBlock("ep_bb");
   public static final DeferredBlock<Block> EDO_PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("ep_gbb");
   public static final DeferredBlock<Block> EDO_PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("ep_sbb");
   public static final DeferredBlock<Block> EDO_PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("ep_stbb", EDO_PURPLE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> PURPLE_BUILDING_BLOCK = registerBasicBlock("pu_bb");
   public static final DeferredBlock<Block> PURPLE_GLOWING_BUILDING_BLOCK = registerGlowingBlock("pu_gbb");
   public static final DeferredBlock<Block> PURPLE_SLAB_BUILDING_BLOCK = registerSlabBlock("pu_sbb");
   public static final DeferredBlock<Block> PURPLE_STAIRS_BUILDING_BLOCK = registerStairBlock("pu_stbb", PURPLE_BUILDING_BLOCK);
   public static final DeferredBlock<Block> REDSTONE_CLOCK_1S = registerRedstoneClockBlock("redstone_clock_1s", 20);
   public static final DeferredBlock<Block> REDSTONE_CLOCK_2S = registerRedstoneClockBlock("redstone_clock_2s", 40);
   public static final DeferredBlock<Block> REDSTONE_CLOCK_4S = registerRedstoneClockBlock("redstone_clock_4s", 80);
   public static final DeferredBlock<Block> REDSTONE_CLOCK_8S = registerRedstoneClockBlock("redstone_clock_8s", 160);
   public static final DeferredBlock<Block> REDSTONE_CLOCK_16S = registerRedstoneClockBlock("redstone_clock_16s", 320);
   public static final DeferredBlock<Block> REDSTONE_CLOCK_32S = registerRedstoneClockBlock("redstone_clock_32s", 640);
   public static final DeferredBlock<Block> WHITE_ANTI_COLLISION_LIGHT = registerAntiCollisionLightBlock("white_anti_collision_light");
   public static final DeferredBlock<Block> RED_ANTI_COLLISION_LIGHT = registerAntiCollisionLightBlock("red_anti_collision_light");
   public static final DeferredBlock<Block> BLUE_GLASS_2 = registerBlock("bla_g2", () -> new UrbanGlassBlock());
   public static final DeferredBlock<Block> BLUE_GLASS_2_PANE = registerBlock("bla_g2_pane", () -> new UrbanGlassPaneBlock());
   public static final DeferredBlock<Block> SLATE_1 = registerBasicBlock("z_1");
   public static final DeferredBlock<Block> SLATE_2 = registerBasicBlock("z_2");
   public static final DeferredBlock<Block> SLATE_3 = registerBasicBlock("z_3");
   public static final DeferredBlock<Block> SLATE_4 = registerBasicBlock("z_4");
   public static final DeferredBlock<Block> MARBLE_TILE_1 = registerBasicBlock("z_5");
   public static final DeferredBlock<Block> MARBLE_TILE_2 = registerBasicBlock("z_6");
   public static final DeferredBlock<Block> MARBLE_TILE_3 = registerBasicBlock("z_7");
   public static final DeferredBlock<Block> MARBLE_TILE_4 = registerBasicBlock("z_8");
   public static final DeferredBlock<Block> MARBLE_TILE_5 = registerBasicBlock("z_9");
   public static final DeferredBlock<Block> MARBLE_TILE_6 = registerBasicBlock("z_10");
   public static final DeferredBlock<Block> MARBLE_TILE_7 = registerBasicBlock("z_11");
   public static final DeferredBlock<Block> MARBLE_TILE_8 = registerBasicBlock("z_12");
   public static final DeferredBlock<Block> MARBLE_TILE_9 = registerBasicBlock("z_13");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_1 = registerBasicBlock("z_14");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_2 = registerBasicBlock("z_15");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_3 = registerBasicBlock("z_16");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_4 = registerBasicBlock("z_17");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_5 = registerBasicBlock("z_18");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_6 = registerBasicBlock("z_19");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_7 = registerBasicBlock("z_20");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_8 = registerBasicBlock("z_21");
   public static final DeferredBlock<Block> STONE_FLOOR_TILE_9 = registerBasicBlock("z_22");
   public static final DeferredBlock<Block> TERRAZZO_1 = registerBasicBlock("z_23");
   public static final DeferredBlock<Block> TERRAZZO_2 = registerBasicBlock("z_24");
   public static final DeferredBlock<Block> TERRAZZO_3 = registerBasicBlock("z_25");
   public static final DeferredBlock<Block> TERRAZZO_4 = registerBasicBlock("z_26");
   public static final DeferredBlock<Block> TERRAZZO_5 = registerBasicBlock("z_27");
   public static final DeferredBlock<Block> TERRAZZO_6 = registerBasicBlock("z_28");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_1 = registerBasicBlock("z_29");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_2 = registerBasicBlock("z_30");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_3 = registerBasicBlock("z_31");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_4 = registerBasicBlock("z_32");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_5 = registerBasicBlock("z_33");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_6 = registerBasicBlock("z_34");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_7 = registerBasicBlock("z_35");
   public static final DeferredBlock<Block> ENCAUSTIC_TILE_8 = registerBasicBlock("z_36");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_1 = registerBasicBlock("z_37");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_2 = registerBasicBlock("z_38");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_3 = registerBasicBlock("z_39");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_4 = registerBasicBlock("z_40");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_5 = registerBasicBlock("z_41");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_6 = registerBasicBlock("z_42");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_7 = registerBasicBlock("z_43");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_8 = registerBasicBlock("z_44");
   public static final DeferredBlock<Block> STONE_BRICK_WALL_9 = registerBasicBlock("z_45");
   public static final DeferredBlock<Block> CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("center_glass_seam");
   public static final DeferredBlock<Block> CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("center_horizontal_glass_seam");
   public static final DeferredBlock<Block> CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("center_cross_glass_seam");
   public static final DeferredBlock<Block> LG_1_CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("lg_1_center_glass_seam");
   public static final DeferredBlock<Block> LG_1_CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("lg_1_center_horizontal_glass_seam");
   public static final DeferredBlock<Block> LG_1_CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("lg_1_center_cross_glass_seam");
   public static final DeferredBlock<Block> LG_2_CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("lg_2_center_glass_seam");
   public static final DeferredBlock<Block> LG_2_CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("lg_2_center_horizontal_glass_seam");
   public static final DeferredBlock<Block> LG_2_CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("lg_2_center_cross_glass_seam");
   public static final DeferredBlock<Block> LG_3_CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("lg_3_center_glass_seam");
   public static final DeferredBlock<Block> LG_3_CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("lg_3_center_horizontal_glass_seam");
   public static final DeferredBlock<Block> LG_3_CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("lg_3_center_cross_glass_seam");
   public static final DeferredBlock<Block> MG_1_CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("mg_1_center_glass_seam");
   public static final DeferredBlock<Block> MG_1_CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("mg_1_center_horizontal_glass_seam");
   public static final DeferredBlock<Block> MG_1_CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("mg_1_center_cross_glass_seam");
   public static final DeferredBlock<Block> MG_2_CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("mg_2_center_glass_seam");
   public static final DeferredBlock<Block> MG_2_CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("mg_2_center_horizontal_glass_seam");
   public static final DeferredBlock<Block> MG_2_CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("mg_2_center_cross_glass_seam");
   public static final DeferredBlock<Block> MG_3_CENTER_GLASS_SEAM = registerCenterGlassSeamBlock("mg_3_center_glass_seam");
   public static final DeferredBlock<Block> MG_3_CENTER_HORIZONTAL_GLASS_SEAM = registerCenterHorizontalGlassSeamBlock("mg_3_center_horizontal_glass_seam");
   public static final DeferredBlock<Block> MG_3_CENTER_CROSS_GLASS_SEAM = registerCenterCrossGlassSeamBlock("mg_3_center_cross_glass_seam");
   public static final DeferredBlock<Block> WHITE_VERTICAL_LED = registerVerticalLEDBlock("white_vertical_led");
   public static final DeferredBlock<Block> WHITE_HORIZONTAL_LED = registerHorizontalLEDBlock("white_horizontal_led");
   public static final DeferredBlock<Block> BLACKISH_GRAY_VERTICAL_LED = registerVerticalLEDBlock("blackish_gray_vertical_led");
   public static final DeferredBlock<Block> BLACKISH_GRAY_HORIZONTAL_LED = registerHorizontalLEDBlock("blackish_gray_horizontal_led");
   public static final DeferredBlock<Block> IBIS_VERTICAL_LED = registerVerticalLEDBlock("ibis_vertical_led");
   public static final DeferredBlock<Block> IBIS_HORIZONTAL_LED = registerHorizontalLEDBlock("ibis_horizontal_led");
   public static final DeferredBlock<Block> RED_VERTICAL_LED = registerVerticalLEDBlock("red_vertical_led");
   public static final DeferredBlock<Block> RED_HORIZONTAL_LED = registerHorizontalLEDBlock("red_horizontal_led");
   public static final DeferredBlock<Block> RED_ORANGE_VERTICAL_LED = registerVerticalLEDBlock("red_orange_vertical_led");
   public static final DeferredBlock<Block> RED_ORANGE_HORIZONTAL_LED = registerHorizontalLEDBlock("red_orange_horizontal_led");
   public static final DeferredBlock<Block> YELLOW_VERTICAL_LED = registerVerticalLEDBlock("yellow_vertical_led");
   public static final DeferredBlock<Block> YELLOW_HORIZONTAL_LED = registerHorizontalLEDBlock("yellow_horizontal_led");
   public static final DeferredBlock<Block> YH_VERTICAL_LED = registerVerticalLEDBlock("yh_vertical_led");
   public static final DeferredBlock<Block> YH_HORIZONTAL_LED = registerHorizontalLEDBlock("yh_horizontal_led");
   public static final DeferredBlock<Block> CB_VERTICAL_LED = registerVerticalLEDBlock("cb_vertical_led");
   public static final DeferredBlock<Block> CB_HORIZONTAL_LED = registerHorizontalLEDBlock("cb_horizontal_led");
   public static final DeferredBlock<Block> DB_VERTICAL_LED = registerVerticalLEDBlock("db_vertical_led");
   public static final DeferredBlock<Block> DB_HORIZONTAL_LED = registerHorizontalLEDBlock("db_horizontal_led");
   public static final DeferredBlock<Block> BP_VERTICAL_LED = registerVerticalLEDBlock("bp_vertical_led");
   public static final DeferredBlock<Block> BP_HORIZONTAL_LED = registerHorizontalLEDBlock("bp_horizontal_led");
   public static final DeferredBlock<Block> WHITE_LINE_BLOCK = registerBasicBlock("white_line_block");
   public static final DeferredBlock<Block> YELLOW_LINE_BLOCK = registerBasicBlock("yellow_line_block");

   private static DeferredBlock<Block> registerMetalBasicBlock(String name) {
      return registerBlock(name, () -> new Block(METAL_PROPERTIES));
   }

   private static DeferredBlock<Block> registerMetalGlowingBlock(String name) {
      return registerBlock(name, () -> new Block(METAL_GLOWING_PROPERTIES));
   }

   private static DeferredBlock<Block> registerMetalSlabBlock(String name) {
      return registerBlock(name, () -> new SlabBlock(METAL_PROPERTIES));
   }

   private static DeferredBlock<Block> registerMetalStairBlock(String name, Supplier<Block> baseBlock) {
      return registerBlock(name, () -> new StairBlock(baseBlock.get().defaultBlockState(), METAL_PROPERTIES));
   }

   private static DeferredBlock<Block> registerBasicBlock(String name) {
      return registerBlock(name, () -> new Block(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerGlowingBlock(String name) {
      return registerBlock(name, () -> new Block(GLOWING_PROPERTIES));
   }

   private static DeferredBlock<Block> registerSlabBlock(String name) {
      return registerBlock(name, () -> new SlabBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerHeightRoadBlock(String name, float height) {
      return registerBlock(name, () -> new HeightRoadBlock(BASIC_PROPERTIES, height));
   }

   private static DeferredBlock<Block> registerDirectionalHeightRoadBlock(String name, float height) {
      return registerBlock(name, () -> new DirectionalHeightRoadBlock(BASIC_PROPERTIES, height));
   }

   private static DeferredBlock<Block> registerStairBlock(String name, Supplier<Block> baseBlock) {
      return registerBlock(name, () -> new StairBlock(baseBlock.get().defaultBlockState(), BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerBlock(String name, Supplier<? extends Block> supplier) {
      DeferredBlock<Block> block = BLOCKS.register(name, supplier);
      ITEMS.register(name, () -> new BlockItem((Block)block.get(), new net.minecraft.world.item.Item.Properties()));
      return block;
   }

   private static DeferredBlock<Block> registerPlayerFacingBlock(String name) {
      return registerBlock(name, () -> new PlayerFacingBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerSmartTextureBlock(String name) {
      return registerBlock(name, () -> new SmartTextureBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerBorderWallBlock(String name) {
      return registerBlock(name, () -> new BorderWallBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerThinBorderWallBlock(String name) {
      return registerBlock(name, () -> new ThinBorderWallBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerVerticalSlabBlock(String name) {
      return registerBlock(name, () -> new VerticalSlabBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerThinVerticalSlabBlock(String name) {
      return registerBlock(name, () -> new ThinVerticalSlabBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerCornerBlock(String name) {
      return registerBlock(name, () -> new CornerBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerRedstoneClockBlock(String name, int intervalInTicks) {
      return registerBlock(name, () -> new RedstoneClockBlock(BASIC_PROPERTIES, intervalInTicks));
   }

   private static DeferredBlock<Block> registerOfficeLightBlock(String name) {
      return registerBlock(name, () -> new OfficeLightBlock(METAL_GLOWING_PROPERTIES));
   }

   private static DeferredBlock<Block> registerVerticalLEDBlock(String name) {
      return registerBlock(name, () -> new VerticalLEDBlock(METAL_GLOWING_PROPERTIES));
   }

   private static DeferredBlock<Block> registerHorizontalLEDBlock(String name) {
      return registerBlock(name, () -> new HorizontalLEDBlock(METAL_GLOWING_PROPERTIES));
   }

   private static DeferredBlock<Block> registerOfficeRoundLightBlock(String name) {
      return registerBlock(name, () -> new OfficeRoundLightBlock(METAL_GLOWING_PROPERTIES));
   }

   private static DeferredBlock<Block> registerAntiCollisionLightBlock(String name) {
      return registerBlock(name, () -> new AntiCollisionLightBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerCeilingFloorBlock(String name) {
      return registerBlock(name, () -> new CeilingFloorBlock(BASIC_PROPERTIES));
   }

   private static DeferredBlock<Block> registerCenterGlassSeamBlock(String name) {
      return registerBlock(name, () -> new CenterGlassSeamBlock(METAL_PROPERTIES));
   }

   private static DeferredBlock<Block> registerCenterCrossGlassSeamBlock(String name) {
      return registerBlock(name, () -> new CenterCrossGlassSeamBlock(METAL_PROPERTIES));
   }

   private static DeferredBlock<Block> registerCenterHorizontalGlassSeamBlock(String name) {
      return registerBlock(name, () -> new CenterHorizontalGlassSeamBlock(METAL_PROPERTIES));
   }

   public static void register(IEventBus eventBus) {
      BLOCKS.register(eventBus);
      ITEMS.register(eventBus);
   }
}
