package com.burning.testmod.client.event;

import com.burning.testmod.TestConfig;
import com.burning.testmod.TestMod;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ScreenEvent;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, value = Dist.CLIENT)
public class ScreenEvents {
    @SubscribeEvent
    public static void onTitleScreenInit(ScreenEvent.Opening event) {
        if (event.getNewScreen() instanceof TitleScreen screen) {
            if (TestConfig.COMMON.showExampleText.get())
                screen.renderables.add(new Button.Builder(Component.literal("Configured text"), button -> {}).bounds(30, 30, 60, 60).build());
        }
    }
}
