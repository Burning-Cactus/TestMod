package com.burning.testmod.data.builtin;

import com.burning.testmod.TestMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BiomeData {

    public static final ResourceKey<Biome> TEST_BIOME = ResourceKey.create(Registries.BIOME, TestMod.prefix("test_biome"));


    public static void registerBiomes(BootstapContext<Biome> context) {
        BiomeSpecialEffects base = new BiomeSpecialEffects.Builder()
                .fogColor(0x888888)
                .waterColor(0x4444cc)
                .waterFogColor(0x444499)
                .skyColor(0xbbbb23)
                .build();
        context.register(TEST_BIOME, new Biome.BiomeBuilder()
                        .temperature(0.4F)
                        .downfall(0.5F)
                        .specialEffects(base)
                        .mobSpawnSettings(MobSpawnSettings.EMPTY)
                        .generationSettings(BiomeGenerationSettings.EMPTY)
                .build());
    }
}
