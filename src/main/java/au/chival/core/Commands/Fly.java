package au.chival.core.Commands;

import au.chival.core.Util;
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
            return true;

        }
        if (!player.getAllowFlight()) {
            player.setAllowFlight(true);
            player.sendMessage(Util.Color("&aFlight Enabled!"));


        } else {
            player.setAllowFlight(false);
            player.sendMessage(Util.Color("&cFlight Disabled!"));
        }
        return true;
    }
}
