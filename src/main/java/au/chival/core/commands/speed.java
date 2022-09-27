package au.chival.core.commands;

import au.chival.core.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class speed implements CommandExecutor {

    public speed() {


    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
            return false;


        }
        Player p = (Player) commandSender;
        if (p.hasPermission("chival.speed")) {
            commandSender.sendMessage(Util.Color("&cYou do not have permission to run this command!"));
            return false;
        }
        if(strings.length == 0) {
            p.sendMessage(Util.Color("&cPlease Provide a Speed 1 - 10"));
            return false;

        }
        int speed;
        try {
            speed = Integer.parseInt(strings[0]);

        } catch (NumberFormatException e) {
            p.sendMessage(Util.Color("&cPlease Provide A Speed 1 - 10"));
            return false;



        }
        if (speed < 1 || speed > 10) {
            p.sendMessage(Util.Color("&cPlease Provide A Speed 1 - 10"));
            return false;


        }
        if (p.isFlying()) {
            p.setFlySpeed((float)speed / 10);
           //For Nery <3
            //10 -> 1
            //2 -> 0.2
            // Minecraft Deals With it in decimals EEEEEEEEEEEE

        } else {
            p.setWalkSpeed((float) speed / 10);


        }
        p.sendMessage(Util.Color("&aSpeed set to" + speed ));


        return true;

    }
}
