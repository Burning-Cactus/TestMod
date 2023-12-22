package com.burning.testmod.items;

import com.burning.testmod.TestMod;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    public static final DeferredItem<DaggerItem> IRON_DAGGER = ITEMS.registerItem("iron_dagger", properties -> new DaggerItem(Tiers.IRON, properties));
}
