package au.chival.core.MainFeatures.Chat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        String playerName = event.getPlayer().getDisplayName();
        String message = event.getMessage();
        event.setFormat(playerName + ChatColor.RESET + ": " + message);
    }
}
