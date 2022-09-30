package au.chival.core.QOF.Heal;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String c, String[] args){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if(args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args [0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage(ChatColor.GREEN + "You Have Been Healed");
                        sender.sendMessage(ChatColor.GREEN + "That Player Has Been Healed");
                        return true;
                    } else if (target == null) {
                        Errors.invalidObject(player, "player");
                        return true;
                    }
                } else if (args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    return true;
                } else if(args.length > 1){
                    Errors.noArgs(player, null);
                    return true;
                }
            }
        return false;
    }
}

