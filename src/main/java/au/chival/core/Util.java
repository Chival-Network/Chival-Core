package au.chival.core;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Util {
    public static String Color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
