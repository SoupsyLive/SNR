package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class god implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("god")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.god")){
                    if(args.length == 0){
                        if (!player.isInvulnerable()) {
                            player.setInvulnerable(true);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3God Enabled.");
                        }
                        else {
                            player.setInvulnerable(false);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3God Disabled.");
                        }
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.god.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                if(!target.isInvulnerable()) {
                                    target.setInvulnerable(true);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3God Enabled.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Enabled §d" + target.getDisplayName() + "§3's God.");
                                }else {
                                    target.setInvulnerable(false);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3God Disabled.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Disabled §d" + target.getDisplayName() + "§3's God.");
                                }
                            }else if(args[0].equalsIgnoreCase("-s")){
                                if(!player.isInvulnerable()) {
                                    player.setInvulnerable(true);
                                }
                                else {
                                    player.setInvulnerable(false);
                                }
                            }else{
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }
                    else if (args.length == 2){
                        if(player.hasPermission("snr.god.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player & args[1].equalsIgnoreCase("-s")) {
                                if(!target.isInvulnerable()) {
                                    target.setInvulnerable(true);
                                }else {
                                    target.setInvulnerable(false);
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
                        if(!target.isInvulnerable()) {
                            target.setInvulnerable(true);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3God Enabled.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Enabled §d" + target.getDisplayName() + "§3's God.");
                        }else {
                            target.setInvulnerable(false);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3God Disabled.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Disabled §d" + target.getDisplayName() + "§3's God.");
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