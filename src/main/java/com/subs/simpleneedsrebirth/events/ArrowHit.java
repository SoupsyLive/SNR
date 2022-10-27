package com.subs.simpleneedsrebirth.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ArrowHit implements Listener {
    @EventHandler
    public void onSnipe(EntityDamageByEntityEvent e) {
        //shooter
        Player dam;
        //victim
        Player vic;

        if(e.getDamager() instanceof Projectile) {
            //if damager is projectile, protectile is named "pj"
            Projectile pj = (Projectile) e.getDamager();
            if(pj.getShooter() instanceof Player){
                //if projectile shooter is Player, get victim and shooter
                dam = (Player) pj.getShooter();
                vic = (Player) e.getEntity();
                if(vic instanceof Player){
                    //get victim health
                    double hpMount = vic.getHealth();
                    double abMount = vic.getAbsorptionAmount();
                    double dmg = e.getDamage();
                    int rHpMount = (int) hpMount;
                    int rAbMount = (int) abMount;
                    int rDmg = (int) dmg;
                    int newHp = ((rHpMount+rAbMount)-rDmg);
                    //get victim name
                    String vicName = vic.getDisplayName();
                    //send shooter victim name and health
                    if (newHp >= 0) {
                        dam.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§3"+vicName+" §c§l"+newHp+"§r§c❤"));
                    }else{
                        dam.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§3"+vicName+" §c§l"+0+"§r§c❤"));
                    }

                }
            }
        }
    }
}
