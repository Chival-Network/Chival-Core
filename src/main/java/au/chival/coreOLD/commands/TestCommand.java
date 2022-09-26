package au.chival.coreOLD.commands;

import au.chival.coreOLD.formatting.Tab;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        new Tab((Player) commandSender, "test header", "test footer");
        return true;
    }
}
