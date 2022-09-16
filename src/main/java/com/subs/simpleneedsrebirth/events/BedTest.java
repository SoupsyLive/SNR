package com.subs.simpleneedsrebirth.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedTest implements Listener {
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        //Here is the code that will be run once the event is triggered
        Player player = event.getPlayer();
        player.sendMessage("§fYou left your bed!");
    }
}
