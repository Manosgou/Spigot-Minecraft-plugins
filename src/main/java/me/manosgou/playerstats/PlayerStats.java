package me.manosgou.playerstats;

import me.manosgou.playerstats.commands.ScoreboardCommands;
import me.manosgou.playerstats.listeners.PlayerListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerStats extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListeners(this),this);
        getCommand("stats").setExecutor(new ScoreboardCommands(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
