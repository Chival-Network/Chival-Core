package au.chival.core.QOL.Vanish;

import au.chival.core.Util.Errors.Errors;
import au.chival.core.MainFeatures.Formatting.Formatting;
import au.chival.core.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

public class Vanish {

    public static List<Player> vanishedPlayers = new LinkedList<>();
    private Player player;

    public Vanish(Player player, Boolean autoVanish) {
        this.player = player;
        if (autoVanish) {
            autoVanishMethod();
        }
    }

    public void autoVanishMethod() {
        if (vanishedPlayers.contains(player)) {
            showhPlayer();
        } else {
            vanishPlayer();
        }
    }

    public void vanishPlayer() {

        if (!player.hasPermission("chival.vanish")) {
            Errors.noPerm(player, null);
            return;
        }

        vanishedPlayers.add(player);
        new Formatting(player.getUniqueId()).addPrefix(ChatColor.GREEN + "[V] ");
        for(Player player1 : Bukkit.getOnlinePlayers()) {
            if (player1.hasPermission("chival.vanish")) {
            } else {
                player1.hidePlayer(player);
            }
        }

        player.sendMessage(Util.Color("&2You Have Vanished"));

    }

    public void showhPlayer () {

        if (!player.hasPermission("chival.vanish")) {
            Errors.noPerm(player, null);
            return;
        }

        vanishedPlayers.remove(player);
        new Formatting(player.getUniqueId()).setDefault();
        for(Player player1 : Bukkit.getOnlinePlayers()) {
            player1.showPlayer(player);
        }
        player.sendMessage(Util.Color("&cYou Have Unvanished"));
    }

    public void update() {
        if (!player.hasPermission("chival.vanish")) {
            vanishedPlayers.forEach(value -> {
                player.hidePlayer(value);
            });
        }
    }
}
