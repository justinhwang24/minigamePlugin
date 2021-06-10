package io.github.minigameplugin.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;


//Disables tnt environmental damage, but still damages players
public class Explosion implements Listener {
	@EventHandler
	public void onEntityExplodeEvent(final EntityExplodeEvent e) {
		e.blockList().clear();
        e.setCancelled(true);
	}
	public void onBlockExplodeEvent(final BlockExplodeEvent e) {
		e.blockList().clear();
        e.setCancelled(true);
	}
}
