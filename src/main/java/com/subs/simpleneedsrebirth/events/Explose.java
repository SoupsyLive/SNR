package com.subs.simpleneedsrebirth.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

public class Explose implements Listener {
    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        if (e.getEntity() instanceof TNTPrimed) {
            e.setCancelled(true);
            for (Entity near : Bukkit.getOnlinePlayers()) {
                if (near.getLocation().distance(e.getEntity().getLocation()) <= 5) {
                    Location nearloc = near.getLocation();
                    Location eLoc = e.getEntity().getLocation();
                    Location newLoc = nearloc.subtract(eLoc);
                    Vector newV = new Vector(newLoc.toVector().normalize().multiply(2).getY(), 2, newLoc.toVector().normalize().multiply(2).getZ());
                }
            }
        }
    }
}