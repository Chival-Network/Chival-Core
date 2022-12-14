package au.chival.core.MainFeatures.Formatting;

import me.neznamy.tab.api.HeaderFooterManager;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.UUID;

public class Formatting {

    private String defaultPrefix;
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
        assert luckPermUser != null;
        this.defaultPrefix = luckPermUser.getCachedData().getMetaData().getPrefix();
        this.tabAPI = TabAPI.getInstance();
        this.tabPlayer = tabAPI.getPlayer(uuid);
        this.prefix = tabAPI.getTablistFormatManager().getCustomPrefix(tabPlayer);
        if (defaultPrefix == null) {
            defaultPrefix = (ChatColor.GRAY + "");
        }
    }

    public void setDefault() {
        tabAPI.getTeamManager().setPrefix(tabPlayer, defaultPrefix);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, defaultPrefix);
        Bukkit.getPlayer(uuid).setDisplayName(defaultPrefix + Bukkit.getPlayer(uuid).getName());
    }

    public void update() {
        tabAPI.getTeamManager().setPrefix(tabPlayer, prefix);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, prefix);
        Bukkit.getPlayer(uuid).setDisplayName(prefix);
    }

    public void addPrefix(String newPrefix) {

        tabAPI.getTeamManager().setPrefix(tabPlayer, newPrefix + prefix);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, newPrefix + prefix);
        Bukkit.getPlayer(uuid).setDisplayName(newPrefix + prefix + Bukkit.getPlayer(uuid).getName());
    }

    public void Tab(String[] headerFooter) {

        HeaderFooterManager headerFooterManager = TabAPI.getInstance().getHeaderFooterManager();

        headerFooterManager.setHeaderAndFooter(tabPlayer, headerFooter[0], headerFooter[1]);
    }
}
