package au.chival.core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String c, String[] args){
        Player send = (Player) sender;
        Player target = null;
        if(command.getName().equalsIgnoreCase("heal")){
            if (sender instanceof Player){
                if(args.length == 1) {
                    target = Bukkit.getServer().getPlayer(args [0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.sendMessage(ChatColor.GREEN + "You Have Been Healed");
                        sender.sendMessage(ChatColor.GREEN + "That Player Has Been Healed");
                        return true;
                    } else if (target == null) {
                        sender.sendMessage(ChatColor.RED + "Player is offline.");
                        return true;
                    }
                } else if (args.length == 0) {
                    send.setHealth(20);
                    return true;
                } else if(args.length > 1){
                    sender.sendMessage(ChatColor.RED + "Too many args!");
                    return true;
                }
            }
        }
        return false;
    }
}

