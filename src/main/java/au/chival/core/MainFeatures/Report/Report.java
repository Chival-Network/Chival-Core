package au.chival.core.MainFeatures.Report;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Report {

    Player target;
    Player player;
    String reason;
    Boolean silent;

    public Report(Player player, Player target, String reason, Boolean silent) {
        this.target = target;
        this.player = player;
        this.reason = reason;
        this.silent = silent;
        addReport();
    }

    public void addReport() {
        //send to database and stuff
        Bukkit.getOnlinePlayers().forEach(value -> {
            if (value.hasPermission("chival.report")) {
                value.sendMessage(ChatColor.DARK_GREEN + target.getDisplayName() + ChatColor.RED + " has been reported for" + ChatColor.DARK_GREEN + reason);
            }
        });

        if (!silent) {
            player.sendMessage(ChatColor.DARK_GREEN + "Your report has been submitted!");
        }
    }
}
