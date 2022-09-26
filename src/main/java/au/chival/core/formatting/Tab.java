package au.chival.core.formatting;

import me.neznamy.tab.api.HeaderFooterManager;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;

public class Tab {

    public Tab(Player player, String header, String footer) {

        TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
        HeaderFooterManager headerFooterManager = TabAPI.getInstance().getHeaderFooterManager();

        headerFooterManager.setHeaderAndFooter(tabPlayer, header, footer);
    }
}
