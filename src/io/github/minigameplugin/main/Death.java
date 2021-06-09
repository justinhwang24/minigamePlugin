package io.github.minigameplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Death {
	public int alive = 0;
	public static void deathLoop() {
		//amount of alive players
		Player player = player.getPlayer();
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(player.isDead()==false) {
				alive++;
			}
		}
	}
}
