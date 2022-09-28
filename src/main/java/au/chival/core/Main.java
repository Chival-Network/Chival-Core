package au.chival.core;

import au.chival.core.Events.Chat;
import au.chival.core.Events.JoinLeave;
import au.chival.core.Commands.Fly;
import au.chival.core.Commands.Speed;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        reg();
    }

    public void reg() {
        //command this.getCommand().setExecutor();
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("speed").setExecutor(new Speed());
        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinLeave(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Chat(), plugin);
    }

    @Override
    public void onDisable() {

    }
}