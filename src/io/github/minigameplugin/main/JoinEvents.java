package io.github.minigameplugin.main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.sendTitle(ChatColor.AQUA + "insert name", ChatColor.YELLOW + "Welcome!", 20, 50, 20);
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
		p.setLevel(0);
		
		World world = p.getWorld();
		
<<<<<<< HEAD

		Location loc = new Location(world,0,107,1);

=======
>>>>>>> branch 'master' of https://github.com/justinhwang24/minigamePlugin.git
		Queue.glassCage(p);
<<<<<<< HEAD
		//Location loc = new Location(world,0,107,0);

=======
		Location loc = new Location(world,0,107,0);
>>>>>>> branch 'master' of https://github.com/justinhwang24/minigamePlugin.git
		p.teleport(loc);
		
		if (Start.started && !Queue.list.contains(p))
			p.setGameMode(GameMode.SPECTATOR);
		else
			p.setGameMode(GameMode.ADVENTURE);
		//Add win event
		//Loops through until 1 person alive, then stops
		//run returnTP method
	}
}
