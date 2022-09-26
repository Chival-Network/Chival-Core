package au.chival.coreOLD;

import au.chival.coreOLD.formatting.formatting;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.coreOLD.main.plugin;

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
