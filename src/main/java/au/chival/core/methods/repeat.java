package au.chival.core.methods;

import au.chival.core.formatting.formatting;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.core.main.luckPermsApi;
import static au.chival.core.main.plugin;

public class repeat {
    public void repeatFormatting(int delay, int amount) {
        new BukkitRunnable() {
            @Override
            public void run() {
                int i = 1;
                while (i <= amount) {
                    int finalI = i;
                    Bukkit.getOnlinePlayers().forEach(value -> {
                        new formatting(value, true);
                    });
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    i++;
                }
            }
        }.runTaskAsynchronously(plugin);
    }
}
