package io.github.minigameplugin.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//startup
		//reloads
		//plugin reloads
		//register events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinEvents(), this);
	}
	
	@Override
	public void onDisable() {
		//shutdown
		//reloads
		//plugin reloads
	}
}
