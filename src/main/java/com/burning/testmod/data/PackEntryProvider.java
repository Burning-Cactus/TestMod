package com.burning.testmod.data;

import com.burning.testmod.TestMod;
import com.burning.testmod.data.builtin.BiomeData;
import com.burning.testmod.data.builtin.DimensionData;
import com.burning.testmod.data.builtin.NoiseData;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PackEntryProvider extends DatapackBuiltinEntriesProvider {
    public PackEntryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, builder(), Set.of(TestMod.MOD_ID));
    }

    private static RegistrySetBuilder builder() {
        return new RegistrySetBuilder()
                .add(Registries.BIOME, BiomeData::registerBiomes)
                .add(Registries.NOISE_SETTINGS, NoiseData::registerNoiseSettings)
                .add(Registries.DIMENSION_TYPE, DimensionData::registerDimensionType)
                .add(Registries.LEVEL_STEM, DimensionData::registerLevelStem)
                ;
    }
}
