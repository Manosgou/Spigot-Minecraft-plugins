package me.manosgou.playerstats.commands;

import me.manosgou.playerstats.PlayerStats;
import me.manosgou.playerstats.utils.ScoreboardUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;

public class ScoreboardCommands implements CommandExecutor {

    PlayerStats plugin;

    public ScoreboardCommands(PlayerStats plugin) {
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length==0){
                player.sendMessage("");
            }else{
                Objective scoreboard = player.getScoreboard().getObjective("PlayerStats");
                switch (args[0]){
                    case "show":
                        if(scoreboard!=null){
                            ScoreboardUtils.createScoreboard(plugin,player);
                        }else{
                            player.sendMessage("Scoreboard is already visible");
                        }
                        break;
                    case "hide":
                        if(scoreboard==null){
                            player.sendMessage("Scoreboard is already hidden");
                        }else{
                            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
                        }
                        break;
                }
            }

        }


        return false;
    }
}
