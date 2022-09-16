package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class suicide implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equals("die")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("snr.die")) {
                    if (args.length == 0) {
                        player.setHealth(0);
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Killed.");
                    } else if (args.length == 1) {
                        if (player.hasPermission("snr.die.others")) {
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if (target instanceof Player) {
                                target.setHealth(0);
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Killed.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Killed §d" + target.getDisplayName() + "§3.");
                            } else {
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        } else {
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    } else {
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                    }

                } else {
                    player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command.");
                }
            } else {
                if (args.length == 0) {
                    System.out.println("§3§lSN§c§lR §6§l> §r§cInvalid Player.");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        target.setHealth(0);
                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Killed.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Killed §d" + target.getDisplayName() + "§3.");
                    } else {
                        System.out.println("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                    }



                }
            }
        }
        return true;
    }
}