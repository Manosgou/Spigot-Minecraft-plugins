package me.manosgou.teleportgui.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class TeleportMenuUtils {

    public static void requestTeleportMenu(Player player){
        ArrayList<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
        players.remove(player);
        Inventory onlinePlayersMenu =  Bukkit.createInventory(player, Math.max(players.size(), 9), ChatColor.BOLD + "Teleport to");

        for (Player value : players) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = playerHead.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(value.getDisplayName());
                playerHead.setItemMeta(meta);
                onlinePlayersMenu.addItem(playerHead);
            }
        }
        player.openInventory(onlinePlayersMenu);
    }

    public static void teleportActionsMenu(Player playerRequest,Player player) {
        Inventory teleportActionsMenu = Bukkit.createInventory(player, 9, ChatColor.BOLD+"Teleport request");

        ItemStack accept = new ItemStack(Material.EMERALD, 1);
        ItemMeta acceptMeta = accept.getItemMeta();
        if (acceptMeta != null) {
            acceptMeta.setDisplayName(ChatColor.GREEN + "Accept");
            ArrayList<String> acceptLore = new ArrayList<>();
            acceptLore.add(playerRequest.getDisplayName());
            acceptLore.add("Requests teleport");
            acceptMeta.setLore(acceptLore);
            accept.setItemMeta(acceptMeta);
            teleportActionsMenu.setItem(0, accept);
        }


        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancelMeta = accept.getItemMeta();
        if (cancelMeta != null) {
            cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
            cancel.setItemMeta(cancelMeta);
            teleportActionsMenu.setItem(8, cancel);
        }

        player.openInventory(teleportActionsMenu);

    }
}
