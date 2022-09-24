package au.chival.core;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
