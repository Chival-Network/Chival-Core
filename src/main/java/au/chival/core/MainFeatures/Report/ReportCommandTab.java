package au.chival.core.MainFeatures.Report;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static au.chival.core.MainFeatures.Report.ReportCooldown.canReport;

public class ReportCommandTab implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if (!canReport.get((Player) sender)) {
            sender.sendMessage(ChatColor.RED + "You are one cooldown!");
            return true;
        }

        if (args.length < 2) {
            Errors.noArgs(sender);
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);

        args[0] = "";

        int i = 1;
        String reason = "";

        for (String value : args) {
            if (i == 1) {
                i = 2;
            } else {
                reason = (reason + " " + value);
            }
        }

        new Report((Player) sender, player, reason, false);
        new ReportCooldown().startCooldown((Player) sender);

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
