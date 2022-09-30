package au.chival.core.MainFeatures.Help;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            commandSender.sendMessage("Currently no help. or as jack whitehall said 'YOURE ON YOUR OWN MATEEE'");
        return true;
    }
}
