package me.thetruebeep.theagesprogression.cmds;

import me.thetruebeep.theagesprogression.api.ProgressionSettings;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SetProgressionLevelCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length > 1){
            return false;
        }
        if(args.length < 1){
            sender.sendMessage(Component.text("Please specify the progression stage").color(NamedTextColor.RED));
            return false;
        }

        if(args[0].equalsIgnoreCase("wood")){
            sender.sendMessage("Setting the worlds progression stage to wood");
            ProgressionSettings.getInstance().setProgressionLevel("Wood");
            showTitleToAll("Wood Age", "The server has entered the Wood Age!");
            return true;
        } else if (args[0].equalsIgnoreCase("stone")) {
            sender.sendMessage("Setting the worlds progression stage to stone");
            ProgressionSettings.getInstance().setProgressionLevel("Stone");
            showTitleToAll("Stone Age", "The server has entered the Stone Age!");
            return true;
        }else if (args[0].equalsIgnoreCase("iron")){
            sender.sendMessage("Setting the worlds progression stage to iron");
            ProgressionSettings.getInstance().setProgressionLevel("Iron");
            showTitleToAll("Iron Age", "The server has entered the Iron Age!");
            return true;
        } else if (args[0].equalsIgnoreCase("diamond")){
            sender.sendMessage("Setting the worlds progression stage to diamond");
            ProgressionSettings.getInstance().setProgressionLevel("Diamond");
            showTitleToAll("Diamond Age", "The server has entered the Diamond Age!");
            return true;
        } else if (args[0].equalsIgnoreCase("netherite")) {
            sender.sendMessage(Component.text("Setting the worlds progression stage to netherite"));
            ProgressionSettings.getInstance().setProgressionLevel("Netherite");
            showTitleToAll("Netherite Age", "The server has entered the Netherite Age!");
            return true;
        } else{
            sender.sendMessage(Component.text("You have not specified a progression level").color(NamedTextColor.RED));
            return false;
        }
    }

    private void showTitleToAll(String title, String subtitle) {
        Title.Times times = Title.Times.times(
                Duration.ofSeconds(1),
                Duration.ofSeconds(3),
                Duration.ofSeconds(1)
        );

        Title titleToShow = Title.title(
                Component.text(title).color(NamedTextColor.GOLD),
                Component.text(subtitle).color(NamedTextColor.YELLOW),
                times
        );

        Bukkit.getOnlinePlayers().forEach(player -> player.showTitle(titleToShow));
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("wood");
            completions.add("stone");
            completions.add("iron");
            completions.add("diamond");
            completions.add("netherite");
            return completions;
        }
        return new ArrayList<>();
    }
}