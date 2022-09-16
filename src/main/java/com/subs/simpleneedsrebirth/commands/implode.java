package com.subs.simpleneedsrebirth.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class implode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("implode")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("snr.implode")) {
                    if (args.length == 0) {
                        for (Entity players : player.getNearbyEntities(20, 20, 20)) {
                            if (players instanceof Player) {
                                Vector vector = player.getLocation().getDirection();
                                vector = vector.multiply(-2.5);

                                players.setVelocity(vector);
                                players.setGravity(true);
                            }
                        }
                        for (Entity players : player.getNearbyEntities(10, 10, 10)) {
                            if (players instanceof Player) {
                                Vector vector = player.getLocation().getDirection();
                                vector = vector.multiply(-3);
                                players.setVelocity(vector);
                                players.setGravity(true);
                            }
                        }
                        for (Entity players : player.getNearbyEntities(5, 5, 5)) {
                            if (players instanceof Player) {
                                Vector vector = player.getLocation().getDirection();
                                vector = vector.multiply(-0.55);
                                players.setVelocity(vector);
                                players.setGravity(true);
                            }
                        }
                        player.sendMessage("§3§lSN§c§lR §6§l> §r§3Blasted away.");
                    } else if (args.length == 1) {
                        if (player.hasPermission("snr.blast.others")) {
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if (target instanceof Player) {
                                for (Entity players : target.getNearbyEntities(20, 20, 20)) {
                                    if (players instanceof Player) {
                                        Vector vector = target.getLocation().getDirection();
                                        vector = vector.multiply(-2.5);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                for (Entity players : target.getNearbyEntities(10, 10, 10)) {
                                    if (players instanceof Player) {
                                        Vector vector = target.getLocation().getDirection();
                                        vector = vector.multiply(-1);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                for (Entity players : target.getNearbyEntities(5, 5, 5)) {
                                    if (players instanceof Player) {
                                        Vector vector = target.getLocation().getDirection();
                                        vector = vector.multiply(-0.55);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                target.sendMessage("§3§lSN§c§lR §6§l> §r§3Pulled in.");
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§3Pulled in everyone near §d" + target.getDisplayName() + "§3.");

                            } else if (args[0].equalsIgnoreCase("-s")) {
                                for (Entity players : player.getNearbyEntities(20, 20, 20)) {
                                    if (players instanceof Player) {
                                        Vector vector = player.getLocation().getDirection();
                                        vector = vector.multiply(-2.5);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                for (Entity players : player.getNearbyEntities(10, 10, 10)) {
                                    if (players instanceof Player) {
                                        Vector vector = player.getLocation().getDirection();
                                        vector = vector.multiply(-1);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                for (Entity players : player.getNearbyEntities(5, 5, 5)) {
                                    if (players instanceof Player) {
                                        Vector vector = player.getLocation().getDirection();
                                        vector = vector.multiply(-0.55);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }

                            } else {
                                player.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        } else {
                            player.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    } else if (args.length == 2) {
                        if (player.hasPermission("snr.blast.others")) {
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if (target instanceof Player & args[1].equalsIgnoreCase("-s")) {
                                for (Entity players : target.getNearbyEntities(20, 20, 20)) {
                                    if (players instanceof Player) {
                                        Vector vector = target.getLocation().getDirection();
                                        vector = vector.multiply(-2.5);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                for (Entity players : target.getNearbyEntities(10, 10, 10)) {
                                    if (players instanceof Player) {
                                        Vector vector = target.getLocation().getDirection();
                                        vector = vector.multiply(-1);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
                                for (Entity players : target.getNearbyEntities(5, 5, 5)) {
                                    if (players instanceof Player) {
                                        Vector vector = target.getLocation().getDirection();
                                        vector = vector.multiply(-0.55);
                                        players.setVelocity(vector);
                                        players.setGravity(true);
                                    }
                                }
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
                    System.out.println("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command.");
                }

            } else {
                if (args.length == 0) {
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust run command on a player.");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        for (Entity players : target.getNearbyEntities(10, 10, 10)) {
                            if (players instanceof Player) {
                                Vector vector = target.getLocation().getDirection();
                                vector = vector.multiply(-1);
                                players.setVelocity(vector);
                                players.setGravity(true);
                            }
                        }
                        for (Entity players : target.getNearbyEntities(5, 5, 5)) {
                            if (players instanceof Player) {
                                Vector vector = target.getLocation().getDirection();
                                vector = vector.multiply(-0.55);
                                players.setVelocity(vector);
                                players.setGravity(true);
                            }
                        }

                        target.sendMessage("§3§lSN§c§lR §6§l> §r§3Blasted away.");
                        System.out.println("§3§lSN§c§lR §6§l> §r§3Blasted away everyone near §d" + target.getDisplayName() + "§3.");
                    } else {
                        System.out.println("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                    }
                } else {
                    System.out.println("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                }
            }

        }   return true;
    }
}