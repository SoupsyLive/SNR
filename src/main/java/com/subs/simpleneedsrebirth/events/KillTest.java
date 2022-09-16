package com.subs.simpleneedsrebirth.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillTest implements Listener {
    @EventHandler
    public void onKill(PlayerDeathEvent event){
        Player killer = event.getEntity().getKiller();
        Player victim = event.getEntity().getPlayer();
        double maxHealth = killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
        double curHealth = killer.getHealth();
        double heathDif = (maxHealth - curHealth);
        int aCurHealth = (int) curHealth;
        int aHealthDif = (int) heathDif;
        double rCurHealth = (double) aCurHealth;
        double rHealthDif = (double) aHealthDif;
        if(heathDif <= 4) {
            killer.setAbsorptionAmount(killer.getAbsorptionAmount() + (6 - rHealthDif));
            killer.setHealth(maxHealth);
            killer.damage(1);
            //victim.spawnParticle(Particle.REDSTONE, victim.getLocation(), 20, 1.5, 2.5, 1.5);
            if (heathDif == 0) {
                killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§3§l+(§e§l"+ ((5 - rHealthDif)/2) +"§e❤§3§l)"));
                killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 500.0f, 0.0f);
                killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 500.0f, 1.0f);
                killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 500.0f, 2.0f);
            }else{
                killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§3§l+(§c§l"+ (rHealthDif/2) +"§c❤§3§l & §e§l"+ ((5 - rHealthDif)/2) +"§e❤§3§l)"));
                killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 500.0f, 0.8f);
            }
        }else{
            killer.setHealth(rCurHealth + 5);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§3§l+(§c§l2.5§c❤§3§l)"));
            killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 500.0f, 0f);
        }
    }
}
