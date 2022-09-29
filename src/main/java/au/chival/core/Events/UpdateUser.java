package au.chival.core.Events;

import au.chival.core.Formatting.Formatting;
import au.chival.core.Vanish.Vanish;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class UpdateUser {

    public UpdateUser(Plugin plugin, LuckPerms luckPerms) {

        try {

            EventBus eventBus = luckPerms.getEventBus();

            eventBus.subscribe(plugin, UserDataRecalculateEvent.class, this::onUserDataRecalculateEvent);
        } catch (Exception e) {}
    }

    private void onUserDataRecalculateEvent(UserDataRecalculateEvent event) {
        try {
            new Vanish(Bukkit.getPlayer(event.getUser().getUniqueId()), false).update();
            new Formatting(event.getUser().getUniqueId()).setDefault();
        } catch (Exception e) {}
    }
}