package com.urbanforma;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
   public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("urbanforma");

   public static void register(IEventBus eventBus) {
      ITEMS.register(eventBus);
   }
}
