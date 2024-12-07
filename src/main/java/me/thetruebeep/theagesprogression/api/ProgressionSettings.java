package me.thetruebeep.theagesprogression.api;

import me.thetruebeep.theagesprogression.TheAgesProgression;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ProgressionSettings {
    private final static ProgressionSettings instance = new ProgressionSettings();
    private File file;
    private YamlConfiguration config;
    private String progressionLevel;
    private ProgressionSettings() {
    }

    public void load() {
        file = new File(TheAgesProgression.getPlugin().getDataFolder(), "settings.yml");
        if (!file.exists()){
            TheAgesProgression.getPlugin().saveResource("settings.yml", false);
        }
        config = new YamlConfiguration();
        config.options().parseComments(true);

        try{
            config.load(file);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        progressionLevel = config.getString("Progression_Level");
    }

    public void save() {
        try{
            config.save(file);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void set(String path, Object value){
        config.set(path,value);
        save();
    }

    public String getProgressionLevel(){
        return progressionLevel;
    }

    public void setProgressionLevel(String progressionLevel) {
        this.progressionLevel = progressionLevel;
        set("Progression_Level", progressionLevel);
    }

    public static ProgressionSettings getInstance(){
        return instance;
    }
}



