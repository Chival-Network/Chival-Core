package au.chival.core;

import au.chival.core.Commands.*;
import au.chival.core.Events.*;
import au.chival.core.Report.ReportCommand;
import au.chival.core.Vanish.VanishCommand;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;
    public static FileConfiguration config;

    @Override
    public void onEnable() {

        plugin = this;

        reg();
        config();
        database();
    }

    public void config() {

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        this.saveConfig();

        config = this.getConfig();
    }

    public void database() {

    }

    public void reg() {
        //command this.getCommand().setExecutor();
        this.getCommand("sudo").setExecutor(new Sudo());
        this.getCommand("lobby").setExecutor(new Lobby());
        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("vanish").setExecutor(new VanishCommand());
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("speed").setExecutor(new Speed());
        this.getCommand("rank").setExecutor(new Ranks());
        this.getCommand("flys").setExecutor(new Flys());
        this.getCommand("help").setExecutor(new Help());
        this.getCommand("report").setExecutor(new ReportCommand());
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