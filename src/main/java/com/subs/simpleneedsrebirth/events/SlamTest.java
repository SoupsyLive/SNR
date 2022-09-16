package com.subs.simpleneedsrebirth.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class SlamTest implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR && player.getInventory().getItemInMainHand().getType().equals(Material.SUGAR)) {
            for (Entity players : player.getNearbyEntities(10, 10, 10)){
                if (players instanceof Player){
                    Vector vector = player.getLocation().getDirection();
                    vector = vector.multiply(2);
                    players.setVelocity(vector);
                    players.setGravity(true);
                }
            }
            for (Entity players : player.getNearbyEntities(5, 5, 5)){
                if (players instanceof Player){
                    Vector vector = player.getLocation().getDirection();
                    vector = vector.multiply(5);
                    players.setVelocity(vector);
                    players.setGravity(true);
                }
            }
        }
    }
}
