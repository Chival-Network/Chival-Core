package au.chival.core.MainFeatures.Lobby.Spawning;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static au.chival.core.Main.spawnLocation;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            Errors.invalidObject(sender, "type. You must be a player");
            return true;
        }

        if (!sender.hasPermission("chival.setspawn")) {
            Errors.noPerm(sender, null);
            return true;
        }

        Location location = ((Player) sender).getLocation();
        spawnLocation = location;
        sender.sendMessage(ChatColor.DARK_AQUA + "Successfully set spawn location to " + ChatColor.DARK_GREEN + location.toString());

        return true;
    }
}
