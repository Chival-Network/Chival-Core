package au.chival.coreOLD.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class worldTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Player victim;
        World world;
        if (!(player.hasPermission("kiamic.wtp"))) {
            player.sendMessage(ChatColor.DARK_RED + "Error (1)");
            return true;
        }
        if (args.length == 1 || args.length == 2) {
                if (Bukkit.getWorld(args[0]) != null) {
                    world = Bukkit.getWorld(args[0]);
                } else {
                    player.sendMessage("Invalid Args!");
                    return true;
                }
                if (args.length == 2) {
                    victim = Bukkit.getPlayer(args[1]);
                    if (Bukkit.getOnlinePlayers().contains(victim)) {
                        victim.teleport(world.getSpawnLocation());
                        return true;
                    } else {
                        player.sendMessage(ChatColor.DARK_RED + "Invalid Player!");
                        return true;
                    }
                } else {
                    player.teleport(world.getSpawnLocation());
                    return true;
                }
        }
        return false;
    }
}

