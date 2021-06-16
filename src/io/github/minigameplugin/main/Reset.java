package io.github.minigameplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Reset {
	
	public static void returnTp() {
		//returns players back to glass platform
		World world = Bukkit.getWorld("world");
		Location l = new Location(world,0,107,0);
		
		
		//resets health when death occurs and teleports player as well
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setHealth(20);
			p.teleport(l);
		}
	}
}
