package au.chival.core.QOF.Fly;

import au.chival.core.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FlysCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String c, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target != null) {
                    if (!target.getAllowFlight()) {
                        target.setAllowFlight(true);
                        target.sendMessage(Util.Color("&aPlayer is now Flying!"));
                        return true;
                    } else if (target == null) {
                        sender.sendMessage(Util.Color("&cPlayer is Offline"));
                        return true;
                    }
                } else if (args.length == 0) {
                    if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.sendMessage(Util.Color("&aYou are now Flying!"));
                        return true;
                       } else if (args.length > 1) {
                        sender.sendMessage(Util.Color("&cWrong Args! Do /fly <Player>"));
                        return true;
                        }
                    }
                }
            }
        return false;
    }
}