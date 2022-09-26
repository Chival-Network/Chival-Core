package au.chival.coreOLD.formatting;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.coreOLD.main.luckPermsApi;
import static au.chival.coreOLD.main.plugin;

public class formatting {
    public formatting(Player player, boolean useaync) {

        if (useaync) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    while (player == null) {}
                    bindFormatting(player);
                }
            }.runTaskAsynchronously(plugin);
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    bindFormatting(player);
                }
            }.runTask(plugin);
        }
    }
    public void bindFormatting(Player player) {
        while (player == null) {player.sendMessage(ChatColor.DARK_RED + "Loading profile...");}
        User user = luckPermsApi.getUserManager().getUser(player.getUniqueId());
        TabAPI tabAPI = TabAPI.getInstance();
        TabPlayer tabPlayer = tabAPI.getPlayer(player.getUniqueId());
        while (tabPlayer == null || user == null) {}
        if (user.getCachedData().getMetaData().getPrefix() == null) {
            player.setDisplayName(player.getName());
            player.setPlayerListName(player.getName());
            tabAPI.getTablistFormatManager().setPrefix(tabPlayer, "");
            tabAPI.getTeamManager().setPrefix(tabPlayer, "");
            return;
        }
        player.setDisplayName(user.getCachedData().getMetaData().getPrefix() + player.getName());
        player.setPlayerListName(user.getCachedData().getMetaData().getPrefix() + player.getName());
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, user.getCachedData().getMetaData().getPrefix());
        tabAPI.getTeamManager().setPrefix(tabPlayer, user.getCachedData().getMetaData().getPrefix());

        new Tab(
                player,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Welcome to " + ChatColor.GOLD + "Chival.AU",
                 ChatColor.AQUA + "Do " + ChatColor.DARK_GREEN + "/help" + ChatColor.AQUA + " for help!");

    }
}
