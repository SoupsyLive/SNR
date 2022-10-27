package com.subs.simpleneedsrebirth.commands;

import com.subs.simpleneedsrebirth.utils.ArgNumbCheckUtil;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class newheal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("command")){
            if (sender instanceof Player){ //player or server?
                //Player ran
                Player p = (Player) sender;
                //define player as sender
                double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                double curHealth = p.getHealth();
                double healthDif = (maxHealth-curHealth);
                int varMount = Integer.parseInt(args[0]);
                double chatHeal = Math.round((varMount/1000) * 10) / 10;

                if(p.hasPermission("snr.command")){ //self perm check
                    if (args.length == 0){ // no args
                        // solo command (/cmd)
                        p.setHealth(maxHealth);
                        p.sendMessage("§3§lSN§c§lR §6§l>§r§3 Healed.");
                    }else if (args.length == 1){ //1 arg
                        // command + 1 arg (/cmd 1)
                        Player t = Bukkit.getPlayerExact(args[0]);
                        //define target
                        double tmaxHealth = t.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                        double tcurHealth = t.getHealth();
                        double thealthDif = (tmaxHealth-tcurHealth);

                        if(args[0].equalsIgnoreCase("-s")){ //if arg 0 is -s
                            //silent ran
                            //base action without message
                            p.setHealth(maxHealth);
                        }else if(t instanceof Player){
                            if(p.hasPermission("snr.command.others")){ //perm check
                                //base action ran on player

                                p.sendMessage("§3§lSN§c§lR §6§l>§r§3 MESSAGE §"+t.getDisplayName()+".");
                                t.sendMessage("§3§lSN§c§lR §6§l>§r§3 TARGETMESSAGE.");
                            }else{
                                //no perms for others
                                p.sendMessage("§3§lSN§r§cR §3§l>§r§c You do not have perms to use this on others.");
                            }
                        }else if(args[0].equalsIgnoreCase("@a") || args[0].equalsIgnoreCase("*")) {
                            if(p.hasPermission("snr.command.others")){
                                for (Player ps : Bukkit.getOnlinePlayers()) {
                                    p.sendMessage("§3§lSN§c§lR §6§l>§r§3 MESSAGE§d Everyone §r§3.");
                                    ps.sendMessage("§3§lSN§c§lR §6§l>§r§3 TARGETMESSAGE.");
                                }
                            }else{//no perms
                                p.sendMessage("§3§lSN§r§cR §3§l>§r§c You do not have perms to use this on others.");
                            }
                        }else if(ArgNumbCheckUtil.isInt(args[0])) {  //number check, check utils > ArgNumbCheckUtil
                            // self action defined by number

                            p.damage(varMount);
                            p.sendMessage("§3§lSN§c§lR §6§l>§r§3 MESSAGE.");
                        }else{ //none of the checks work
                            p.sendMessage("§3§lSN§r§cR §3§l>§r§c Invalid arguments.");
                        }
                    }else if(args.length == 2){
                        //cmd 1 2
                        if(ArgNumbCheckUtil.isInt(args[0])){ // numb check /cmd HERE -s
                            //self silent
                            if(args[1].equalsIgnoreCase("-s")){

                                p.damage(varMount);
                                //no message
                            }else{ //1st slot is number, 2nd slot is not -s
                                p.sendMessage("§3§lSN§r§cR §3§l>§r§c You have too many arguments.");
                            }
                        }else{ //target player instead
                            Player t = Bukkit.getPlayerExact(args[0]);
                            if(t instanceof Player){
                                if(args[1].equalsIgnoreCase("-s")){
                                    t.damage(1); //silent target base action
                                }else if(ArgNumbCheckUtil.isInt(args[1])){
                                    if(p.hasPermission("snr.command.others")){ //perm check

                                        t.damage(varMount);
                                        p.sendMessage("§3§lSN§c§lR §6§l>§r§3 MESSAGE §"+t.getDisplayName()+".");
                                        t.sendMessage("§3§lSN§c§lR §6§l>§r§3 TARGETMESSAGE.");
                                    }else{//no perms
                                        p.sendMessage("§3§lSN§r§cR §3§l>§r§c You don't have the perms for that.");
                                    }

                                }else{ //2nd slot not a number or silent, error
                                    p.sendMessage("§3§lSN§r§cR §3§l>§r§c Your second argument doesn't work.");
                                }
                            }else if(args[0].equalsIgnoreCase("@a") || args[0].equalsIgnoreCase("*")){
                                for(Player ps : Bukkit.getOnlinePlayers()){
                                    if(args[1].equalsIgnoreCase("-s")){
                                        t.damage(1); //silent target base action
                                    }else if(ArgNumbCheckUtil.isInt(args[1])){
                                        if(p.hasPermission("snr.command.others")){ //perm check

                                            ps.damage(varMount);
                                            p.sendMessage("§3§lSN§c§lR §6§l>§r§3 MESSAGE§d EVERYONE§3.");
                                            ps.sendMessage("§3§lSN§c§lR §6§l>§r§3 TARGETMESSAGE.");
                                        }else{//no perms
                                            p.sendMessage("§3§lSN§r§cR §3§l>§r§c You do not have the perms to run this on others.");
                                        }

                                    }else{ //2nd slot not a number or silent, error
                                        p.sendMessage("§3§lSN§r§cR §3§l>§r§c Your second argument is invalid.");
                                    }
                                }
                            }else{ //invalid player
                                p.sendMessage("§3§lSN§r§cR §3§l>§r§c Invalid player.");
                            }

                        }
                    }else if(args.length == 3){
                        //cmd 1 2 3
                        //target number silent
                        Player t = Bukkit.getPlayerExact(args[0]);
                        if(t instanceof Player){
                            if(ArgNumbCheckUtil.isInt(args[1])){
                                if(args[2].equalsIgnoreCase("-s")){
                                    //silent specified

                                    t.damage(varMount);
                                }else{//3 args but 3rd isnt -s
                                    p.sendMessage("§3§lSN§r§cR §3§l>§r§c You have too many arguments, use -s as your third argument to make it silent.");
                                }
                            }else{//3 args but 2nd isn't number
                                p.sendMessage("§3§lSN§r§cR §3§l>§r§c The 2nd argument has to be a number.");
                            }
                        }else if(args[0].equalsIgnoreCase("@a") || args[0].equalsIgnoreCase("*")){
                            for(Player ps : Bukkit.getOnlinePlayers()){
                                if(ArgNumbCheckUtil.isInt(args[1])){
                                    if(args[2].equalsIgnoreCase("-s")){
                                        if(p.hasPermission("snr.command.others")){
                                            //silent specified

                                            ps.damage(varMount);
                                        }else{//no perms
                                            p.sendMessage("§3§lSN§r§cR §3§l>§r§c You do not have the perms to run this on others.");
                                        }
                                    }else{//3 args but 3rd isnt -s
                                        p.sendMessage("§3§lSN§r§cR §3§l>§r§c You have too many arguments, use -s as your third argument to make it silent.");
                                    }
                                }else{//3 args but 2nd isn't number
                                    p.sendMessage("§3§lSN§r§cR §3§l>§r§c The 2nd argument has to be a number.");
                                }
                            }
                        }else{ // non player target
                            p.sendMessage("§3§lSN§r§cR §3§l>§r§c You have to run this on a player with that many arguments.");
                        }
                    }else{ //too many arguments
                        p.sendMessage("§3§lSN§r§cR §3§l>§r§c Too many arguments.");
                    }
                }else{
                    p.sendMessage("§3§lSN§r§cR §3§l>§r§c You do not have the perms for this.");
                }
            }else{
                //Console ran
                if(args.length == 2){
                    //cmd 1 2
                        Player t = Bukkit.getPlayerExact(args[0]);
                        if(t instanceof Player){
                            if(args[1].equalsIgnoreCase("-s")){
                                t.damage(1); //silent target base action
                            }else if(ArgNumbCheckUtil.isInt(args[1])){
                                    int varMount = Integer.parseInt(args[1]);
                                    t.damage(varMount);
                                System.out.println("§3§lSN§c§lR §6§l>§r§3 MESSAGE §"+t.getDisplayName()+".");
                                    t.sendMessage("§3§lSN§c§lR §6§l>§r§3 TARGETMESSAGE.");


                            }else{ //2nd slot not a number or silent, error
                                System.out.println("§3§lSN§r§cR §3§l>§r§c Your second argument is invalid.");
                            }
                        }else if(args[0].equalsIgnoreCase("@a") || args[0].equalsIgnoreCase("*")){
                            for(Player ps : Bukkit.getOnlinePlayers()){
                                if(args[1].equalsIgnoreCase("-s")){
                                    t.damage(1); //silent target base action
                                }else if(ArgNumbCheckUtil.isInt(args[1])){
                                        int varMount = Integer.parseInt(args[1]);
                                        ps.damage(varMount);
                                    System.out.println("§3§lSN§c§lR §6§l>§r§3 MESSAGE §"+t.getDisplayName()+".");
                                        ps.sendMessage("§3§lSN§c§lR §6§l>§r§3 TARGETMESSAGE.");
                                }else{ //2nd slot not a number or silent, error
                                    System.out.println("§3§lSN§r§cR §3§l>§r§c Your second argument is invalid.");
                                }
                            }
                        }else{ //invalid player
                            System.out.println("§3§lSN§r§cR §3§l>§r§c You have to run this on a player with that many arguments.");
                        }
                }else if(args.length == 3){
                    //cmd 1 2 3
                    //target number silent
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if(t instanceof Player){
                        if(ArgNumbCheckUtil.isInt(args[1])){
                            if(args[2].equalsIgnoreCase("-s")){
                                //silent specified
                                int varMount = Integer.parseInt(args[1]);
                                t.damage(varMount);
                            }else{//3 args but 3rd isnt -s
                                System.out.println("§3§lSN§r§cR §3§l>§r§c You have too many arguments, use -s as your third argument to make it silent.");
                            }
                        }else{//3 args but 2nd isn't number
                            System.out.println("§3§lSN§r§cR §3§l>§r§c The 2nd argument has to be a number.");
                        }
                    }else if(args[0].equalsIgnoreCase("@a") || args[0].equalsIgnoreCase("*")){
                        for(Player ps : Bukkit.getOnlinePlayers()){
                            if(ArgNumbCheckUtil.isInt(args[1])){
                                if(args[2].equalsIgnoreCase("-s")){
                                    //silent specified
                                    int varMount = Integer.parseInt(args[1]);
                                    ps.damage(varMount);
                                }else{//3 args but 3rd isnt -s
                                    System.out.println("§3§lSN§r§cR §3§l>§r§c You have too many arguments, use -s as your third argument to make it silent.");
                                }
                            }else{//3 args but 2nd isn't number
                                System.out.println("§3§lSN§r§cR §3§l>§r§c The 2nd argument has to be a number.");
                            }
                        }
                    }else{ // non player target
                        System.out.println("§3§lSN§r§cR §3§l>§r§c You have to run this on a player with that many arguments.");
                    }
                }else{ //too many arguments
                    System.out.println("§3§lSN§r§cR §3§l>§r§c Too many arguments.");
                }

            }
        }
    return true;
    }
}

