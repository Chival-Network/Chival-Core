package au.chival.core.MainFeatures.Chat;

import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFilter {

    public void onChat(AsyncPlayerChatEvent event) {
        String message1 = event.getMessage();

        event.setMessage(event.getMessage().replaceAll("fuck", "****"));
        event.setMessage(event.getMessage().replaceAll("kys", "****"));
        event.setMessage(event.getMessage().replaceAll("nigger", "****"));
        event.setMessage(event.getMessage().replaceAll("nigga", "****"));

        String message2 = event.getMessage();

        if (message1 != message2) {
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot say that!");

        }
    }
}
