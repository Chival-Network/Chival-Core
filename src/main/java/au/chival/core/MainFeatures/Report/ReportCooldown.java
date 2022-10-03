package au.chival.core.MainFeatures.Report;

import au.chival.core.MainFeatures.Formatting.Formatting;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import static au.chival.core.Main.plugin;

public class ReportCooldown {

    public static HashMap<Player, Boolean> canReport = new HashMap<>();

    public void startCooldown(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {

                canReport.put(player, false);

                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                canReport.put(player, true);

            }
        }.runTaskAsynchronously(plugin);
    }
}
