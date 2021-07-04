package me.manosgou.teleportgui.commands;

import me.manosgou.teleportgui.utils.TeleportMenuUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            TeleportMenuUtils.requestTeleportMenu(player);

        }
        return false;
    }
}
