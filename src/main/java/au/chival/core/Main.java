package au.chival.core;

import au.chival.core.commands.Fly;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;


        getCommand("fly").setExecutor(new Fly());

    }

    @Override
    public void onDisable() {

    }
}