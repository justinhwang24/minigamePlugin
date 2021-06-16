package io.github.minigameplugin.main;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Queue implements Listener {
	static ArrayList<Player> list = new ArrayList<Player>();
	//If enough players in queue, run start commands
	
	//spawns in glass cage using coordinates
	public static void glassCage(Player p) {
		Location loc = new Location(p.getWorld(), 0, 107, 0);
		list.add(p);
		p.teleport(loc);
	}
	
	//tnt run has to have at least 3 players
	public void checkIfEnoughPlayers() throws InterruptedException {
		if (list.size() >= 3) { // minimum player limit
			Start.countdown();
		}
	}
}
