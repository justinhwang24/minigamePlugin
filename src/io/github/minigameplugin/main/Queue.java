package io.github.minigameplugin.main;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Queue implements Listener {
	static ArrayList<Player> list = new ArrayList<Player>();
	//If enough players in queue, run start commands
	
	public static void glassCage(Player p) {
		Location loc = new Location(p.getWorld(), 0, 70, 0); // TODO; insert coords to glass cage
		list.add(p);
		p.teleport(loc);
	}
	
	public void checkIfEnoughPlayers() throws InterruptedException {
		if (list.size() >= 3) { // minimum player limit
			Start.teleport();
			Start.countdown();
			Start.tntDrop();
		}
	}
}
