package au.chival.core.MainFeatures.Worlds;

import au.chival.core.Util.Errors.Errors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WorldCommandTab implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String zs, String[] args) {

        if (!(sender instanceof Player)) {
            Errors.requiresPlayer(sender);
            return true;
        }

        if (!(sender.hasPermission("chival.worlds"))) {
            Errors.noPerm(sender);
            return true;
        }

        if (args.length < 1) {

            Errors.noArgs(sender);
            return true;
        }

        if (Objects.equals(args[0], "create") && args.length == 2) {
            sender.sendMessage(ChatColor.DARK_AQUA + "Starting world creation...");
            new CreateWorld(args[1]).createWorld((Player) sender);
        }

        if (Objects.equals(args[0], "remove") && args.length == 2) {
            sender.sendMessage(ChatColor.DARK_AQUA + "Starting world removing...");
            new CreateWorld(args[1]).removeWorld((Player) sender);
        }

        if (Objects.equals(args[0], "tp")) {
            switch (args.length) {
                case 2:
                    new TPWorld((Player) sender, args[1]);
                    break;
                case 3:
                    if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[2]))) {
                        sender.sendMessage(ChatColor.RED + "That player does not exist!");
                        return true;
                    }
                    new TPWorld(Bukkit.getPlayer(args[2]), args[1]);
                    break;
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String zs, String[] args) {

        LinkedList<String> tabComplete = new LinkedList<>();

        if (!(sender.hasPermission("chival.world"))) {
            tabComplete.clear();
            tabComplete.add("");
            return tabComplete;
        }

        if (args.length >= 4) {

            tabComplete.add("");
            return tabComplete;
        }

        if (args.length == 1) {

            tabComplete.add("create");
            tabComplete.add("remove");
            tabComplete.add("tp");
            return tabComplete;
        }

        if (args.length == 2) {

            tabComplete.clear();
            Bukkit.getWorlds().forEach(world -> {
                tabComplete.add(world.getName());
            });
            return tabComplete;
        }

        return null;
    }
}
