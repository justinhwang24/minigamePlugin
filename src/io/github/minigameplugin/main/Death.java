package io.github.minigameplugin.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class Death {
	// list of alive players
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getDamage() >= p.getHealth()) {
            	Start.alive.remove(p);
            	Win.checkForWin();
            }
        }
	}
}
