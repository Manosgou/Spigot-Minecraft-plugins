package me.manosgou.tombstone.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TombstoneEvents implements Listener {

    @EventHandler
    public void onPlayersDeath(PlayerDeathEvent playerDeathEvent){
        LocalDate localDate =LocalDate.now();

        Player player = playerDeathEvent.getEntity();
        ArrayList<ItemStack> playerItems = new ArrayList<>(Arrays.asList(player.getInventory().getContents()));

        Location playerLocation = player.getLocation();
        Block playerBlock = playerLocation.getBlock();
        playerLocation.getBlock().setType(Material.OAK_SIGN);

        Sign sign = (Sign) playerBlock.getState();
        Location signLocation = sign.getLocation().add(0,0,1);
        Block signBlock = signLocation.getBlock();
        signLocation.getBlock().setType(Material.CHEST);
        sign.setEditable(false);
        sign.setLine(0, ChatColor.DARK_RED+""+ChatColor.BOLD+"R.I.P");
        sign.setLine(1,ChatColor.AQUA+player.getDisplayName());
        String date = localDate.getDayOfMonth()+"/"+localDate.getMonth().getValue()+"/"+localDate.getYear();
        sign.setLine(3,ChatColor.BOLD+date);
        sign.update();

        Chest chest = (Chest) signBlock.getState();
        Inventory chestInventory = chest.getInventory();
        for(ItemStack item:playerItems){
            if(item != null){
                chestInventory.addItem(item);
            }

        }

        List<ItemStack> dropedItems = playerDeathEvent.getDrops();
        Iterator<ItemStack> dropedItemsIterator = dropedItems.iterator();
        while(dropedItemsIterator.hasNext()){
            ItemStack item = dropedItemsIterator.next();
            dropedItemsIterator.remove();
        }

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
