package au.chival.coreOLD;

import au.chival.coreOLD.commands.*;
import au.chival.coreOLD.formatting.chatFormatting;
import au.chival.coreOLD.listeners.blocks;
import au.chival.coreOLD.listeners.damage;
import au.chival.coreOLD.listeners.joinQuit;
import au.chival.coreOLD.listeners.voidSaver;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {


    //lobbyWorld
    public static World lobbyWorld;
    public static Location spawnLocation;
    public static LuckPerms luckPermsApi;
    public static Plugin plugin;

    //onEnable
    @Override
    public void onEnable() {
        registers();
        luckPerms();

        lobbyWorld = Bukkit.getWorld("world");
        spawnLocation = new Location(lobbyWorld, 21.5, 119, -14.5, 180, 0);
        plugin = this;
        new repeat().repeatFormatting(1000, 7);
    }
    public void luckPerms() {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            luckPermsApi = provider.getProvider();
        }
    }
    //registers
    public void registers() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        //registers
        this.getCommand("rank").setExecutor(new rankCommand());
        this.getCommand("wtp").setExecutor(new worldTp());
        this.getCommand("wc").setExecutor(new worldCreate());
        this.getCommand("speed").setExecutor(new speedCommand());
        this.getCommand("test").setExecutor(new TestCommand());
        pm.registerEvents(new blocks(), this);
        pm.registerEvents(new joinQuit(), this);
        pm.registerEvents(new damage(), this);
        pm.registerEvents(new voidSaver(), this);
        pm.registerEvents(new chatFormatting(), this);
    }

    //onDisable
    @Override
    public void onDisable() {

    }
}