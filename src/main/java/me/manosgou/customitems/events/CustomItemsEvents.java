package me.manosgou.customitems.events;

import me.manosgou.customitems.CustomItems;
import me.manosgou.customitems.items.ItemsManager;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class CustomItemsEvents implements Listener {

    CustomItems plugin;

    public CustomItemsEvents(CustomItems plugin) {
        this.plugin=plugin;
    }

    @EventHandler
    public void onRightClick(ProjectileHitEvent projectileHitEvent) {
        if (projectileHitEvent.getEntity().getShooter() instanceof Player) {
            Player player = (Player) projectileHitEvent.getEntity().getShooter();
            //Rocket bow event
            if(player.getInventory().getItemInMainHand().getItemMeta().equals(ItemsManager.rocketBow.getItemMeta())){
                if (projectileHitEvent.getEntity().getType().equals(EntityType.ARROW)) {
                    Location location = projectileHitEvent.getEntity().getLocation();
                    player.getWorld().createExplosion(location, 2.0f);
                }
            //Teleportation bow event
            }else if(player.getInventory().getItemInMainHand().getItemMeta().equals(ItemsManager.teleportationBow.getItemMeta())){
                if (projectileHitEvent.getEntity().getType().equals(EntityType.ARROW)) {
                    Location location = projectileHitEvent.getEntity().getLocation();
                    player.teleport(location);
                }

            }
        }
    }
}
