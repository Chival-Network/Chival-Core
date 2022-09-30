package au.chival.core.QOL.Speed;

import au.chival.core.Util.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
            return true;
        }
        Player player = (Player) commandSender;
        if (!(player.hasPermission("chival.speed"))) {
            commandSender.sendMessage(Util.Color("&cYou do not have permission to run this command!"));
            return true;
        }
        if(strings.length == 0) {
            player.sendMessage(Util.Color("&cPlease Provide a Speed 1 - 10"));
            return true;
        }
        int speed;
        try {
            speed = Integer.parseInt(strings[0]);
        } catch (NumberFormatException e) {
            player.sendMessage(Util.Color("&cPlease Provide A Speed 1 - 10"));
            return true;
        }
        if (speed < 1 || speed > 10) {
            player.sendMessage(Util.Color("&cPlease Provide A Speed 1 - 10"));
            return true;
        }
        if (player.isFlying()) {
            player.setFlySpeed((float)speed / 10);
           //For Nery <3
            //10 -> 1
            //2 -> 0.2
            // Minecraft Deals With it in decimals EEEEEEEEEEEE
            //GJ
        } else {
            player.setWalkSpeed((float) speed / 10);
        }
        player.sendMessage(Util.Color("&aSpeed set to " + ChatColor.DARK_GREEN + speed ));
        return true;
    }
}
