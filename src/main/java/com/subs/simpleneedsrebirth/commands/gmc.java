package com.subs.simpleneedsrebirth.commands;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class gmc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("gmc")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("snr.gmc")){
                    if(args.length == 0) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Creative.");
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(player.hasPermission("snr.gmc.others")) {
                            if(target instanceof Player) {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Creative.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Set §d" + target.getDisplayName() + "§d's §3Gamemode to Creative.");
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
                    System.out.println("§3§lSN§c§lR §6§l> §r§cYou are a console, pick a player silly.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Creative.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Set §d" + target.getDisplayName() + "§d's §3Gamemode to Creative.");
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
