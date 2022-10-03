package au.chival.core.QOL.Fly;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            Errors.requiresPlayer(sender);
            return true;

        }

        Player player = (Player) sender;

        if (!(player.hasPermission("chival.fly"))) {
            Errors.noPerm(sender);
            return false;

        }

        if (!player.getAllowFlight()) {
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.DARK_GREEN + "Flight Enabled!");


        } else {
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.RED + "Flight Disabled!");
        }

        return false;

    }
}
