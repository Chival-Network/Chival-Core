package au.chival.core;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Errors {

    public static void general(CommandSender sender, String error) {
        if (error == null || error.equals("")) {
            sender.sendMessage(ChatColor.RESET + "An error soft occurred? Was that a typo? Type " + ChatColor.DARK_GREEN + "/help" + ChatColor.RESET + " for help!");
        } else {
            sender.sendMessage(ChatColor.RESET + error + "? Was that a typo? Type " + ChatColor.DARK_GREEN + "/help" + ChatColor.RESET + " for help!");
        }
    }

    public static void noPerm(CommandSender sender, String other) {

        sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
    }

    public static void noArgs(CommandSender sender, String other) {

        sender.sendMessage(ChatColor.RESET + "Invalid args? Was that a typo? Type " + ChatColor.DARK_GREEN + "/help" + ChatColor.RESET + " for help!");
    }

    public static void invalidObject(CommandSender sender, String wasWasInvalid) {

        sender.sendMessage(ChatColor.RESET + "Invalid " + wasWasInvalid + "? Was that a typo? Type " + ChatColor.DARK_GREEN + "/help" + ChatColor.RESET + " for help!");
    }
}
