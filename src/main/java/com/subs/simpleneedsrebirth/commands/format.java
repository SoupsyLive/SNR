package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class format implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("command")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("snr.word")){
                    if(args.length == 0){
                        //Command by itself
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Success.");
                    }else if (args.length == 1){
                        if(player.hasPermission("snr.word.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                //Command at a player
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Enabled.");
                                    player.sendMessage("§3§lSN§c§lR §6§l> §r§3Enabled §d" + target.getDisplayName() + "§d's §3Command.");
                                }else {
                                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Disabled.");
                                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Disabled §d" + target.getDisplayName() + "§d's §3Command.");
                                    }
                                }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                            }else{
                        //more than 2 words
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                            }
                        }else{
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command");
                        }
            }else{
                //console version
                if(args.length == 0){
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust run command on a player.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Fly Enabled.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Enabled §d" + target.getDisplayName() + "§d's §3Flight.");
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

