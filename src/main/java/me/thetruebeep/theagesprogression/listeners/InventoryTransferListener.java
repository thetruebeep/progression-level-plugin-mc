package me.thetruebeep.theagesprogression.listeners;

import me.thetruebeep.theagesprogression.ProgressionSettings;
import me.thetruebeep.theagesprogression.TheAgesProgression;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class InventoryTransferListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        new BukkitRunnable() {
            @Override
            public void run() {

                if (Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Netherite")) {
                    return;
                }
                if (Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Diamond")) {
                    Inventory inventory = p.getInventory();
                    for(ItemStack item : inventory.getContents()){
                        if (item != null) {
                            String itemName = item.getType().name();
                            if(itemName.contains("NETHERITE")){
                                p.getInventory().removeItem(item);
                            }
                        }
                    }
                }
                if (Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Iron")) {
                    Inventory inventory = p.getInventory();
                    for(ItemStack item : inventory.getContents()){
                        if (item != null) {
                            String itemName = item.getType().name();
                            if(itemName.contains("DIAMOND") || itemName.contains("NETHERITE")){
                                p.getInventory().removeItem(item);
                            }
                        }
                    }
                }
                if (Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Stone")) {
                    Inventory inventory = p.getInventory();
                    for(ItemStack item : inventory.getContents()){
                        if (item != null) {
                            String itemName = item.getType().name(); // Item type (e.g., DIAMOND_SWORD)
                            if(itemName.contains("IRON") || itemName.contains("DIAMOND") || itemName.contains("NETHERITE")){
                                p.getInventory().removeItem(item);
                            }
                        }
                    }
                }
                if (Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Wood")) {
                    Inventory inventory = p.getInventory();
                    for(ItemStack item : inventory.getContents()){
                        if (item != null) {
                            String itemName = item.getType().name(); // Item type (e.g., DIAMOND_SWORD)
                            if(itemName.contains("IRON") || itemName.contains("DIAMOND") || itemName.contains("NETHERITE") || itemName.contains("GOLD") || itemName.contains("STONE")){
                                if(itemName == "COBBLESTONE"){
                                    return;
                                }
                                if(itemName == "GOLDEN_APPLE"){
                                    return;
                                }
                                if(itemName == "ENCHANTED_GOLDEN_APPLE"){
                                    return;
                                }
                                p.getInventory().removeItem(item);
                            }
                        }
                    }
                }
            }
        }.runTaskLater(TheAgesProgression.getPlugin(), 1L);
    }
}
