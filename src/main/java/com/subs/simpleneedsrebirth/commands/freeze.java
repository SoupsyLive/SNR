package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class freeze implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("freeze")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.freeze")){
                    if(args.length == 0){
                        if (player.getWalkSpeed() > 0) {
                            player.setWalkSpeed(0);
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 230));
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Frozen.");
                        }
                        else {
                            player.setWalkSpeed((float) 0.2);
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§3Unfrozen.");
                            player.removePotionEffect(PotionEffectType.JUMP);
                        }
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.freeze.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                if(target.getWalkSpeed() > 0) {
                                    target.setWalkSpeed(0);
                                    target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 230));
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Frozen.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Froze §d" + target.getDisplayName() + "§3.");
                                }else {
                                    target.setWalkSpeed((float) 0.2);
                                    target.removePotionEffect(PotionEffectType.JUMP);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Unfrozen.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Unfroze §d" + target.getDisplayName() + "§3.");
                                }
                            }else if(args[0].equalsIgnoreCase("-s")){
                                if (player.getWalkSpeed() > 0) {
                                    player.setWalkSpeed(0);
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 230));
                                }
                                else {
                                    player.setWalkSpeed((float) 0.2);
                                    player.removePotionEffect(PotionEffectType.JUMP);
                                }
                            }else{
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }else if (args.length == 2){
                        if(player.hasPermission("snr.freeze.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player & args[1].equalsIgnoreCase("-s")) {
                                if(target.getWalkSpeed() > 0) {
                                    target.setWalkSpeed(0);
                                    target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 230));
                                }else {
                                    target.setWalkSpeed((float) 0.2);
                                    target.removePotionEffect(PotionEffectType.JUMP);
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
                        if(target.getWalkSpeed() > 0) {
                            target.setWalkSpeed(0);
                            target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 230));
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Frozen.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Froze §d" + target.getDisplayName() + "§3.");
                        }else {
                            target.setWalkSpeed((float) 0.2);
                            target.removePotionEffect(PotionEffectType.JUMP);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Unfrozen.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Unfroze §d" + target.getDisplayName() + "§3.");
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