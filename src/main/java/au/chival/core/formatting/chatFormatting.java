package au.chival.core.formatting;

import au.chival.core.methods.repeat;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.core.main.luckPermsApi;
import static au.chival.core.main.plugin;

public class chatFormatting implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(event.getPlayer().getDisplayName() + ": " + event.getMessage());
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        new repeat().repeatFormatting(1000, 5);
    }
}
