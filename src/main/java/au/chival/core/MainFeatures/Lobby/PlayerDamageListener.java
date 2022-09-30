package au.chival.core.MainFeatures.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {

        if (event.getPlayer().getWorld().equals(Bukkit.getWorld("world"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockDamage(EntityDamageEvent event) {

        if (event.getEntity().getWorld().equals(Bukkit.getWorld("world"))) {
            event.setCancelled(true);
        }
    }
}
