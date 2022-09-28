package au.chival.core.Commands;

import au.chival.core.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class Flying extends JavaPlugin {

    public final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " V " + pdfFile.getVersion() + " is now enabled.");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " V " + pdfFile.getVersion() + " is now disabled.");
    }

    public boolean onCommand(CommandSender sender, Command command, String c, String[] args) {
        Player send = (Player) sender;
        Player target = null;
        if (command.getName().equalsIgnoreCase("Fly")) {
            if (sender instanceof Player) {
                if (args.length == 1) {
                    target = Bukkit.getServer().getPlayer(args[0]);
                    if (target != null) {
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.sendMessage(Util.Color("&aPlayer is now Flying!"));
                            return true;
                        } else if (target == null) {
                            sender.sendMessage(Util.Color("&cPlayer is Offine :("));
                            return true;
                        }
                    } else if (args.length == 0) {
                        if (!send.getAllowFlight()) {
                            send.setAllowFlight(true);
                            send.sendMessage(Util.Color("&aYou are now Flying!"));
                            return true;
                        } else if (args.length > 1) {
                            sender.sendMessage(Util.Color("&cWrong Format! Do /fly <Player>"));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}