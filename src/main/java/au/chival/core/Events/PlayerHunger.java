package au.chival.core.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHunger implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if (event.getEntity().getWorld().equals(Bukkit.getWorld("world"))) {
            event.setCancelled(true);
        }
    }
}