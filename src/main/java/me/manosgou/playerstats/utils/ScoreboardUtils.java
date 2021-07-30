package me.manosgou.playerstats.utils;

import me.manosgou.playerstats.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class ScoreboardUtils {

    public static ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    public static Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

    public static void createScoreboard(PlayerStats plugin,Player player){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

        Objective objective =scoreboard.registerNewObjective("PlayerStats","dummy","PlayerStats");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.AQUA+"PlayerStats");
        player.setScoreboard(scoreboard);

        Team playerName = scoreboard.registerNewTeam("playerName");
        playerName.addEntry("§4");
        playerName.setPrefix(ChatColor.BOLD+"Player name: "+ChatColor.GREEN+player.getDisplayName());
        objective.getScore("§4").setScore(4);

        Team playerLocation = scoreboard.registerNewTeam("playerLocation");
        playerLocation.addEntry("§3");
        playerLocation.setPrefix(ChatColor.BOLD+"Player location: "+ChatColor.RESET+ChatColor.RED+" X: "+(long)player.getLocation().getX()+ChatColor.GREEN+" Y: "+(long)player.getLocation().getY()+ChatColor.BLUE+" Z: "+(long)player.getLocation().getZ());
        objective.getScore("§3").setScore(3);


        Team playerPing = scoreboard.registerNewTeam("playerPing");
        playerPing.addEntry("§2");
        playerPing.setPrefix(ChatColor.BOLD+"Player ping: "+ChatColor.RESET+player.getPing());
        objective.getScore("§2").setScore(2);


        Team playerDeaths = scoreboard.registerNewTeam("playerDeaths");
        playerDeaths.addEntry("§1");
        playerDeaths.setPrefix(ChatColor.BOLD+"Player's deaths: "+ChatColor.DARK_RED+player.getStatistic(Statistic.DEATHS));
        objective.getScore("§1").setScore(1);





        player.setScoreboard(scoreboard);

        new BukkitRunnable() {
            @Override
            public void run() {

                scoreboard.getTeam("playerLocation").setPrefix(ChatColor.BOLD+"Player location: "+ChatColor.RESET+ChatColor.RED+" X: "+(long)player.getLocation().getX()+ChatColor.GREEN+" Y: "+(long)player.getLocation().getY()+ChatColor.BLUE+" Z: "+(long)player.getLocation().getZ());

                char color = 0;
                if(player.getPing()>150){
                    color='4';
                }else if(player.getPing()>100){
                    color='c';
                }else if(player.getPing()>70){
                    color='e';
                }else if(player.getPing()>50){
                    color='a';
                } else if(player.getPing()>20){
                    color='2';
                }

                scoreboard.getTeam("playerPing").setPrefix(ChatColor.BOLD+"Player ping: "+ChatColor.RESET+ChatColor.getByChar(color)+player.getPing());
            }
        }.runTaskTimer(plugin, 0, 10);


    }
}
