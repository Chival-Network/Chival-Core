package au.chival.core.Events;

import au.chival.core.Formatting.Formatting;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import net.luckperms.api.event.user.track.UserTrackEvent;
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
            new Formatting(event.getUser().getUniqueId()).update();
        } catch (Exception e) {}
    }
}