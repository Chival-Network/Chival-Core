package au.chival.core;

import au.chival.core.Commands.*;
import au.chival.core.Events.*;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    public static Plugin plugin;
    FileConfiguration config;

    @Override
    public void onEnable() {

        plugin = this;

        reg();
        config();
        database();
    }

    public void config() {
        config = this.getConfig();
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    public void database() {

    }

    public void reg() {
        //command this.getCommand().setExecutor();
        this.getCommand("sudo").setExecutor(new Sudo());
        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("mode").setExecutor(new Gamemode());
        this.getCommand("vanish").setExecutor(new VanishC());
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("speed").setExecutor(new Speed());
        this.getCommand("rank").setExecutor(new Ranks());
        this.getCommand("flys").setExecutor(new Flys());
        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinLeave(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Chat(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDeath(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDamage(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerHunger(), plugin);
        //luckPerms
        new UpdateUser(plugin, LuckPermsProvider.get());
    }

    @Override
    public void onDisable() {
    }
}