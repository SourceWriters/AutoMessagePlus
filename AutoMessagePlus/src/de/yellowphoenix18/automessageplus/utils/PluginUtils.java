package de.yellowphoenix18.automessageplus.utils;

import java.util.Random;

import org.bukkit.Bukkit;

import de.yellowphoenix18.automessageplus.AutoMessagePlus;
import de.yellowphoenix18.automessageplus.commands.AutoMessagePlusCommand;
import de.yellowphoenix18.automessageplus.config.MainConfig;

public class PluginUtils {
	
	public static int messager;
	
	public static void setUp() {
		loadConfigs();
		loadCommands();
		loadListener();
		postMessages();
	}
	
	public static void loadCommands() {
		AutoMessagePlus.m.getCommand("amp").setExecutor(new AutoMessagePlusCommand());
	}
	
	public static void loadListener() {
		
	}
	
	public static void loadConfigs() {
		MainConfig.load();
	}
	
	public static void postMessages() {
		messager = Bukkit.getScheduler().scheduleSyncRepeatingTask(AutoMessagePlus.m, new Runnable() {
			@Override
			public void run() {
				Random rnd = new Random();
				if(MainConfig.messages.size() > 0) {
					int message = rnd.nextInt(MainConfig.messages.size());
					Bukkit.broadcastMessage(MainConfig.prefix + MainConfig.messages.get(message).replace("&", "§"));
				}
			}		
		}, 15, MainConfig.message_time*20);
	}

}
