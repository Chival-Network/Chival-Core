package au.chival.core.MainFeatures.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHungerListener implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if (event.getEntity().getWorld().equals(Bukkit.getWorld("world"))) {
            event.setCancelled(true);
        }
    }
}