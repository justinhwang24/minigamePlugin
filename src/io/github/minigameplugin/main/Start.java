package io.github.minigameplugin.main;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.entity.Player;

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
	// list of alive players
	public static ArrayList<Player> alive = new ArrayList<Player>();
	
	public static void teleport() {
		// teleports players to set locations
		int i = 0;
		for (Player p : Bukkit.getOnlinePlayers()) {
			Location l = new Location(p.getWorld(), 10 + i * 5, 70, 10);
			p.teleport(l);
			i++;
		}
		
	}
	public static void countdown() throws InterruptedException {
		//5 second countdown until tnt
		Bukkit.broadcastMessage("Starting in 5...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("4...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("3...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("2...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("1...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage("Start!");
		alive = (ArrayList<Player>) Bukkit.getOnlinePlayers();
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

