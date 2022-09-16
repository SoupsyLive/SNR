package com.subs.simpleneedsrebirth.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class SheerTest implements Listener {
    @EventHandler
    public void onSheerSheep(PlayerShearEntityEvent event) {
        event.setCancelled(true);
        event.getPlayer().sendMessage("§aDont Strip them pervert!");
    }
}
