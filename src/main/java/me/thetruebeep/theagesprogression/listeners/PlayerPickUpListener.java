package me.thetruebeep.theagesprogression.listeners;

import me.thetruebeep.theagesprogression.TheAgesProgression;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

public class PlayerPickUpListener implements Listener {

    @EventHandler
    public void onPlayerPickUp(PlayerAttemptPickupItemEvent e){
        String name = e.getItem().getName();
        Player p = e.getPlayer();
        if(name.contains("Iron")){
            e.getItem().getServer().getScheduler().runTask(TheAgesProgression.getPlugin(), () -> {
                if (p.getInventory().contains(e.getItem().getItemStack())) {
                    p.getInventory().removeItem(e.getItem().getItemStack());
                }
            });
            p.sendMessage("You can't pick up " + name);
            p.sendMessage(ChatColor.RED + "Server hasn't hit Iron Age yet");
        }



    }
}
