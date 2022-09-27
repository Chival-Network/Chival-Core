package au.chival.core.Events;

import au.chival.core.Formatting.Formatting;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.track.UserTrackEvent;
import org.bukkit.plugin.Plugin;

public class UpdateUser {

    public UpdateUser(Plugin plugin, LuckPerms luckPerms) {

        EventBus eventBus = luckPerms.getEventBus();

        eventBus.subscribe(plugin, UserTrackEvent.class, this::onUserTrackEvent);
    }

    private void onUserTrackEvent(UserTrackEvent event) {
        new Formatting(event.getUser().getUniqueId(), false, null, null);
    }
}