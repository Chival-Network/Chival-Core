package au.chival.core.Vanish;

import au.chival.core.Errors;
import au.chival.core.Formatting.Formatting;
import au.chival.core.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Vanish {

    public static LinkedHashMap<Player, Boolean> vanished = new LinkedHashMap<>();
    private String prefix;

    public Vanish(Player player) {
        this.prefix = ChatColor.DARK_GREEN + "[V] ";
        vanished.putIfAbsent(player, false);
        if (!vanished.get(player)) {
            vanishPlayer(player);
        } else {
            showhPlayer(player);
        }
    }

    public void vanishPlayer(Player player) {

        if (!player.hasPermission("chival.vanish")) {
            Errors.noPerm(player, null);
            return;
        }

        vanished.put(player, true);
        new Formatting(player.getUniqueId()).addPrefix(prefix);
        for(Player player1 : Bukkit.getOnlinePlayers()) {
            if (vanished.containsKey(player)) {
            } else {
                player1.hidePlayer(player);
            }
        }

        player.sendMessage(Util.Color("&2You Have Vanished"));

    }

    public void showhPlayer (Player player) {

        vanished.put(player, false);
        new Formatting(player.getUniqueId()).setDefault();
        for(Player player1 : Bukkit.getOnlinePlayers()) {
            player1.showPlayer(player);
        }
        player.sendMessage(Util.Color("&cYou Have Unvanished"));
    }
}
