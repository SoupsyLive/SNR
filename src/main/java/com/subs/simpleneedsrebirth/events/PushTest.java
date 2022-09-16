package com.subs.simpleneedsrebirth.events;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PushTest implements Listener {
    @EventHandler
    public void onPunch(EntityDamageByEntityEvent e){
        Entity victim = e.getEntity();
        Entity assaulter = e.getDamager();
        Vector vector = assaulter.getLocation().getDirection().setY(0.1);
        if (assaulter instanceof Player) {
            if (((Player) assaulter).getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                vector = vector.multiply(5);
                victim.setVelocity(vector);
                victim.setGravity(true);
            }
        }

    }
}
