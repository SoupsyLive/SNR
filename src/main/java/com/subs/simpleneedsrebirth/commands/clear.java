package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("ci")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.clear")) {
                    if(args.length == 0) {
                        player.getInventory().clear();
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Cleared Inventory.");
                    }else if(args.length == 1) {
                        if(player.hasPermission("snr.clear.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                target.getInventory().clear();
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Cleared Inventory.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Cleared §d" + target.getDisplayName() + "§d's §3Inventory.");
                            }else{
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cInvalid Name.");
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
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player) {
                    if(args.length == 0) {
                        System.out.println("§3§lSN§c§lR §6§l> §r§cPlease pick a player.");
                    }else if(args.length == 1) {
                        target.getInventory().clear();
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Cleared Inventory.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Cleared §d" + target.getDisplayName() + "§d's §3Inventory.");
                    }else{
                        System.out.println("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                    }
                }else{
                    System.out.println("§3§lSN§c§lR §6§l> §r§cInvalid Name.");
                }
            }
        }

        return false;
    }
}

