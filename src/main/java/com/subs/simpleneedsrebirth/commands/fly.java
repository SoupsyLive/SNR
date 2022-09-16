package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("fly")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.fly")){
                    if(args.length == 0){
                        if (!player.getAllowFlight()) {
                            player.setAllowFlight(true);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Enabled.");
                        }
                        else {
                            player.setAllowFlight(false);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Disabled.");
                        }
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.fly.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                if(!target.getAllowFlight()) {
                                    target.setAllowFlight(true);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Enabled.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Enabled §d" + target.getDisplayName() + "§d's §3Flight.");
                                }else {
                                    if (target.getAllowFlight()) {
                                        target.setAllowFlight(false);
                                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Disabled.");
                                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Disabled §d" + target.getDisplayName() + "§d's §3Flight.");
                                    }
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
                if(args.length == 0){
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust run command on a player.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        if(!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Enabled.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Enabled §d" + target.getDisplayName() + "§d's §3Flight.");
                        }else {
                            if (target.getAllowFlight()) {
                                target.setAllowFlight(false);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Disabled.");
                                System.out.println("§3§lSN§c§lR §6§l> §r§3Disabled §d" + target.getDisplayName() + "§d's §3Flight.");
                            }
                        }
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

