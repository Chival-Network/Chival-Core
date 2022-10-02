package au.chival.core.MainFeatures.Chat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        new ChatFilter().onChat(event);

        String displayName = event.getPlayer().getDisplayName();
        String message = event.getMessage();

        event.setFormat(displayName + ChatColor.RESET + ": " + message);
    }
}
