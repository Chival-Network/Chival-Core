package au.chival.coreOLD.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("chival.ranks")) {
                    player.sendMessage(ChatColor.MAGIC + "jfabnskdfgbazdfhazdet");
                }
            }
        return true;
    }
}
