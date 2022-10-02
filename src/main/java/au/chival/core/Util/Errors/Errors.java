package au.chival.core.Util.Errors;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Errors {

    public static void noPerm(CommandSender sender) {

        sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
    }

    public static void noArgs(CommandSender sender) {

        sender.sendMessage(ChatColor.RED + "Invalid args? Was that a typo? Type " + ChatColor.DARK_GREEN + "/help" + ChatColor.RED + " for help!");
    }

    public static void requiresPlayer(CommandSender sender) {

        sender.sendMessage(ChatColor.RED + "Only players can run that command? Was that a typo? Type " + ChatColor.DARK_GREEN + "/help" + ChatColor.RED + " for help!");
    }
}
