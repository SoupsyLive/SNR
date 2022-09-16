package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("vanish")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.vanish")){
                    if(args.length == 0){
                        if (!player.isInvisible()) {
                            player.setInvisible(true);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Vanished.");
                        }
                        else {
                            player.setInvisible(false);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Un-Vanished.");
                        }
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.vanish.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                if(!target.isInvisible()) {
                                    player.setInvisible(true);
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Vanished.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Vanished §d" + target.getDisplayName() + "§3.");
                                }else {
                                        target.setInvisible(false);
                                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Un-Vanished.");
                                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Un-Vanished §d" + target.getDisplayName() + "§3.");
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
                        if(!target.isInvisible()) {
                            target.setInvisible(true);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Vanished.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Vanished §d" + target.getDisplayName() + "§3.");
                        }else {
                                target.setInvisible(false);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Un-Vanished.");
                                System.out.println("§3§lSN§c§lR §6§l> §r§3Un-Vanished §d" + target.getDisplayName() + "§3.");
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

