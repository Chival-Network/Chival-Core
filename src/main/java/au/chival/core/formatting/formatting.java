package au.chival.core.formatting;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.core.main.luckPermsApi;
import static au.chival.core.main.plugin;

public class formatting {
    public formatting(Player player, boolean useaync) {

        if (useaync) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    while (player == null) {player.sendMessage(ChatColor.DARK_RED + "Loading profile...");}
                    User user = luckPermsApi.getUserManager().getUser(player.getUniqueId());
                    TabAPI tabAPI = TabAPI.getInstance();
                    TabPlayer tabPlayer = tabAPI.getPlayer(player.getUniqueId());
                    while (tabPlayer == null || user == null) {}
                    if (user.getCachedData().getMetaData().getPrefix() == null) {
                        return;
                    }
                    player.setDisplayName(user.getCachedData().getMetaData().getPrefix() + player.getName());
                    player.setPlayerListName(user.getCachedData().getMetaData().getPrefix() + player.getName());
                    tabAPI.getTablistFormatManager().setPrefix(tabPlayer, user.getCachedData().getMetaData().getPrefix());
                    tabAPI.getTeamManager().setPrefix(tabPlayer, user.getCachedData().getMetaData().getPrefix());
                }
            }.runTaskAsynchronously(plugin);
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    while (player == null) {player.sendMessage(ChatColor.DARK_RED + "Loading profile...");}
                    User user = luckPermsApi.getUserManager().getUser(player.getUniqueId());
                    TabAPI tabAPI = TabAPI.getInstance();
                    TabPlayer tabPlayer = tabAPI.getPlayer(player.getUniqueId());
                    while (tabPlayer == null || user == null) {}
                    if (user.getCachedData().getMetaData().getPrefix() == null) {
                        return;
                    }
                    player.setDisplayName(user.getCachedData().getMetaData().getPrefix() + player.getName());
                    player.setPlayerListName(user.getCachedData().getMetaData().getPrefix() + player.getName());
                    tabAPI.getTablistFormatManager().setPrefix(tabPlayer, user.getCachedData().getMetaData().getPrefix());
                    tabAPI.getTeamManager().setPrefix(tabPlayer, user.getCachedData().getMetaData().getPrefix());
                }
            }.runTask(plugin);
        }
    }
}
