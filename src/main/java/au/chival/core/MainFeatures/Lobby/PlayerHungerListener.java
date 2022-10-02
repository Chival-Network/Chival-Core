package au.chival.core.MainFeatures.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import static org.spigotmc.SpigotConfig.config;

public class PlayerHungerListener implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if (event.getEntity().getWorld().equals(Bukkit.getWorld(config.getString("lobby-loc.world")))) {
            if (Bukkit.getWorld(config.getString("lobby-loc.world")) == null) {
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }
}