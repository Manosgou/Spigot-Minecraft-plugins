package me.manosgou.playerstats.listeners;


import me.manosgou.playerstats.PlayerStats;
import me.manosgou.playerstats.utils.ScoreboardUtils;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class PlayerListeners implements Listener {

    PlayerStats plugin;

    public PlayerListeners(PlayerStats plugin) {
        this.plugin=plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        ScoreboardUtils.createScoreboard(plugin,player);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent playerDeathEvent){
        Player player =playerDeathEvent.getEntity();
        ScoreboardUtils.scoreboard.getTeam("playerDeaths").setPrefix(ChatColor.BOLD+"Player's deaths: "+ChatColor.DARK_RED+player.getStatistic(Statistic.DEATHS));
    }

}
