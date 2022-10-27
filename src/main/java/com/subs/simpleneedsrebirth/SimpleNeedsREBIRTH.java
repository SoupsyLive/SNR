package com.subs.simpleneedsrebirth;

import com.subs.simpleneedsrebirth.commands.*;
import com.subs.simpleneedsrebirth.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleNeedsREBIRTH extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        //getServer().getPluginManager().registerEvents(new KillTest(), this);
        getServer().getPluginManager().registerEvents(new ArrowHit(), this);
        getServer().getPluginManager().registerEvents(new SlamTest(), this);
        getCommand("die").setExecutor(new suicide());
        getCommand("heal").setExecutor(new heal());
        getCommand("feed").setExecutor(new feed());
        getCommand("battle").setExecutor(new battle());
        getCommand("hurt").setExecutor(new hurt());
        getCommand("fly").setExecutor(new fly());
        getCommand("gmc").setExecutor(new gmc());
        getCommand("gms").setExecutor(new gms());
        getCommand("gmsp").setExecutor(new gmsp());
        getCommand("gma").setExecutor(new gma());
        getCommand("ci").setExecutor(new clear());
        getCommand("god").setExecutor(new god());
        getCommand("vanish").setExecutor(new vanish());
        getCommand("trash").setExecutor(new trash());
        getCommand("freeze").setExecutor(new freeze());
        getCommand("extinguish").setExecutor(new extinguish());
        getCommand("arrowremove").setExecutor(new arrowremove());
        getCommand("damage").setExecutor(new damage());
        getCommand("blast").setExecutor(new blast());
        getCommand("implode").setExecutor(new implode());
        getCommand("leap").setExecutor(new leap());
        //version: ${project.version}
        System.out.println("§6[§3SN§cR§6] §3loaded.");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("§6[§3SN§cR§6] &Saved.");
    }



}
