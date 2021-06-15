package io.github.minigameplugin.main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Death implements Listener {
	// list of alive players
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) throws InterruptedException {
		if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (Start.alive.contains(p)) {
	            if (e.getDamage() >= p.getHealth()) {
	            	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_DEATH, 10, 1);
	            	Start.alive.remove(p);
	            	p.setGameMode(GameMode.SPECTATOR);
	            	p.sendMessage(ChatColor.RED + "You have been hit by TNT!");
	            	p.teleport(new Location(p.getWorld(), 10, 50, 10));
	            	Win.checkForWin();
	            }
            }
        }
	}
	
	@EventHandler
	public void onLeaveEvent(PlayerQuitEvent e) throws InterruptedException {
		Win.checkForWin();
	}
}
