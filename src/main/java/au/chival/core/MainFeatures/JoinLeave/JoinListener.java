package au.chival.core.MainFeatures.JoinLeave;

import au.chival.core.MainFeatures.Formatting.Formatting;
import au.chival.core.QOL.Vanish.Vanish;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.core.Main.plugin;
import static au.chival.core.Main.spawnLocation;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(spawnLocation);
        event.setJoinMessage(null);
        try {
            new BukkitRunnable() {
                @Override
                public void run() {

                    //prefix
                    new Formatting(event.getPlayer().getUniqueId()).setDefault();

                    //tab
                    String[] tab = new String[2];
                    tab[0] = "&bYou Are Playing On &6&lMC.CHIVAL.AU";
                    tab[1] = "&bDo &2/help &bfor help";
                    new Formatting(event.getPlayer().getUniqueId()).Tab(tab);
                }
            }.runTaskAsynchronously(plugin);
        }

        catch (Exception e) {
            event.getPlayer().kickPlayer("An error happened please re-log...");
        }

        new Vanish(event.getPlayer(), false).update();
    }
}
