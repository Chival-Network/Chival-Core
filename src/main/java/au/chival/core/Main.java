package au.chival.core;

import au.chival.core.MainFeatures.Chat.ChatListener;
import au.chival.core.MainFeatures.JoinLeave.JoinListener;
import au.chival.core.MainFeatures.Formatting.LuckPermListeners;
import au.chival.core.MainFeatures.JoinLeave.LeaveListener;
import au.chival.core.MainFeatures.Lobby.PlayerDamageListener;
import au.chival.core.MainFeatures.Lobby.PlayerDeathListener;
import au.chival.core.MainFeatures.Lobby.PlayerHungerListener;
import au.chival.core.QOL.Fly.FlyCommand;
import au.chival.core.QOL.Fly.FlysCommand;
import au.chival.core.QOL.Heal.HealCommand;
import au.chival.core.MainFeatures.Help.HelpCommand;
import au.chival.core.MainFeatures.Ranks.RanksCommand;
import au.chival.core.MainFeatures.Report.ReportCommandTab;
import au.chival.core.MainFeatures.Lobby.Spawning.SetSpawnCommand;
import au.chival.core.QOL.Ride.RideCommand;
import au.chival.core.QOL.Speed.SpeedCommand;
import au.chival.core.QOL.Sudo.SudoCommand;
import au.chival.core.MainFeatures.ToLobby.ToLobbyCommand;
import au.chival.core.QOL.Vanish.VanishCommand;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;
    public static FileConfiguration config;
    public static Location spawnLocation;

    @Override
    public void onEnable() {
        System.out.println("[ppRide] - Successfully started");
        Bukkit.getPluginManager().registerEvents(new RideCommand(),this);

        plugin = this;

        reg();
        config();
        database();
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
        this.getCommand("report").setExecutor(new ReportCommandTab());
        this.getCommand("setspawn").setExecutor(new SetSpawnCommand());

        //tab this.getCommand().setTabCompleter();
        this.getCommand("report").setTabCompleter(new ReportCommandTab());

        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ChatListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDamageListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerHungerListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LeaveListener(), plugin);

        //luckPerms
        new LuckPermListeners(plugin, LuckPermsProvider.get());
    }

    public void config() {

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        this.saveConfig();

        config = this.getConfig();

        this.spawnLocation = new Location(Bukkit.getWorld(String.valueOf(config.get("lobby-loc.world"))), config.getDouble("lobby-loc.x"), config.getDouble("lobby-loc.y"), config.getDouble("lobby-loc.z"), (float) config.getDouble("lobby-loc.yaw"), (float) config.getDouble("lobby-loc.pitch"));
    }

    public void database() {

    }

    @Override
    public void onDisable() {
    }
}