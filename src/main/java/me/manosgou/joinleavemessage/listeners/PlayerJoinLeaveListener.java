package me.manosgou.joinleavemessage.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
        Player player =playerJoinEvent.getPlayer();
        if(!player.hasPlayedBefore()){
            playerJoinEvent.setJoinMessage(ChatColor.GREEN+"O neos einai wraios,kalws irthes"+ChatColor.DARK_GREEN+ChatColor.BOLD+player.getDisplayName());
        }
        playerJoinEvent.setJoinMessage(ChatColor.RED+""+ChatColor.BOLD+player.getDisplayName()+ ChatColor.AQUA +"katharma, ti gyreyeis esy edw");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent playerQuitEvent){
        Player player = playerQuitEvent.getPlayer();
        playerQuitEvent.setQuitMessage(ChatColor.DARK_RED+"Ta legame "+ChatColor.BOLD+player.getDisplayName());

    }
}
