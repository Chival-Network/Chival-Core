package au.chival.core.MainFeatures.Formatting;

import au.chival.core.QOL.Vanish.Vanish;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.UserCacheLoadEvent;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import net.luckperms.api.event.user.UserLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class LuckPermListeners {

    public LuckPermListeners(Plugin plugin, LuckPerms luckPerms) {

        try {

            EventBus eventBus = luckPerms.getEventBus();

            eventBus.subscribe(plugin, UserDataRecalculateEvent.class, this::onUserDataRecalculateEvent);
            eventBus.subscribe(plugin, UserLoadEvent.class, this::onUserLoadEvent);
        } catch (Exception e) {}
    }

    private void onUserDataRecalculateEvent(UserDataRecalculateEvent event) {
        try {
            new Vanish(Bukkit.getPlayer(event.getUser().getUniqueId()), false).update();
            new Formatting(event.getUser().getUniqueId()).setDefault();
        } catch (Exception e) {}
    }

    private void onUserLoadEvent(UserLoadEvent event) {
        try {
            new Vanish(Bukkit.getPlayer(event.getUser().getUniqueId()), false).update();
            new Formatting(event.getUser().getUniqueId()).setDefault();
        } catch (Exception e) {}
    }
}