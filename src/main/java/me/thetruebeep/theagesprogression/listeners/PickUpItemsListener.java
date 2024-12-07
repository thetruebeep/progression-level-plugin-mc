package me.thetruebeep.theagesprogression.listeners;

import me.thetruebeep.theagesprogression.ProgressionSettings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

import java.util.Objects;

public class PickUpItemsListener implements Listener {
    @EventHandler
    public void PickUpItemsListener(PlayerAttemptPickupItemEvent e){
        String name = e.getItem().getName();
        Player p = e.getPlayer();

        if(Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Wood")){
            if(name.contains("Stone")) {
                if (name.contains("Cobblestone")) {
                    return;
                }
                e.setCancelled(true);
            }
            if(name.contains("Iron")) {
                e.setCancelled(true);
            }
            if(name.contains("Gold")) {
                e.setCancelled(true);
            }
            if(name.contains("Diamond")) {
                e.setCancelled(true);
            }
            if(name.contains("Netherite")) {
                e.setCancelled(true);
            }
        };
        if(Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Stone")){
            if(name.contains("Iron")) {
                e.setCancelled(true);
            }
            if(name.contains("Diamond")) {
                e.setCancelled(true);
            }
            if(name.contains("Netherite")) {
                e.setCancelled(true);
            }
        };
        if(Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Iron")){
            if(name.contains("Diamond")) {
                e.setCancelled(true);
            }
            if(name.contains("Netherite")) {
                e.setCancelled(true);
            }
        };
        if(Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Diamond")){
            if(name.contains("Netherite")) {
                e.setCancelled(true);
            }
        };
        if(Objects.equals(ProgressionSettings.getInstance().getProgressionLevel(), "Netherite")){
            return;
        };
    }
}
