package io.github.minigameplugin.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Reset {
	
	public static void original() {
		//reset player hp, removes blocks, etc.
		Player player = player.getPlayer();
		player.setHealth(20);
	}
	
	public static void returnTp() {
		//returns players back to glass platform
		ArrayList<Location> locations = new ArrayList<Location>();
		Player player = player.getPlayer();
		World world = player.getWorld();
		Location l = new Location(world,10,100,10);
		locations.add(l);
		Location l2 = new Location(world,15,100,10);
		locations.add(l2);
		Location l3 = new Location(world,20,100,10);
		locations.add(l3);
		Location l4 = new Location(world,25,100,10);
		locations.add(l4);
		Location l5 = new Location(world,30,100,10);
		locations.add(l5);
		int i = 0;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(locations.get(i));
			i++;
		}
	}
	
}
