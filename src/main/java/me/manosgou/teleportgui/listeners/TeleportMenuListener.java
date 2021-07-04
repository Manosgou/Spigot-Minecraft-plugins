package me.manosgou.teleportgui.listeners;

import me.manosgou.teleportgui.utils.TeleportMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.Objects;

public class TeleportMenuListener implements Listener {

    @EventHandler
    public void teleportMenuActions(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BOLD + "Teleport to")) {
            event.setCancelled(true);
            if (Objects.requireNonNull(event.getCurrentItem()).getType() == Material.PLAYER_HEAD) {
                Player teleportTo = player.getServer().getPlayerExact(ChatColor.stripColor(Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName()));
                if (teleportTo != null) {
                    TeleportMenuUtils.teleportActionsMenu(player, teleportTo);
                    player.closeInventory();
                }
            }

        }else if(event.getView().getTitle().equalsIgnoreCase(ChatColor.BOLD+"Teleport request")){
            event.setCancelled(true);
            switch (Objects.requireNonNull(event.getCurrentItem()).getType()) {
                case EMERALD:
                    String playerRequestName = Objects.requireNonNull(Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getLore()).get(0);
                    Player playerRequset = player.getServer().getPlayerExact(playerRequestName);
                    if (playerRequset != null) {
                        playerRequset.teleport(player.getLocation());
                        player.closeInventory();
                    }
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
        }

    }
}
