package au.chival.core.Commands;

import au.chival.core.Errors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.spigotmc.SpigotConfig.config;

public class Lobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if (!(sender instanceof Player)) {
            Errors.invalidObject(sender, "type! You must be a player");
            return true;
        }

        ((Player) sender).chat("/server " + config.getString("lobby-server"));
        return true;
    }
}
