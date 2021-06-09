package io.github.minigameplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Win extends BukkitRunnable {

    private final JavaPlugin plugin;

    public Win(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        // What you want to schedule goes here
        //plugin.getServer().broadcastMessage("Welcome to Bukkit! Remember to read the documentation!");
    	Death.deathLoop();
    	if(alive==1) {
    		//Prints name of last player alive
    		Reset.returnTp();
    		Reset.original();
    	}
    }
},0,2);
