package au.chival.coreOLD.commands;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class worldCreate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length == 1) {
                Bukkit.createWorld(new WorldCreator(args[0]));
            } else if (args.length == 2) {
                if (Objects.equals(args[1], "new")) {
                    Bukkit.createWorld(new WorldCreator(args[0]).type(WorldType.FLAT));
                } else {
                    sender.sendMessage("Invalid Args!");
                }
            } else {
                sender.sendMessage("Invalid Args!");
            }
        return true;
    }
}

