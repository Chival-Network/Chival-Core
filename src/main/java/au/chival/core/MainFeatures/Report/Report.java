package au.chival.core.MainFeatures.Report;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Report {

    Player player;
    String reason;
    Boolean silent;

    public Report(Player player, String reason, Boolean silent) {
        this.player = player;
        this.reason = reason;
        this.silent = silent;
        addReport();
    }
    public Report(Player player, String reason) {
        this.player = player;
        this.reason = reason;
        this.silent = false;
        addReport();
    }

    public void addReport() {
        //send to database and stuff
        Bukkit.getOnlinePlayers().forEach(value -> {
            if (value.hasPermission("chival.report")) {
                value.sendMessage(ChatColor.DARK_GREEN + player.getDisplayName() + ChatColor.RED + " has been reported for " + ChatColor.DARK_GREEN + reason);
            }
        });

        if (!silent) {
            player.sendMessage(ChatColor.DARK_GREEN + "Your report has been submitted!");
        }
    }
}
