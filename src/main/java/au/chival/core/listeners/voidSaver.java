package au.chival.core.listeners;

import au.chival.core.main;
import au.chival.core.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class voidSaver implements Listener {
    @EventHandler
    public void playerMove(PlayerMoveEvent event) {
        if (event.getPlayer().getWorld().equals(main.lobbyWorld)) {
            if (event.getPlayer().getLocation().getY() <= 0) {
                event.getPlayer().teleport(main.spawnLocation);
            }
        }
    }
}
