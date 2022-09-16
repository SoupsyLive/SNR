package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class trash implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equals("trash")){
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("snr.trash")){
                    if(args.length == 0){
                        Inventory v = Bukkit.createInventory(p, 54, "Trash");
                        p.openInventory(v);
                        p.sendMessage("§3§lSN§c§lR §6§l> §r§3Opened the Trashcan.");
                    }else if(args.length == 1){
                        if(p.hasPermission("snr.trash.others")){
                            Player t = Bukkit.getPlayerExact(args[0]);
                            if(t instanceof Player) {
                                Inventory v = Bukkit.createInventory(t, 54, "Trash");
                                t.openInventory(v);
                                p.sendMessage("§3§lSN§c§lR §6§l> §r§3Opened §d" + t.getDisplayName() + "§d's §3Trashcan.");
                            }else if(args[0].equalsIgnoreCase("@a") || args[0].equalsIgnoreCase("*")){
                                for(Player ps : Bukkit.getOnlinePlayers()) {
                                    Inventory v = Bukkit.createInventory(ps, 54, "Trash");
                                    ps.openInventory(v);
                                    p.sendMessage("§3§lSN§c§lR §6§l> §r§3Opened §dEveryone's §3Trashcan.");
                                }
                            }else{
                                p.sendMessage("§3§lSN§c§lR §6§l> §r§cInvalid Player.");
                            }
                        }else{
                            p.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }else{
                        p.sendMessage("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                    }
                }else{
                    p.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command.");
                }
            }else{
                if(args.length == 0){
                    System.out.println("§3§lSN§c§lR §6§l> §r§cPick a Player.");
                }else if(args.length == 1){
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if(t instanceof Player) {
                        Inventory v = Bukkit.createInventory(t, 54, "Trash");
                        t.openInventory(v);
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Opened §d" + t.getDisplayName() + "§d's §3Trashcan.");
                    }else if(args[0].equalsIgnoreCase("*")){
                        for(Player ps : Bukkit.getOnlinePlayers()) {
                            Inventory v = Bukkit.createInventory(ps, 54, "Trash");
                            ps.openInventory(v);
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Opened §dEveryone's §3Trashcan.");
                        }
                    }else if(args[0].equalsIgnoreCase("@a")){
                        for(Player ps : Bukkit.getOnlinePlayers()) {
                            Inventory v = Bukkit.createInventory(ps, 54, "Trash");
                            ps.openInventory(v);
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Opened §dEveryone's §3Trashcan.");
                        }
                    }else{
                        System.out.println("§3§lSN§c§lR §6§l> §r§cInvalid Player.");
                    }
                }else{
                    System.out.println("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                }

            }
        }

        return true;
    }
}
