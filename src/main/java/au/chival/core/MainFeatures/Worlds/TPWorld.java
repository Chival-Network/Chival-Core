package au.chival.core.MainFeatures.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

public class TPWorld {

    public TPWorld(Player player, String world) {
        if (Bukkit.getWorld(world) == null) {
            player.sendMessage(ChatColor.RED + "That world does not exist!");
            return;
        }
        new WorldCreator(world).createWorld();
        player.teleport(Bukkit.getWorld(world).getSpawnLocation());
    }
}
