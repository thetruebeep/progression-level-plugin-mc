package me.thetruebeep.theagesprogression.cmds;

import me.thetruebeep.theagesprogression.ProgressionSettings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SetProgressionLevelCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length > 1){
            return false;
        }
        if(args.length < 1){
            sender.sendMessage("Please specify the progression stage");
            return false;
        }
        if(args.length == 1 && args[0].equalsIgnoreCase("wood")){
            sender.sendMessage("Setting the worlds progression stage to wood");
            ProgressionSettings.getInstance().setProgressionLevel("Wood");
            return true;
        } else if (args.length == 1 && args[0].equalsIgnoreCase("stone")) {
            sender.sendMessage("Setting the worlds progression stage to stone");
            ProgressionSettings.getInstance().setProgressionLevel("Stone");
            return true;
        }else if (args.length == 1 && args[0].equalsIgnoreCase("iron")){
            sender.sendMessage("Setting the worlds progression stage to iron");
            ProgressionSettings.getInstance().setProgressionLevel("Iron");
            return true;

        } else if (args.length == 1 && args[0].equalsIgnoreCase("diamond")){
            sender.sendMessage("Setting the worlds progression stage to diamond");
            ProgressionSettings.getInstance().setProgressionLevel("Diamond");
            return true;

        } else if (args.length == 1 && args[0].equalsIgnoreCase("netherite")) {
            sender.sendMessage("Setting the worlds progression stage to netherite");
            ProgressionSettings.getInstance().setProgressionLevel("Netherite");
            return true;

        } else{
            sender.sendMessage("You have not specified a progression level");
            return false;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {



        return new ArrayList<>();
    }
}
