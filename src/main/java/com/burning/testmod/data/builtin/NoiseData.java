package com.burning.testmod.data.builtin;

import com.burning.testmod.TestMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class NoiseData {
    public static ResourceKey<NoiseGeneratorSettings> TEST_WORLD = ResourceKey.create(Registries.NOISE_SETTINGS, TestMod.prefix("test_world"));

    public static void registerNoiseSettings(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(TEST_WORLD, new NoiseGeneratorSettings(
                NoiseSettings.create(-64, 192, 1, 1),
                Blocks.SLIME_BLOCK.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                buildNoiseRouter(context),
                SurfaceRuleData.overworld(),
                new OverworldBiomeBuilder().spawnTarget(),
                63,
                false,
                false,
                true,
                false
        ));
    }

    public static NoiseRouter buildNoiseRouter(BootstapContext<NoiseGeneratorSettings> context) {
        HolderGetter<NormalNoise.NoiseParameters> noiseGetter = context.lookup(Registries.NOISE);
        return new NoiseRouter(
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.noise(noiseGetter.getOrThrow(Noises.BADLANDS_SURFACE)),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );
    }
}
