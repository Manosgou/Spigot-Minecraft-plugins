package me.manosgou.tombstone.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.time.LocalDate;
import java.util.Arrays;

public class TombstoneEvents implements Listener {

    @EventHandler
    public void onPlayersDeath(PlayerDeathEvent playerDeathEvent) {
        LocalDate localDate = LocalDate.now();

        Player player = playerDeathEvent.getEntity();

        Location playerLocation = player.getLocation();
        Block playerBlock = playerLocation.getBlock();
        playerLocation.getBlock().setType(Material.OAK_SIGN);
        Sign sign = (Sign) playerBlock.getState();
        sign.setEditable(false);
        sign.setLine(0, ChatColor.DARK_RED + "" + ChatColor.BOLD + "R.I.P");
        sign.setLine(1, ChatColor.AQUA + player.getDisplayName());
        String date = localDate.getDayOfMonth() + "/" + localDate.getMonth().getValue() + "/" + localDate.getYear();
        sign.setLine(3, ChatColor.BOLD + date);
        sign.update();


        if (!player.getInventory().isEmpty()) {

            ItemStack[] playerItems = player.getInventory().getContents();
            long playerItemsCount = Arrays.stream(playerItems).filter(itemStack -> itemStack!=null).count();

            Location chestLocation = sign.getLocation().add(0, 0, 1);
            Block chestBlock = chestLocation.getBlock();
            chestBlock.setType(Material.CHEST);
            Chest chest = (Chest) chestBlock.getState();
            BlockData chestBlockData = chestBlock.getBlockData();
            ((Directional) chestBlockData).setFacing(BlockFace.SOUTH);
            chestBlock.setBlockData(chestBlockData);
            Inventory chestInventory = chest.getInventory();


            if(playerItemsCount>=27){

                Location chestBackLocation = sign.getLocation().add(0, 0, -1);
                Block chestBackBlock = chestBackLocation.getBlock();
                chestBackBlock.setType(Material.CHEST);
                Chest chestBack = (Chest) chestBackBlock.getState();
                Inventory chestBackInventory = chestBack.getInventory();

                ItemStack[] chestFrontItems = Arrays.copyOfRange(playerItems,0,18);
                ItemStack[] chestBackItems = Arrays.copyOfRange(playerItems,19,playerItems.length);

                for (ItemStack item : chestFrontItems) {
                    if (item != null) {
                        chestInventory.addItem(item);
                    }

                }

                for (ItemStack item : chestBackItems) {
                    if (item != null) {
                        chestBackInventory.addItem(item);
                    }

                }
            }else{

                for (ItemStack item : playerItems) {
                    if (item != null) {
                        chestInventory.addItem(item);
                    }

                }
            }


            playerDeathEvent.getDrops().clear();
        }


    }

    @EventHandler
    public void onSignBreak(BlockBreakEvent blockBreakEvent) {
        if (blockBreakEvent.getBlock().getType().equals(Material.OAK_SIGN)) {
            Sign sing = (Sign) blockBreakEvent.getBlock().getState();
            if (sing.getLine(0).equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "R.I.P")) {
                blockBreakEvent.setCancelled(true);
            }
        }

    }
}
