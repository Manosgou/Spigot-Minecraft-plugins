package me.manosgou.teleportgui;

import me.manosgou.teleportgui.commands.TeleportCommand;
import me.manosgou.teleportgui.listeners.TeleportMenuListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class TeleportGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("teleport")).setExecutor(new TeleportCommand());
        getServer().getPluginManager().registerEvents(new TeleportMenuListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
