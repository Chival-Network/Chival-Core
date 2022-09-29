package au.chival.core.Commands;

import au.chival.core.Vanish.Vanish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new Vanish(player, true);
            new Vanish(player, false).update();
        }
        return true;
    }
}




