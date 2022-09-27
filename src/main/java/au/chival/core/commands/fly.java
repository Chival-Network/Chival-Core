package au.chival.core.commands;

import au.chival.core.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {

    public fly() {


    }


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only Command!");
            return false;

        }
        Player p = (Player) commandSender;
        if (p.hasPermission("chival.fly")) {
            p.sendMessage("&cYou do not have permission to run this command!");
            return false;

        }
        if (!p.getAllowFlight()) {
            p.setAllowFlight(true);
            p.sendMessage(Util.Color("&a Flight Enabled"));


        } else {
            p.setAllowFlight(false);
            p.sendMessage(Util.Color("&cFlight Disabled"));
        }
        return true;
    }


}
