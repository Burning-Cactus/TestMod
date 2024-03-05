package com.burning.testmod;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class TestConfig {
    public static TestConfig COMMON;
    public final ConfigValue<Boolean> showExampleText;
    TestConfig(ModConfigSpec.Builder builder) {
        showExampleText = builder.define("show_starting_text", true);
    }

    public static void registerConfig() {
        Pair<TestConfig, ModConfigSpec> common = new ModConfigSpec.Builder().configure(TestConfig::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, common.getRight());
        COMMON = common.getLeft();
    }
}
