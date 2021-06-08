package io.github.minigameplugin.main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Start {
	
	public static void teleport() {
		//Teleports players to set locations
		ArrayList<Location> locations = new ArrayList<Location>();
		locations.add(world,10,70,10);
		locations.add(world,13,70,10);
		locations.add(world,15,70,10);
		locations.add(world,12,70,10);
		Collection<Player> players = Bukkit.getOnlinePlayers();
		for(Player : players) {
			players.get(i).teleport(locations.get(i));
		}
		
	}
	
	public static void immobilize() {
		
		//immobilizes players for 5 seconds, and timer goes down from 5 in chat
	}
	
	public static void tntdrop() {
		//drop tnt
	}
}

