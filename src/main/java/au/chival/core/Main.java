package au.chival.core;

import au.chival.core.Events.JoinLeave;
import au.chival.core.commands.fly;
import au.chival.core.commands.gamemode;
import au.chival.core.commands.speed;
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
        this.getCommand("mode").setExecutor(new gamemode());
        this.getCommand("vanish").setExecutor(new vanish());
        this.getCommand("fly").setExecutor(new fly());
        this.getCommand("speed").setExecutor(new speed());
        //listeners plugin.getServer().getPluginManager().registerEvents(new , plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinLeave(), plugin);
    }

    @Override
    public void onDisable() {


    }

    @EventHandler
    public void onPlayerJoinVoid(PlayerJoinEvent e) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (vanish.vanished.contains(p)) {
                e.getPlayer().hidePlayer(p);
            }
        }
    }
}