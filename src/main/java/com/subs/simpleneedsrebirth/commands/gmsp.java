package com.subs.simpleneedsrebirth.commands;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class gmsp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("gmsp")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("snr.gmsp")){
                    if(args.length == 0) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Spectator.");
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(player.hasPermission("snr.gmsp.others")) {
                            if(target instanceof Player) {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Spectator.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Set §d" + target.getDisplayName() + "§d's §3Gamemode to Spectator.");
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
                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Set Gamemode to Spectator.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Set §d" + target.getDisplayName() + "§d's §3Gamemode to Spectator.");
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
