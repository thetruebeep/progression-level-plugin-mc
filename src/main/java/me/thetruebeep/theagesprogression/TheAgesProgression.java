package me.thetruebeep.theagesprogression;

import me.thetruebeep.theagesprogression.listeners.PlayerPickUpListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheAgesProgression extends JavaPlugin {

    private static TheAgesProgression plugin;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerPickUpListener(), this);
        getLogger().info("@TheAgesProgression: Plugin has started up");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("@TheAgesProgression: Plugin has been disabled");
    }

    public static TheAgesProgression getPlugin() {
        return plugin;
    }
}
