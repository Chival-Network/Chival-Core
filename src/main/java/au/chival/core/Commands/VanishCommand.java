package au.chival.core.Commands;

import au.chival.core.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {


    public ArrayList<Player> vanished = new ArrayList<>();

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
                    vanished.add(((Player) sender).getPlayer());
                }
                vanished.add(p);
                p.sendMessage(Util.Color("&aYou Have Vanished"));
            }
            return true;
        }
        return false;
    }
}




