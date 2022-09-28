package au.chival.core.Events;

import au.chival.core.Commands.VanishCommand;
import au.chival.core.Formatting.Formatting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import au.chival.core.Commands.VanishCommand.*;

import static au.chival.core.Main.plugin;

public class JoinLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                event.getPlayer().sendMessage(ChatColor.GREEN + "Loading profile...");
                while (event.getPlayer() == null) {}
                if (event.getPlayer() == null) {event.getPlayer().kickPlayer(ChatColor.RED + "Failed to load profile... Please rejoin");}
                new Formatting(event.getPlayer().getUniqueId(), true, "&bYou Are Playing On &6&lMC.CHIVAL.AU"  , "&bDo &2/help &bfor help");
            }
        }.runTaskAsynchronously(plugin);

        for (Player target : Bukkit.getOnlinePlayers()) {
            if (!target.hasPermission("chival.cansee")) {
                target.hidePlayer(vanished);
            }
        }
    }
}
