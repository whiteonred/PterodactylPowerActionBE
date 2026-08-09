package fr.pickaria.pterodactylpoweraction.component;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.NamedTextColor;

public class RunCommand {
    private final String command;
    private final Component displayComponent;

    public RunCommand(String command, Component displayComponent) {
        assert command.startsWith("/");

        this.command = command;
        this.displayComponent = displayComponent;
    }

    public Component getComponent() {
        return displayComponent.colorIfAbsent(NamedTextColor.AQUA)
                .decorate(TextDecoration.UNDERLINED)
                .clickEvent(ClickEvent.runCommand(this.command))
                .hoverEvent(getHoverComponent());
    }

    Component getHoverComponent() {
        return Component.translatable("run.command", Component.text(command.trim()).color(NamedTextColor.AQUA));
    }
}
