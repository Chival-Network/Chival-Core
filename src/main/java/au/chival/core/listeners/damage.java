package au.chival.core.listeners;

import au.chival.core.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class damage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity().getWorld().equals(main.lobbyWorld)) {
            event.setCancelled(true);
        }
    }
}
