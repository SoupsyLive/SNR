package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hurt implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("hurt")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("snr.hurt")){
                    if(args.length == 0) {
                        player.setHealth(1);
                        player.setFoodLevel(6);
                        player.setSaturation(0);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Hurt.");
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(player.hasPermission("snr.hurt.others")) {
                            if(target instanceof Player) {
                                target.setHealth(1);
                                target.setFoodLevel(6);
                                target.setSaturation(0);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Hurt.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Hurt §d" + target.getDisplayName() + "§3.");
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
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust Choose a player to hurt.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        target.setHealth(1);
                        target.setFoodLevel(6);
                        target.setSaturation(0);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Hurt.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Hurt §d" + target.getDisplayName() + "§3.");
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


