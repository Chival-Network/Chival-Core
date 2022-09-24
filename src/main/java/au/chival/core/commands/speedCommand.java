package au.chival.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class speedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (((Player) sender).isFlying()) {
                try {
                    ((Player) sender).setFlySpeed(Float.parseFloat(args[0]));
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.DARK_RED + "An error occurred!");
                }
            }
        }
        return true;
    }
}
