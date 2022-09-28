package au.chival.core;

import au.chival.core.Commands.*;
import au.chival.core.Events.Chat;
import au.chival.core.Events.JoinLeave;
import au.chival.core.Events.UpdateUser;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {

        //new File(getDataFolder(), "").mkdirs();
        //FileConfiguration arenasConfig;
        //File arenasFile = new File(this.plugin.getDataFolder(), "config.yml");
        //if (!(arenasFile.exists())) {
        //    try {
        //        arenasFile.createNewFile();
        //        Files.copy(getClass().getClassLoader().getResourceAsStream("config.yml"), arenasFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        //    } catch (IOException e) {
        //        Bukkit.getLogger().info("UNABLE TO COPY YML FROM JAR |[ " + e + " ]|");
        //    }
        //}
        //arenasConfig = YamlConfiguration.loadConfiguration(arenasFile);

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
        this.getCommand("flys").setExecutor(new Flys());
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