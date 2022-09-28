package au.chival.core.Commands;

import au.chival.core.Errors;
import au.chival.core.Formatting.Formatting;
import au.chival.core.Util;
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
            Player p = (Player) sender;
            if(vanished.contains(p)){
                //NERY THIS IS FOR UNVANISH
                vanished.remove(p);
                new Formatting(p.getUniqueId(), false, null, null, null);
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(p);
                }
                p.sendMessage(Util.Color("&cYou Have Unvanished"));
                return true;
            }
                //EEEE THIS IS FOR VANISH <3
                vanished.add(p);
                new Formatting(p.getUniqueId(), false, null, null, ChatColor.DARK_GREEN + "[V] " + ChatColor.RESET);
                for(Player player : Bukkit.getOnlinePlayers()) {

                    if (vanished.contains(p)) {
                    } else {
                        player.hidePlayer(p);
                    }
                }
                p.sendMessage(Util.Color("&aYou Have Vanished"));
            return true;
        }
        Errors.invalidObject(sender, "type");
        return false;
    }
}




