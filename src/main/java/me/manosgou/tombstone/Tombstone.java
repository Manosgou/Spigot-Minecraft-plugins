package me.manosgou.tombstone;

import me.manosgou.tombstone.events.TombstoneEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tombstone extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TombstoneEvents(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
