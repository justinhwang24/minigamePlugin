package io.github.minigameplugin.main;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;

public class Start {
	// map boundaries TODO
	static int x1 = 0;
	static int x2 = 0;
	static int z1 = 0;
	static int z2 = 0;
	static int y = 0;
	
	public static void teleport() {
		//tp players to set of locations in arena
		
	}
	
	public static void immobilize() {
		
		//immobilizes players for 5 seconds, and timer goes down from 5 in chat
	}
	
	public static void tntDrop() {
		World world = Bukkit.getWorld("world");
		for (int i = x1; i <= x2; i++) {
			for (int j = z1; j <= z2; j++) {
				Location loc = new Location(world, i, y, j);
				FallingBlock tnt = (FallingBlock) world.spawnFallingBlock(loc, Material.TNT.createBlockData());
			}
		}
	}
}

