package io.github.minigameplugin.main;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Start {
	// map boundaries
	static int x1 = 47;
	static int x2 = -50;
	static int z1 = 51;
	static int z2 = -48;
	static int y = 50;
	static boolean started = false;
	// list of alive players
	public static ArrayList<Player> alive = new ArrayList<Player>();
	
	public static void start() {
		alive.clear();
		started = true;
		for (Player p : Bukkit.getOnlinePlayers()) {
			alive.add(p);
			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 10);
		}

		for (Player p : Bukkit.getOnlinePlayers()) {
			GameScoreboard.updateScoreboard(p);
		}
		teleport();
		tntDrop();
	}
	
	public static void teleport() {
		// teleports players to set locations
		for (Player p : Bukkit.getOnlinePlayers()) {
			Location l = new Location(p.getWorld(), 10, 10, 10);
			p.teleport(l);
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
		start();
	}
	
	public static void tntDrop() {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				if (!started)
					cancel();
				
				World world = Bukkit.getWorld("world");
				int randomX = (int) (Math.random() * (x2 - x1)) + x1;
				int randomZ = (int) (Math.random() * (z2 - z1)) + z1;
				
				Location loc = new Location(world, randomX, y, randomZ);
				world.spawnEntity(loc, EntityType.PRIMED_TNT);
			}
		}.runTaskTimer(Main.instance, 0L, 1L);
	}
	
	public static void checkForWin() throws InterruptedException {
    	if (alive.size() == 1) {
	    	// Prints name of last player alive
    		for (Player p : Bukkit.getOnlinePlayers()) {
    			p.sendTitle(ChatColor.YELLOW + Start.alive.get(0).getName(), ChatColor.YELLOW + " has won the game", 20, 50, 20);
    			p.sendMessage(ChatColor.AQUA + Start.alive.get(0).getName() + " has won the game!");
    			p.setGameMode(GameMode.ADVENTURE);
    			p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 10, 1);
    		}
	    	Start.started = false;
			TimeUnit.SECONDS.sleep(1);
	    	Reset.returnTp();
		}
    }
}

