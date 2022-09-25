package au.chival.core.listeners;

import au.chival.core.formatting.formatting;
import au.chival.core.main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class joinQuit implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.getPlayer().teleport(main.spawnLocation);
        event.setJoinMessage(null);
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);

        if (player.hasPermission("  chival.wtp")) {
            player.setAllowFlight(true);
        }

        new formatting(player, true);

    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}
