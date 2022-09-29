package au.chival.core.Formatting;

import me.neznamy.tab.api.HeaderFooterManager;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class Formatting {

    private String prefix;
    private LuckPerms luckPerms;
    private User luckPermUser;
    private TabAPI tabAPI;
    private TabPlayer tabPlayer;
    private UUID uuid;

    public Formatting(UUID uuid) {

        this.uuid = uuid;
        this.luckPerms = LuckPermsProvider.get();
        this.luckPermUser = luckPerms.getUserManager().getUser(uuid);
        if (luckPermUser == null) {
            Bukkit.getPlayer(uuid).sendMessage(ChatColor.RED + "Profile could not be loaded...");
            Bukkit.getPlayer(uuid).kickPlayer(ChatColor.RED + "Profile could not be loaded...");
            return;
        }
        this.prefix = luckPermUser.getCachedData().getMetaData().getPrefix();
        this.tabAPI = TabAPI.getInstance();
        this.tabPlayer = tabAPI.getPlayer(uuid);
        if (prefix == null) {
            prefix = (ChatColor.GRAY + "");
        }
    }

    public void setDefault() {
        tabAPI.getTeamManager().setPrefix(tabPlayer, prefix);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, prefix);
        Bukkit.getPlayer(uuid).setDisplayName(prefix + Bukkit.getPlayer(uuid).getName());
    }

    public void update() {
        String prefixes = luckPermUser.getCachedData().getMetaData().getPrefix();
        tabAPI.getTeamManager().setPrefix(tabPlayer, prefixes);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, prefixes);
        Bukkit.getPlayer(uuid).setDisplayName(prefixes);
    }

    public void addPrefix(String newPrefix) {

        tabAPI.getTeamManager().setPrefix(tabPlayer, newPrefix + prefix);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, newPrefix + prefix);
        Bukkit.getPlayer(uuid).setDisplayName(newPrefix + prefix);
    }

    public void Tab(String[] headerFooter) {

        HeaderFooterManager headerFooterManager = TabAPI.getInstance().getHeaderFooterManager();

        headerFooterManager.setHeaderAndFooter(tabPlayer, headerFooter[0], headerFooter[1]);
    }
}
