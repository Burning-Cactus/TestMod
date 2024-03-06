package com.burning.testmod.data.builtin;

import com.burning.testmod.TestMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.OptionalLong;

public class DimensionData {
    public static final ResourceKey<LevelStem> TEST_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, TestMod.prefix("test_world"));
    public static final ResourceKey<DimensionType> TEST_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, TestMod.prefix("test_world"));


    public static void registerDimensionType(BootstapContext<DimensionType> context) {
        context.register(TEST_DIMENSION_TYPE,
                new DimensionType(
                        OptionalLong.empty(), // Fixed time
                        true, // Skylight
                        false, // Ceiling
                        false, // Ultra Warm
                        false, // Natural
                        1.0, // Coordinate scale
                        true, // Bed works
                        true, // Respawn anchor works
                        -64, // Minimum Y
                        320, // Height
                        256, // Logical height
                        BlockTags.INFINIBURN_OVERWORLD, // Infiniburn
                        BuiltinDimensionTypes.OVERWORLD_EFFECTS, // Effects
                        0.0F, // Ambient light
                        new DimensionType.MonsterSettings(
                                false,
                                false,
                                UniformInt.of(0, 7),
                                0
                        )
                ));
    }

    public static void registerLevelStem(BootstapContext<LevelStem> context) {
        HolderGetter<DimensionType> typeGetter = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseGetter = context.lookup(Registries.NOISE_SETTINGS);

        BiomeSource biomeSource = new FixedBiomeSource(biomeGetter.getOrThrow(Biomes.CHERRY_GROVE));
        Holder<NoiseGeneratorSettings> noiseSettings = noiseGetter.getOrThrow(NoiseData.TEST_WORLD);

        ChunkGenerator chunkGenerator = new NoiseBasedChunkGenerator(biomeSource, noiseSettings);

        context.register(TEST_LEVEL_STEM, new LevelStem(typeGetter.getOrThrow(TEST_DIMENSION_TYPE), chunkGenerator));
    }
}
