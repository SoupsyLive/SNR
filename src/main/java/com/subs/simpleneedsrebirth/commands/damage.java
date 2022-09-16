package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class damage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("damage")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.damage")){
                    if(args.length == 0){
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot Enough Arguments.");
                    }else if(args.length == 1){
                        double d = Double.parseDouble(args[0]);
                        player.damage(d);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Delt §c§l-"+d+"❤§r§33.");
                    }else if (args.length == 2){
                        if(player.hasPermission("snr.damage.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                double d = Double.parseDouble(args[1]);
                                    target.damage(d);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Delt §c§l-"+d+"❤§r§33.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Delt  §c§l-"+d+"❤§r§3 to §d" + target.getDisplayName() + "§3.");
                            }else if(args[1].equalsIgnoreCase("-s")){
                                double d = Double.parseDouble(args[0]);
                                    player.damage(d);
                            }else{
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }
                    else if (args.length == 3){
                        if(player.hasPermission("snr.damage.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player & args[2].equalsIgnoreCase("-s")) {
                                double d = Double.parseDouble(args[1]);
                                    target.damage(d);
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
                if(args.length <= 1){
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust run command on a player.");
                }else if(args.length == 2) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        double d = Double.parseDouble(args[1]);
                            target.damage(d);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Delt §c§l-"+d+"❤§r§33.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Delt  §c§l-"+d+"❤§r§3 to §d" + target.getDisplayName() + "§3.");
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