package me.manosgou.tombstone.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.time.LocalDate;

public class TombstoneEvents implements Listener {

    @EventHandler
    public void onPlayersDeath(PlayerDeathEvent playerDeathEvent){
        LocalDate localDate =LocalDate.now();
        Player player = playerDeathEvent.getEntity();
        player.getWorld().getBlockAt(player.getLocation()).setType(Material.OAK_SIGN);
        Sign sign = (Sign) player.getWorld().getBlockAt(player.getLocation()).getState();
        sign.setEditable(false);
        sign.setLine(0, ChatColor.DARK_RED+""+ChatColor.BOLD+"R.I.P");
        sign.setLine(1,ChatColor.AQUA+player.getDisplayName());
        String date = localDate.getDayOfMonth()+"/"+localDate.getMonth().getValue()+"/"+localDate.getYear();
        sign.setLine(3,ChatColor.BOLD+date);
        sign.update();

    }

    @EventHandler
    public void onSignBreak(BlockBreakEvent blockBreakEvent){
        if(blockBreakEvent.getBlock().getType().equals(Material.OAK_SIGN)){
            Sign sing  = (Sign) blockBreakEvent.getBlock().getState();
            if(sing.getLine(0).equalsIgnoreCase(ChatColor.DARK_RED+""+ChatColor.BOLD+"R.I.P")){
                blockBreakEvent.setCancelled(true);
            }
        }

    }
}
