package au.chival.core.Commands;

import au.chival.core.Errors;
import au.chival.core.Util;
import org.bukkit.Bukkit;
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
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(p);
                }
                p.sendMessage(Util.Color("&cYou Have Unvanished"));
                return true;
            }
                //EEEE THIS IS FOR VANISH <3
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(p);
                }
                vanished.add(p);
                p.sendMessage(Util.Color("&aYou Have Vanished"));
            return true;
        }
        Errors.invalidObject(sender, "type");
        return false;
    }
}




