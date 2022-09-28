package au.chival.core;

import au.chival.core.Commands.Fly;
import au.chival.core.Commands.Gamemode;
import au.chival.core.Commands.Speed;
import au.chival.core.Commands.VanishCommand;
import au.chival.core.Events.JoinLeave;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
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
        this.getCommand("mode").setExecutor(new Gamemode());
        this.getCommand("vanish").setExecutor(new VanishCommand());
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("speed").setExecutor(new Speed());
        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinLeave(), plugin);
    }

    @Override
    public void onDisable() {
    }
}