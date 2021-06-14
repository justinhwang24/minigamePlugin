package io.github.minigameplugin.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Reset {
	
	public static void original(Player player) {
		//reset player hp, removes blocks, etc.
		player.setHealth(20);
	}
	
	public static void returnTp() {
		//returns players back to glass platform
		ArrayList<Location> locations = new ArrayList<Location>();
		World world = null;
		for(Player p : Bukkit.getOnlinePlayers()) {
			world = p.getWorld();
			break;
		}
		Location l = new Location(world,0,107,0);
		locations.add(l);

		int i = 0;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(locations.get(i));
			i++;
		}
	}
	
}
