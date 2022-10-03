package au.chival.core.MainFeatures.Worlds;

import au.chival.core.MainFeatures.Formatting.Formatting;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

import static au.chival.core.Main.plugin;

public class CreateWorld {

    String worldName;

    public CreateWorld(String worldName) {
        this.worldName = worldName;
    }

    public void createWorld(Player player) {

        if (!(Bukkit.getWorld(worldName) == null)) {

            player.sendMessage(ChatColor.RED + "That world already exists!");
            return;
        }

        Bukkit.createWorld(new WorldCreator(worldName).type(WorldType.FLAT));
        new WorldCreator(worldName).createWorld();
        player.sendMessage(ChatColor.DARK_AQUA + "Successfully made world " + ChatColor.DARK_GREEN + worldName);

    }

    public void removeWorld(Player player) {

        if (Bukkit.getWorld(worldName) == null) {

            player.sendMessage(ChatColor.RED + "That world doesn't exist!");
            return;
        }

        Bukkit.unloadWorld(Bukkit.getWorld(worldName), false);
        File worldFolder = new File(worldName);
        try {
            FileUtils.deleteDirectory(worldFolder);
        } catch (Exception exception) {}

        player.sendMessage(ChatColor.DARK_AQUA + "Successfully removed world " + ChatColor.DARK_GREEN + worldName);

    }

    public void loadWorld() {
        new WorldCreator(worldName).createWorld();
    }
}
