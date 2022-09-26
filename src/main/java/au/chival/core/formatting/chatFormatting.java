package au.chival.core.formatting;

import au.chival.core.methods.repeat;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class chatFormatting implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(event.getPlayer().getDisplayName() + ": " + ChatColor.RESET + event.getMessage());
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        new repeat().repeatFormatting(1000, 5);
    }
}
