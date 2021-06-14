package io.github.minigameplugin.main;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;

public class Start {
	// map boundaries TODO
	static int x1 = 47;
	static int x2 = -50;
	static int z1 = 51;
	static int z2 = -48;
	static int y = 30;
	// list of alive players
	static boolean started = false;
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
		Bukkit.broadcastMessage(ChatColor.GREEN + "Starting in 5...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "4...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "3...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "2...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "1...");
		TimeUnit.SECONDS.sleep(1);
		Bukkit.broadcastMessage(ChatColor.GREEN + "Start!");
		alive = (ArrayList<Player>) Bukkit.getOnlinePlayers();
		started = true;
		tntDrop();
	}
	
	public static void tntDrop() {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				if (!started)
					cancel();
				
				World world = Bukkit.getWorld("world");
				int randomX = (int) Math.random() * (x2 - x1) + x1;
				int randomZ = (int) Math.random() * (z2 - z1) + z1;
				
				Location loc = new Location(world, randomX, y, randomZ);
				FallingBlock tnt = (FallingBlock) world.spawnFallingBlock(loc, Material.TNT.createBlockData());
			}
		}.runTaskTimer(Main.instance, 0L, 50L);
	}
}

