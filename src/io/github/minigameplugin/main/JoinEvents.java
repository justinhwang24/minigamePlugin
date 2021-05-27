package io.github.minigameplugin.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
//		Location spawn = new Location();
//		p.teleport(spawn);
	}
}
