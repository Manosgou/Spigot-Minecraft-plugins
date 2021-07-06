package me.manosgou.customitems;

import me.manosgou.customitems.events.CustomItemsEvents;
import me.manosgou.customitems.items.ItemsManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemsManager.init();
        getServer().getPluginManager().registerEvents(new CustomItemsEvents(this),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
