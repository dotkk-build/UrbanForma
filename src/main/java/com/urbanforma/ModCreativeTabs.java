package com.urbanforma;

import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    // 都市构方基础物品栏
    public static final CreativeModeTab URBANFORMA_BASE_TAB = new CreativeModeTab("urbanforma_base") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.WHITE_BUILDING_BLOCK.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            // 白色系列方块
            addBlocks(items, ModBlocks.WHITE_BUILDING_BLOCK, ModBlocks.WHITE_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.WHITE_SLAB_BUILDING_BLOCK, ModBlocks.WHITE_STAIRS_BUILDING_BLOCK);
            
            // 亮灰系列方块 (1-3)
            addBlocks(items, ModBlocks.LIGHT_GRAY_1_BUILDING_BLOCK, ModBlocks.LIGHT_GRAY_1_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.LIGHT_GRAY_1_SLAB_BUILDING_BLOCK, ModBlocks.LIGHT_GRAY_1_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.LIGHT_GRAY_2_BUILDING_BLOCK, ModBlocks.LIGHT_GRAY_2_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.LIGHT_GRAY_2_SLAB_BUILDING_BLOCK, ModBlocks.LIGHT_GRAY_2_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.LIGHT_GRAY_3_BUILDING_BLOCK, ModBlocks.LIGHT_GRAY_3_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.LIGHT_GRAY_3_SLAB_BUILDING_BLOCK, ModBlocks.LIGHT_GRAY_3_STAIRS_BUILDING_BLOCK);
            
            // 中灰系列方块 (1-3)
            addBlocks(items, ModBlocks.MEDIUM_GRAY_1_BUILDING_BLOCK, ModBlocks.MEDIUM_GRAY_1_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.MEDIUM_GRAY_1_SLAB_BUILDING_BLOCK, ModBlocks.MEDIUM_GRAY_1_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.MEDIUM_GRAY_2_BUILDING_BLOCK, ModBlocks.MEDIUM_GRAY_2_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.MEDIUM_GRAY_2_SLAB_BUILDING_BLOCK, ModBlocks.MEDIUM_GRAY_2_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.MEDIUM_GRAY_3_BUILDING_BLOCK, ModBlocks.MEDIUM_GRAY_3_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.MEDIUM_GRAY_3_SLAB_BUILDING_BLOCK, ModBlocks.MEDIUM_GRAY_3_STAIRS_BUILDING_BLOCK);
            
            // 暗灰系列方块 (1-4)
            addBlocks(items, ModBlocks.DARK_GRAY_1_BUILDING_BLOCK, ModBlocks.DARK_GRAY_1_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.DARK_GRAY_1_SLAB_BUILDING_BLOCK, ModBlocks.DARK_GRAY_1_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.DARK_GRAY_2_BUILDING_BLOCK, ModBlocks.DARK_GRAY_2_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.DARK_GRAY_2_SLAB_BUILDING_BLOCK, ModBlocks.DARK_GRAY_2_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.DARK_GRAY_3_BUILDING_BLOCK, ModBlocks.DARK_GRAY_3_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.DARK_GRAY_3_SLAB_BUILDING_BLOCK, ModBlocks.DARK_GRAY_3_STAIRS_BUILDING_BLOCK);
            addBlocks(items, ModBlocks.DARK_GRAY_4_BUILDING_BLOCK, ModBlocks.DARK_GRAY_4_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.DARK_GRAY_4_SLAB_BUILDING_BLOCK, ModBlocks.DARK_GRAY_4_STAIRS_BUILDING_BLOCK);
            
            // 黑灰系列方块
            addBlocks(items, ModBlocks.BLACKISH_GRAY_BUILDING_BLOCK, ModBlocks.BLACKISH_GRAY_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.BLACKISH_GRAY_SLAB_BUILDING_BLOCK, ModBlocks.BLACKISH_GRAY_STAIRS_BUILDING_BLOCK);
            
            // 黑色系列方块
            addBlocks(items, ModBlocks.BLACK_BUILDING_BLOCK, ModBlocks.BLACK_GLOWING_BUILDING_BLOCK, 
                     ModBlocks.BLACK_SLAB_BUILDING_BLOCK, ModBlocks.BLACK_STAIRS_BUILDING_BLOCK);
        }
        
        private void addBlocks(NonNullList<ItemStack> items, 
                              RegistryObject<Block> block, RegistryObject<Block> glowing, 
                              RegistryObject<Block> slab, RegistryObject<Block> stairs) {
            items.add(new ItemStack(block.get()));
            items.add(new ItemStack(glowing.get()));
            items.add(new ItemStack(slab.get()));
            items.add(new ItemStack(stairs.get()));
        }
    };
    
    // 都市构方道路物品栏
    public static final CreativeModeTab URBANFORMA_ROAD_TAB = new CreativeModeTab("urbanforma_road") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.ROAD_A_GRAY.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            // 道路系列方块
            items.add(new ItemStack(ModBlocks.ROAD_A_GRAY.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_GRAY_GLOWING.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_GRAY_SLAB.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_LIGHT_GRAY.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_LIGHT_GRAY_GLOWING.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_LIGHT_GRAY_SLAB.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_GLOWING.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_SLAB.get()));
            
            // 道路标线
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_LINE.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_45_DEGREE.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_ZEBRA.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_CROSS.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_T_LINE.get()));
            items.add(new ItemStack(ModBlocks.ROAD_A_WHITE_CORNER.get()));
        }
    };
    
    public static void register() {
        // 在1.18.2中，标签页是通过构造函数直接创建的，无需注册
    }
}