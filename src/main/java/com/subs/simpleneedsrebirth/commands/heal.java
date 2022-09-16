package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("heal")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("snr.heal")){
                    if(args.length == 0) {
                        double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                        player.setHealth(maxHealth);
                        player.setFoodLevel(20);
                        player.setSaturation(20);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Healed.");
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(player.hasPermission("snr.heal.others")) {
                            if(target instanceof Player) {
                                double maxHealth = target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                                target.setHealth(maxHealth);
                                target.setFoodLevel(20);
                                target.setSaturation(20);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Healed.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Healed §d" + target.getDisplayName() + "§3.");
                            }else{
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }

                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }else{
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                    }
                }else{
                    player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command.");
                }

            }else{
                if(args.length == 0) {
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust Choose a player to heal.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        double maxHealth = target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                        target.setHealth(maxHealth);
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Healed.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Healed §d" + target.getDisplayName() + "§3.");
                    }else{
                        System.out.println("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                    }
                }else{
                    System.out.println("§3§lSN§c§lR §6§l> §r§cToo many arguments.");
                }
            }
        }

        return true;
    }
}

