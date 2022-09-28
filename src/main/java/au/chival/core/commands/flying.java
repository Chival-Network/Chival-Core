package au.chival.core.commands;

import au.chival.core.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.logging.Logger;

public class flying implements CommandExecutor {
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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String c, String[] args) {
        Player send = (Player) sender;
        Player target = null;
        if(command.getName().equalsIgnoreCase("fly")){
            if (sender instanceof Player){
                if(args.length == 1) {
                    target = Bukkit.getServer().getPlayer(args [0]);
                    if (target != null) {
                            Player.setAllowFlight(true);
                            Player.sendMessage(Util.Color("&aFlight Enabled!"));

                        }
                }
            }
        }
        return false;
    }
}
