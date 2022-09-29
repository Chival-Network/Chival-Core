package au.chival.core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            commandSender.sendMessage("Currently no help. or as jack whitehall said 'YOURE ON YOUR OWN MATEEE'");
        return true;
    }
}
