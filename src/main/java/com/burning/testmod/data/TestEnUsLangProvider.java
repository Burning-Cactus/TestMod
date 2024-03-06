package com.burning.testmod.data;

import com.burning.testmod.TestMod;
import com.burning.testmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TestEnUsLangProvider extends LanguageProvider {
    public TestEnUsLangProvider(PackOutput output) {
        super(output, TestMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(ModItems.IRON_DAGGER, "Iron Dagger");
    }
}
