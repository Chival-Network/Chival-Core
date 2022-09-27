package au.chival.core.Events;

import au.chival.core.Formatting.Formatting;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.core.Main.plugin;

public class JoinLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                while (event.getPlayer() == null) {}
                if (event.getPlayer() == null) {event.getPlayer().kickPlayer(ChatColor.RED + "Failed to load profile... Please rejoin");}
                new Formatting(event.getPlayer().getUniqueId(), true, "[BETA] Chival.cf", "/help for help");
            }
        }.runTaskAsynchronously(plugin);
    }
}
