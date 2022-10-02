package au.chival.core.MainFeatures.JoinLeave;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.getPlayer().sendMessage(ChatColor.AQUA + "Thanks for playing on " + ChatColor.DARK_GREEN + "MC.Chival.AU");
    }
}
