package com.subs.simpleneedsrebirth.commands;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class gma implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("gma")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("snr.gma")){
                    if(args.length == 0) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Adventure.");
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(player.hasPermission("snr.gma.others")) {
                            if(target instanceof Player) {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Adventure.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Set §d" + target.getDisplayName() + "§d's §3Gamemode to Adventure.");
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
                        target.setGameMode(GameMode.ADVENTURE);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Adventure.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Set §d" + target.getDisplayName() + "§d's §3Gamemode to Adventure.");
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
