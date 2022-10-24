package au.chival.core.MainFeatures.Lobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static au.chival.core.Main.spawnLocation;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {

        if (event.getPlayer().getWorld() == spawnLocation.getWorld()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockDamage(EntityDamageEvent event) {

        if (event.getEntity().getWorld() == spawnLocation.getWorld()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void boxingTEMP(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100000, 255, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 255, true));
    }
}
