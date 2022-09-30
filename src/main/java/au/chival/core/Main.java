package au.chival.core;

import au.chival.core.MainFeatures.Chat.ChatListener;
import au.chival.core.MainFeatures.JoinLeave.JoinListener;
import au.chival.core.MainFeatures.Formatting.LuckPermListeners;
import au.chival.core.MainFeatures.Lobby.PlayerDamageListener;
import au.chival.core.MainFeatures.Lobby.PlayerDeathListener;
import au.chival.core.MainFeatures.Lobby.PlayerHungerListener;
import au.chival.core.QOF.Fly.FlyCommand;
import au.chival.core.QOF.Fly.FlysCommand;
import au.chival.core.QOF.Heal.HealCommand;
import au.chival.core.MainFeatures.Help.HelpCommand;
import au.chival.core.MainFeatures.Ranks.RanksCommand;
import au.chival.core.MainFeatures.Report.ReportCommand;
import au.chival.core.MainFeatures.Lobby.Spawning.SetSpawnCommand;
import au.chival.core.QOF.Speed.SpeedCommand;
import au.chival.core.QOF.Sudo.SudoCommand;
import au.chival.core.MainFeatures.ToLobby.ToLobbyCommand;
import au.chival.core.QOF.Vanish.VanishCommand;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;
    public static FileConfiguration config;

    //add database
    public static Location spawnLocation;

    @Override
    public void onEnable() {

        if (spawnLocation == null) {
            spawnLocation = new Location(Bukkit.getWorld("world"), 0, 64, 0);
        }

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
        this.getCommand("sudo").setExecutor(new SudoCommand());
        this.getCommand("lobby").setExecutor(new ToLobbyCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("vanish").setExecutor(new VanishCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("speed").setExecutor(new SpeedCommand());
        this.getCommand("rank").setExecutor(new RanksCommand());
        this.getCommand("flys").setExecutor(new FlysCommand());
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("setspawn").setExecutor(new SetSpawnCommand());
        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ChatListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDamageListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerHungerListener(), plugin);
        //luckPerms
        new LuckPermListeners(plugin, LuckPermsProvider.get());
    }

    @Override
    public void onDisable() {
    }
}