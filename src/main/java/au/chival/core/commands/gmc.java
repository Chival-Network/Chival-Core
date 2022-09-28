package au.chival.core.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.CREATIVE;

public class gmc implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("gmc")){
            if(!(commandSender instanceof Player)){
                commandSender.sendMessage("You cannot run this command as the console unit.");
                return true;
            }else{
                Player player = (Player) commandSender;
                if(player.getGameMode() == CREATIVE){
                    player.sendMessage("You are already that Gamemode");
                    return true;
                }else{
                    player.setGameMode(GameMode.CREATIVE);
                    return true;
                }
            }
        }

        return false;
    }
}
