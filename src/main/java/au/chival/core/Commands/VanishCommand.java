package au.chival.core.Commands;

import au.chival.core.Errors;
import au.chival.core.Formatting.Formatting;
import au.chival.core.Util;
import au.chival.core.Vanish.Vanish;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedList;

public class VanishCommand implements CommandExecutor {


    public static LinkedList<Player> vanished = new LinkedList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new Vanish(player);
        }
        return true;
    }
}




