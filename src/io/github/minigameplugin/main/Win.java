package io.github.minigameplugin.main;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Win {

    public static void checkForWin() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	if (Start.alive.size() == 1) {
	    	//Prints name of last player alive
    		for (Player p : Bukkit.getOnlinePlayers()) {
    			p.sendMessage(ChatColor.AQUA + Start.alive.get(0).getName() + " won the game!");
    			p.setGameMode(GameMode.ADVENTURE);
		    	Reset.original(p);
    		}
	    	Start.started = false;
	    	Reset.returnTp();
		}
    }
}