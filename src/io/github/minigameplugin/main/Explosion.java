package io.github.minigameplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

//Disables tnt environmental damage, but still damages players
public class Explosion implements Listener {
	
	@EventHandler
	public void onEntityExplodeEvent(final EntityExplodeEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.playSound(e.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 1);
		}
		e.blockList().clear();
        e.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockExplodeEvent(final BlockExplodeEvent e) {
		e.blockList().clear();
        e.setCancelled(true);
	}
}
