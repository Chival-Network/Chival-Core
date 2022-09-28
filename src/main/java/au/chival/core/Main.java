package au.chival.core;

import au.chival.core.Commands.*;
import au.chival.core.Events.Chat;
import au.chival.core.Events.JoinLeave;
import au.chival.core.Events.UpdateUser;
import net.luckperms.api.LuckPermsProvider;
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
        this.getCommand("rank").setExecutor(new Ranks());
        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinLeave(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Chat(), plugin);
        //luckPerms
        new UpdateUser(plugin, LuckPermsProvider.get());
    }

    @Override
    public void onDisable() {
    }
}