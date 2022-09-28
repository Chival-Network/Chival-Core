package au.chival.core.Formatting;

import me.neznamy.tab.api.HeaderFooterManager;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class Formatting {

    public Formatting(UUID uuid, boolean formatTab, String header, String footer) {

        while (Bukkit.getPlayer(uuid) == null) {}

        Player player = Bukkit.getPlayer(uuid);

        LuckPerms luckPerms = LuckPermsProvider.get();
        User luckPermUser = luckPerms.getUserManager().getUser(player.getUniqueId());
        String prefix = luckPermUser.getCachedData().getMetaData().getPrefix();

        TabAPI tabAPI = TabAPI.getInstance();
        TabPlayer tabPlayer = tabAPI.getPlayer(player.getUniqueId());

        tabAPI.getTeamManager().setPrefix(tabPlayer, prefix);
        tabAPI.getTablistFormatManager().setPrefix(tabPlayer, prefix);
        player.setDisplayName(prefix + player.getName());

        if (formatTab) {
            formattingTab(tabPlayer, header, footer);
        }

    }

    public void formattingTab(TabPlayer tabPlayer, String header, String footer) {

        HeaderFooterManager headerFooterManager = TabAPI.getInstance().getHeaderFooterManager();

        headerFooterManager.setHeaderAndFooter(tabPlayer, header, footer);
    }
}
