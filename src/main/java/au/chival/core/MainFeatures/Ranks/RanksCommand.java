package au.chival.core.MainFeatures.Ranks;

import au.chival.core.Util.Errors.Errors;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.data.DataMutateResult;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.InheritanceNode;
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

        if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
            commandSender.sendMessage(ChatColor.RED + "That player is not online!");
            return true;
        }

        if (LuckPermsProvider.get().getGroupManager().getGroup(args[1]) == null) {
            commandSender.sendMessage(ChatColor.RED + "Unknown rank?");
            return true;
        }

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(Bukkit.getPlayer(args[0]));

        String oldGroup = user.getPrimaryGroup();
        String group = args[1];
        InheritanceNode oldNode = InheritanceNode.builder(oldGroup).value(true).build();
        InheritanceNode node = InheritanceNode.builder(group).value(true).build();
        user.data().remove(oldNode);
        DataMutateResult result = user.data().add(node);

        commandSender.sendMessage(ChatColor.DARK_GREEN + result.toString());

        String prefix = user.getCachedData().getMetaData().getPrefix();

        if (prefix == null) {
            prefix = ChatColor.GRAY + "[Default]";
        }

        commandSender.sendMessage(ChatColor.DARK_AQUA + "Changed " + ChatColor.DARK_GREEN + user.getUsername() + ChatColor.DARK_AQUA + "'s rank to " + ChatColor.RESET + prefix);

        return true;
    }
}
