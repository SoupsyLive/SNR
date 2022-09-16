package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class battle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("battle")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("snr.battle")){
                    if(args.length == 0) {
                        player.setHealth(20);
                        player.setFoodLevel(20);
                        player.setSaturation(5);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Health Reset.");
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(player.hasPermission("snr.battle.others")) {
                            if(target instanceof Player) {
                                target.setHealth(20);
                                target.setFoodLevel(20);
                                target.setSaturation(5);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Health Reset.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Reset §d" + target.getDisplayName() + "§d's §3Health");
                            }else if(args[0].equalsIgnoreCase("*")){
                                for(Player ps : Bukkit.getOnlinePlayers()) {
                                    ps.setHealth(20);
                                    ps.setFoodLevel(20);
                                    ps.setSaturation(5);
                                    ps.sendMessage("§3§lSN§c§lR §6§l> §r§3Health Reset.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Reset §dEveryone's §3Health");
                                }

                            }
                            else if(args[0].equalsIgnoreCase("@a")){
                                for(Player ps : Bukkit.getOnlinePlayers()) {
                                    ps.setHealth(20);
                                    ps.setFoodLevel(20);
                                    ps.setSaturation(5);
                                    ps.sendMessage("§3§lSN§c§lR §6§l> §r§3Health Reset.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Reset §dEveryone's §3Health");
                                }

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
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust Choose a player to reset.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.setSaturation(5);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§Health Reset.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Reset §d" + target.getDisplayName() + "§d's §3Health");
                    }else if(args[0].equalsIgnoreCase("*")){
                        for(Player ps : Bukkit.getOnlinePlayers()) {
                            ps.setHealth(20);
                            ps.setFoodLevel(20);
                            ps.setSaturation(5);
                            ps.sendMessage("§3§lSN§c§lR §6§l> §r§3Health Reset.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Reset §dEveryone's §3Health");
                        }

                    }
                    else if(args[0].equalsIgnoreCase("@a")){
                        for(Player ps : Bukkit.getOnlinePlayers()) {
                            ps.setHealth(20);
                            ps.setFoodLevel(20);
                            ps.setSaturation(5);
                            ps.sendMessage("§3§lSN§c§lR §6§l> §r§3Health Reset.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Reset §dEveryone's §3Health");
                        }
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

