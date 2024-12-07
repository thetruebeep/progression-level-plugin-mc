package me.thetruebeep.theagesprogression;

import me.thetruebeep.theagesprogression.cmds.SetProgressionLevelCommand;
import me.thetruebeep.theagesprogression.listeners.InventoryTransferListener;
import me.thetruebeep.theagesprogression.listeners.PickUpItemsListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TheAgesProgression extends JavaPlugin {

    private static TheAgesProgression plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new PickUpItemsListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryTransferListener(), this);
        getLogger().info("@TheAgesProgression: Plugin Listeners Registered");

        Objects.requireNonNull(getCommand("progression_level")).setExecutor(new SetProgressionLevelCommand());
        getLogger().info("@TheAgesProgression: Plugin Commands Registered");

        ProgressionSettings.getInstance().load();
        getLogger().info("@TheAgesProgression: Settings have loaded");
        getLogger().warning("@TheAgesProgression: Plugin has started up");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().warning("@TheAgesProgression: Plugin has been disabled");
    }

    public static TheAgesProgression getPlugin() {
        return plugin;
    }
}
