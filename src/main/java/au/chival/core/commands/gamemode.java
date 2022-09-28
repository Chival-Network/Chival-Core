package au.chival.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player player = (Player) sender;
        Player target = (Player) Bukkit.getServer().getOnlinePlayers();
        if (commandLabel.equalsIgnoreCase("mode")){
            if (sender.hasPermission("gm.creative")){
                if (args.length == 1){
                    if (args[0].equalsIgnoreCase("c")){
                        setCreative(target);
                        target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to creative!");
                    }

                    else if (args[0].equalsIgnoreCase("s")){
                        setSurvival(target);
                        target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to survival!");
                    }

                    else if (args[0].equalsIgnoreCase("a")){
                        setAdventure(target);
                        target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to adventure!");
                    }
                }

                else if (args.length < 1){

                    if (args[0].equalsIgnoreCase("c")){
                        setCreative(player);
                        target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to creative!");
                    }

                    else if (args[0].equalsIgnoreCase("s")){
                        setSurvival(player);
                        target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to survival!");
                    }

                    else if (args[0].equalsIgnoreCase("a")){
                        setAdventure(player);
                        target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to adventure!");
                    }

                }

            }
        }
        return false;
    }

    public void setCreative(Player p){
        p.setGameMode(GameMode.CREATIVE);
    }

    public void setSurvival(Player p){
        p.setGameMode(GameMode.SURVIVAL);
    }

    public void setAdventure(Player p){
        p.setGameMode(GameMode.ADVENTURE);
    }
}