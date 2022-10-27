package com.subs.simpleneedsrebirth.commands;

import com.subs.simpleneedsrebirth.utils.ArgNumbCheckUtil;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("extinguish")){
            if(sender instanceof Player) {
                Player p = (Player) sender;

                if(p.hasPermission("snr.extinguish")){
                    if(args.length == 4){
                            //arg 1
                        if(ArgNumbCheckUtil.isInt(args[1]) && ArgNumbCheckUtil.isInt(args[2]) && ArgNumbCheckUtil.isInt(args[3])){
                            int hpMount = Integer.parseInt(args[1]);
                            int fdMount = Integer.parseInt(args[2]);
                            int stMount = Integer.parseInt(args[3]);
                            double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                            double curHealth = p.getHealth();
                            double healthDif = (maxHealth-curHealth);
                            int curFood = p.getFoodLevel();
                            float curSat = p.getSaturation();




                            if(args[0].equalsIgnoreCase("add")){
                                if (20-(curFood+fdMount) >= 0 && 20-(curSat+stMount) >= 0){
                                    if(maxHealth-(hpMount+curHealth) >= 0 ){
                                        p.setHealth(curHealth+hpMount);
                                    }else{
                                        p.setHealth(maxHealth);
                                        p.setAbsorptionAmount(hpMount-healthDif);
                                    }
                                    p.setFoodLevel(curFood+fdMount);
                                    p.setSaturation(curSat+stMount);
                                    p.sendMessage("§3§lSN§c§lR §6§l> §r§3Set to §b"+(curFood)+".");
                                }else{
                                    p.sendMessage("ballin");
                                }
                            }else if(args[0].equalsIgnoreCase("set")){
                                if (fdMount <= 20 && stMount <= 20){
                                    if(hpMount > maxHealth){
                                        p.setHealth(maxHealth);
                                        p.setAbsorptionAmount(hpMount-maxHealth);

                                    p.setFoodLevel(curFood+fdMount);
                                    p.setSaturation(curSat+stMount);
                                    p.sendMessage("§3§lSN§c§lR §6§l> §r§3Set to .");
                                }else{
                                    p.sendMessage("ballin");
                                }
                            }
                        }
                    }else if (args.length == 1){
                        if(p.hasPermission("snr.extinguish.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player) {
                                    target.setFireTicks(0);
                                    target.sendMessage("§3§lSN§c§lR §6§l> §r§3Extinguished.");
                                    p.sendMessage("§3§lSN§c§lR §6§l> §r§3Extinguished §d" + target.getDisplayName() + "§3.");
                            }else if(args[0].equalsIgnoreCase("-s")){
                                    p.setFireTicks(0);
                            }else{
                                p.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                            }
                        }else{
                            p.sendMessage("§3§lSN§c§lR §6§l> §r§cYou do not have permission to run that command on others.");
                        }
                    }
                    else if (args.length == 2){
                        if(p.hasPermission("snr.extinguish.others")){
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player & args[1].equalsIgnoreCase("-s")) {
                                    target.setFireTicks(0);
                            }else{
                                p.sendMessage("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
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
                    System.out.println("§3§lSN§c§lR §6§l> §r§cMust run command on a player.");
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                            target.setFireTicks(0);
                            target.sendMessage("§3§lSN§c§lR §6§l> §r§3Extinguished.");
                            System.out.println("§3§lSN§c§lR §6§l> §r§3Extinguished §d" + target.getDisplayName() + "§3.");
                    }else{
                        System.out.println("§3§lSN§c§lR §6§l> §r§cNot a valid player.");
                    }
                }else{
                    System.out.println("§3§lSN§c§lR §6§l> §r§cToo Many Arguments.");
                }
            }

        }
        return true;
    }return true;
} }