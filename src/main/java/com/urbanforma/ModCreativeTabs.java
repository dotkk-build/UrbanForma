package com.urbanforma;

import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModCreativeTabs {
    // 都市构方基础物品栏
    public static final CreativeModeTab URBANFORMA_BASE_TAB = new CreativeModeTab("urbanforma_base") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.WHITE_BUILDING_BLOCK.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            // 使用反射获取所有方块
            try {
                List<RegistryObject<Block>> basicBlocks = new ArrayList<>();
                List<RegistryObject<Block>> roadBlocks = new ArrayList<>();
                
                Field[] fields = ModBlocks.class.getDeclaredFields();
                for (Field field : fields) {
                    if (field.getType().equals(RegistryObject.class) && 
                        field.getGenericType().toString().contains("Block")) {
                        
                        field.setAccessible(true);
                        RegistryObject<Block> block = (RegistryObject<Block>) field.get(null);
                        
                        // 将道路方块和建筑方块分开
                        String name = field.getName();
                        if (name.startsWith("ROAD_")) {
                            roadBlocks.add(block);
                        } else {
                            basicBlocks.add(block);
                        }
                    }
                }
                
                // 添加所有基础建筑方块
                for (RegistryObject<Block> block : basicBlocks) {
                    items.add(new ItemStack(block.get()));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            // 使用反射获取所有道路方块
            try {
                Field[] fields = ModBlocks.class.getDeclaredFields();
                for (Field field : fields) {
                    if (field.getType().equals(RegistryObject.class) && 
                        field.getGenericType().toString().contains("Block")) {
                        
                        String name = field.getName();
                        if (name.startsWith("ROAD_")) {
                            field.setAccessible(true);
                            RegistryObject<Block> block = (RegistryObject<Block>) field.get(null);
                            items.add(new ItemStack(block.get()));
                        }
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    
    public static void register() {
        // 在1.18.2中，标签页是通过构造函数直接创建的，无需注册
    }
}