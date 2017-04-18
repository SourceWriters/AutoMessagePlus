package de.yellowphoenix18.automessageplus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.yellowphoenix18.automessageplus.utils.PluginUtils;

public class AutoMessagePlus extends JavaPlugin {
	
	public static AutoMessagePlus m;
	
	public void onEnable() {
		m = this;
		PluginUtils.setUp();
	}
	
	public void onDisable() {
		Bukkit.getScheduler().cancelTask(PluginUtils.messager);
	}

}
