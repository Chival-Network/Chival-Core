package au.chival.core.MainFeatures.Ranks;

import au.chival.core.Util.Errors.Errors;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RanksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender.hasPermission("chival.ranks"))) {
            Errors.noPerm(commandSender);
            return true;
        }

        if (args.length != 2) {
            Errors.noArgs(commandSender);
            return true;
        }

        if (!Bukkit.getOnlinePlayers().contains(args[0])) {
            Errors.requiresPlayer(commandSender);
            return true;
        }

        if (LuckPermsProvider.get().getGroupManager().getGroup(args[1]) == null) {
            Errors.requiresPlayer(commandSender);
            return true;
        }

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(Bukkit.getPlayer(args[0]));
        Group group = LuckPermsProvider.get().getGroupManager().getGroup(args[1]);

        user.setPrimaryGroup(String.valueOf(group));

        commandSender.sendMessage(ChatColor.DARK_AQUA + "Changed " + ChatColor.DARK_GREEN + user.getUsername() + ChatColor.DARK_AQUA + "'s rank to " + ChatColor.RESET + group.getCachedData().getMetaData().getPrefix());

        return true;
    }
}
