package au.chival.core.listeners;

import au.chival.core.main;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class blocks implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getWorld().equals(main.lobbyWorld)) {
            if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            } else {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getPlayer().getWorld().equals(main.lobbyWorld)) {
            if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            } else {
                event.setCancelled(true);
            }
        }
    }
}
