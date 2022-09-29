package au.chival.core.Commands;

import au.chival.core.Errors;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static au.chival.core.Main.config;

public class Lobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if (!(sender instanceof Player)) {
            Errors.invalidObject(sender, "type! You must be a player");
            return true;
        }

        sender.setOp(true);
        ((Player) sender).chat("/server " + config.get("lobby-server"));
        sender.setOp(false);
        sender.sendMessage("Sending you to " + ChatColor.DARK_GREEN + config.get("lobby-server"));
        return true;
    }
}
