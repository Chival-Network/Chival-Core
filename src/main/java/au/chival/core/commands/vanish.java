package au.chival.core.commands;

import au.chival.core.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class vanish implements CommandExecutor {

    public static ArrayList<Player> vanished = new ArrayList<Player>();
    public ArrayList<UUID> vanishedplayers = new ArrayList<UUID>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(vanished.contains(p)){
                //NERY THIS IS FOR UNVANISH
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(p);
                                    }
                vanished.remove(p);
                p.sendMessage(Util.Color("&cYou Have Unvanished"));
            } else {
                //EEEE THIS IS FOR VANISH <3
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(p);
                    vanished.add((Player)((Player) sender).getPlayer());
                }
                vanished.add(p);
                p.sendMessage(Util.Color("&aYou Have Vanished"));
            }
            return true;
        }
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (!target.hasPermission("vanish.cansee")) {
                target.hidePlayer(target.getPlayer());
            }
        }
        return false;
    }
}



