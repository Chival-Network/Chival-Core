package au.chival.core.MainFeatures.Help;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static au.chival.core.Main.plugin;

public class Help {

    Player player;

    public Help(Player player, String command) {

        if (command == null || command == "") {
            player.sendMessage(ChatColor.DARK_AQUA + " ");
            player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Welcome to " + ChatColor.DARK_GREEN + "MC.Chival.AU");
            player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Discord: " + ChatColor.DARK_GREEN + "https://discord.gg/E3XFXx22Sj");
            player.sendMessage(ChatColor.DARK_AQUA + " ");
        }
    }
}
