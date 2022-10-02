package au.chival.core.QOL.Sudo;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SudoCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            if (!sender.hasPermission("chival.sudo")) {
                Errors.noPerm(sender);
                return true;
            }
            if (args.length < 2) {
                sender.sendMessage(ChatColor.RED +
                        "Usage: /sudo <player> <message>");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + args[0] +
                        " is Offline!");
                return true;
            }
            StringBuilder msg = new StringBuilder(args[1]);
            for (int arg = 2; arg < args.length; arg++) {
                msg.append(" ").append(args[arg]);
            }
            String m = msg.toString();
            sender.sendMessage(ChatColor.DARK_GREEN + "Forcing " + target.getName() +
                    " to say: " + msg);
            target.setOp(true);
            target.chat(m);
            target.setOp(false);
        return true;
    }
}