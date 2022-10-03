package au.chival.core.QOL.Ride;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RideListener implements Listener {

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent event) {
        if (event.getPlayer().getItemInHand().getType() == Material.LEASH) {
            event.getRightClicked().setPassenger(event.getPlayer());
        }
    }
}