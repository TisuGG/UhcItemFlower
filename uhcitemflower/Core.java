package tissuegg.uhcitemflower;

import org.bukkit.plugin.java.JavaPlugin;

import tissuegg.uhcitemflower.Managers.FlowerManager;

import org.bukkit.Bukkit;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new FlowerManager(), this);
    }

    @Override
    public void onDisable() {
    	
    }
}
