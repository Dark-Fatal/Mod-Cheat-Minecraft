package com.shadowcore.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.List;

public class AdminPanelScreen extends Screen {
    private static final List<CommandEntry> COMMANDS = List.of(
            new CommandEntry("Gamemode Creative", "/gamemode creative"),
            new CommandEntry("Gamemode Survival", "/gamemode survival"),
            new CommandEntry("Set Day", "/time set day"),
            new CommandEntry("Set Night", "/time set night"),
            new CommandEntry("Clear Weather", "/weather clear"),
            new CommandEntry("Rain", "/weather rain"),
            new CommandEntry("Kick all (example)", "/kick @a"),
            new CommandEntry("Stop server", "/stop")
    );

    public AdminPanelScreen() {
        super(Text.literal("ShadowCore - Admin Panel"));
    }

    @Override
    protected void init() {
        createButtons();
    }

    private void createButtons() {
        final int panelWidth = 220;
        final int buttonWidth = 200;
        final int buttonHeight = 20;
        final int startX = (width - panelWidth) / 2 + 10;
        final int startY = (height / 2) - (COMMANDS.size() * 12);

        for (int i = 0; i < COMMANDS.size(); i++) {
            CommandEntry entry = COMMANDS.get(i);
            int y = startY + i * 24;

            addDrawableChild(ButtonWidget.builder(Text.literal(entry.label()), button -> runCommand(entry.command()))
                    .dimensions(startX, y, buttonWidth, buttonHeight)
                    .build());
        }

        addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> close())
                .dimensions(startX, startY + COMMANDS.size() * 24 + 10, buttonWidth, buttonHeight)
                .build());
    }

    private void runCommand(String command) {
        if (client == null || client.player == null) {
            return;
        }

        String normalized = command.startsWith("/") ? command.substring(1) : command;
        client.player.networkHandler.sendChatCommand(normalized);
        client.player.sendMessage(Text.literal("§7[ShadowCore] Commande exécutée: §f/" + normalized), false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        int panelWidth = 220;
        int panelHeight = COMMANDS.size() * 24 + 50;
        int x = (width - panelWidth) / 2;
        int y = (height - panelHeight) / 2;

        context.fill(x, y, x + panelWidth, y + panelHeight, 0xCC111111);
        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, y + 10, 0xFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }

    private record CommandEntry(String label, String command) {
    }
}
