package au.chival.core.Commands;

import au.chival.core.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only Command!");
            return true;

        }
        Player player = (Player) commandSender;
        if (!(player.hasPermission("chival.fly"))) {
            player.sendMessage(Util.Color("&cYou do not have permission to run this command!"));
            return false;

        }
        if (!player.getAllowFlight()) {
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.DARK_GREEN + "Fling enabled!");


        } else {
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.RED + "Flight Disabled!");
        }

        return false;

    }
}
