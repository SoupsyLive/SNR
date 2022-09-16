package com.subs.simpleneedsrebirth.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathTest implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.getEntity().sendMessage("§lmfao bad");
    }
}
