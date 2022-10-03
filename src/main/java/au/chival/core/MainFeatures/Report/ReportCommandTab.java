package au.chival.core.MainFeatures.Report;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReportCommandTab implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if (args.length < 2) {
            Errors.noArgs(sender);
            return true;
        }

        if (Bukkit.getOnlinePlayers().stream().toList().contains(args[0])) {
            sender.sendMessage(ChatColor.RED + "That player is invalid! (TO DO FOR DEV: ADD OFFLINE PLAYER REPORTING)");
            return true;
        }


        Player player = Bukkit.getPlayer(args[0]);

        args[0] = "";

        String reason = Arrays.toString(args).trim();

        player.sendMessage(args);

        new Report(player, reason, false);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if (args.length >= 2) {
            LinkedList<String> nothing = new LinkedList<>();
            nothing.add("");
            return nothing;
        }

        return null;
    }
}
