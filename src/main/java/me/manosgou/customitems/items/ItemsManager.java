package me.manosgou.customitems.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import java.util.ArrayList;

public class ItemsManager {

    public static ItemStack rocketBow;
    public static ItemStack teleportationBow;

    public static void init(){
        createRocketBow();
        createTeleportationBow();
    }


    public static void createRocketBow(){
        ItemStack item = new ItemStack(Material.BOW,1);
        ItemMeta itemMeta =item.getItemMeta();
        if(itemMeta!=null){
            itemMeta.setDisplayName("Rocket bow");
            ArrayList<String> itemLore = new ArrayList<>();
            itemLore.add("It works like a rocket launcher");
            itemLore.add("But it's not a rocket launcher :)");
            itemMeta.setLore(itemLore);
            itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(itemMeta);
        }
        rocketBow =item;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("rocket-bow"),item);
        shapedRecipe.shape("TTT","TBT","TTT");
        shapedRecipe.setIngredient('T',Material.TNT);
        shapedRecipe.setIngredient('B',Material.BOW);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }


    public static void createTeleportationBow(){
        ItemStack item = new ItemStack(Material.BOW,1);
        ItemMeta itemMeta =item.getItemMeta();
        if(itemMeta!=null){
            itemMeta.setDisplayName("Teleportation bow");
            ArrayList<String> itemLore = new ArrayList<>();
            itemLore.add("I have a bow,i have an ender pearl");
            itemLore.add("Ough teleportation bow:)");
            itemMeta.setLore(itemLore);
            itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(itemMeta);
        }
        teleportationBow =item;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("teleportation-bow"),item);
        shapedRecipe.shape("EEE","EBE","EEE");
        shapedRecipe.setIngredient('E',Material.ENDER_PEARL);
        shapedRecipe.setIngredient('B',Material.BOW);
        Bukkit.getServer().addRecipe(shapedRecipe);

    }


}
