package au.chival.core.commands;

import au.chival.core.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.CREATIVE;

public class gmc implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] args) {
        Player send = (Player) Sender;
        Player target = null;
        if (command.getName().equalsIgnoreCase("gmc")) {
            if (!(Sender instanceof Player)) {
                if (args.length == 1) {
                    target = Bukkit.getServer().getPlayer(args [0]);
                    target.setGameMode(CREATIVE);
                    send.sendMessage(Util.Color("&fPlayer's Gamemode Set to &bCreative"));
                    return true;
                } else if (target == null) {
                    Sender.sendMessage(Util.Color("&cPlayer is offline."));
                    return true;
                }
            } else if (args.length == 0) {
                send.setGameMode(CREATIVE);
                send.sendMessage(Util.Color("&Your Gamemode has been set to &bCreative"));
                return true;
            } else if(args.length > 1) {
                send.sendMessage(Util.Color("&cPlease type /Gmc <Player>"));
                return true;
            }
        }
        return false;
    }
}

