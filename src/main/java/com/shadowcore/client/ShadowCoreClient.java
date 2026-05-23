package com.shadowcore.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ShadowCoreClient implements ClientModInitializer {
    private static KeyBinding openPanelKey;

    @Override
    public void onInitializeClient() {
        openPanelKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.shadowcore.open_panel",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                "category.shadowcore"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openPanelKey.wasPressed()) {
                client.setScreen(new AdminPanelScreen());
            }
        });
    }
}
