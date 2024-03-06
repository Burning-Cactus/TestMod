package com.burning.testmod;

import com.burning.testmod.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(TestMod.MOD_ID)
public class TestMod {
    public static final String MOD_ID = "testmod";

    public TestMod(IEventBus modBus) {
        ModItems.ITEMS.register(modBus);

        TestConfig.registerConfig();
    }

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
