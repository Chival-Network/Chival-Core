package au.chival.core.MainFeatures.Lobby.Spawning;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static au.chival.core.Main.*;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            Errors.requiresPlayer(sender);
            return true;
        }

        if (!sender.hasPermission("chival.setspawn")) {
            Errors.noPerm(sender);
            return true;
        }

        Location location = ((Player) sender).getLocation();
        config.set("lobby-loc.x", location.getX());
        config.set("lobby-loc.y", location.getY());
        config.set("lobby-loc.z", location.getZ());
        config.set("lobby-loc.yaw", location.getYaw());
        config.set("lobby-loc.pitch", location.getPitch());
        config.set("lobby-loc.world", location.getWorld());
        plugin.saveConfig();
        spawnLocation = location;
        sender.sendMessage(ChatColor.DARK_AQUA + "Successfully set spawn location to " + ChatColor.DARK_GREEN + (int) location.getX() + ", " + (int) location.getY() + ", " + (int) location.getZ() + ", " + (int) location.getYaw() + ", " + (int) location.getPitch());

        return true;
    }
}
