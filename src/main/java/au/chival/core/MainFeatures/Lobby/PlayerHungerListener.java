package au.chival.core.MainFeatures.Lobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import static au.chival.core.Main.spawnLocation;

public class PlayerHungerListener implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if (event.getEntity().getWorld() == spawnLocation.getWorld()) {
            event.setCancelled(true);
        }
    }
}