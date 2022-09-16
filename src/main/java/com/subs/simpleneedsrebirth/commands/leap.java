package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class leap implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("leap")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.leap")){
                    if(args.length == 0){
                            player.setVelocity(player.getLocation().getDirection().setY(1));
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Yeet.");
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.leap.others")){
                                double leapmount = Double.parseDouble(args[0]);
                                player.setVelocity(player.getLocation().getDirection().setY(leapmount));
                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }
                    else if (args.length == 2){
                        if(player.hasPermission("snr.extinguish.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player & args[1].equalsIgnoreCase("-s")) {
                                    target.setFireTicks(0);
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
                            target.setFireTicks(0);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Extinguished.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Extinguished §d" + target.getDisplayName() + "§3.");
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