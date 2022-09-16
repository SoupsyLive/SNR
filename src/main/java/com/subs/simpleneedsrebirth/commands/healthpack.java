package com.subs.simpleneedsrebirth.commands;

import com.subs.simpleneedsrebirth.SimpleNeedsREBIRTH;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healthpack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("healthpack")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.healthpack")){
                    if(args.length == 0){
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3The current healthpack is §c"+"§3.");
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.arrowremove.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                    target.setArrowsInBody(0);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Removed Arrows.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Removed §d" + target.getDisplayName() + "'s §3Arrows.");
                            }else if(args[0].equalsIgnoreCase("-s")){
                                    player.setArrowsInBody(0);
                            }else{
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }
                    else if (args.length == 2){
                        if(player.hasPermission("snr.extinguish.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player & args[1].equalsIgnoreCase("-s")) {
                                    target.setArrowsInBody(0);
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
                if(args.length == 0){
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust run command on a player.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                            target.setArrowsInBody(0);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Removed Arrows.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Removed §d" + target.getDisplayName() + "'s §3Arrows.");
                    }else{
                        System.out.println("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                    }
                }else{
                    System.out.println("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                }
            }

        }
        return true;
    }
}