package me.manosgou.joinleavemessage;

import me.manosgou.joinleavemessage.listeners.PlayerJoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
