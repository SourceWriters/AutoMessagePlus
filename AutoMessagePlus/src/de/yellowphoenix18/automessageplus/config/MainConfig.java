package de.yellowphoenix18.automessageplus.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainConfig {
	
	public static File f = new File("plugins/AutoMessagePlus", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static List<String> messages = new ArrayList<String>();
	public static int message_time = 30;
	public static String prefix = "&8[&bAuto&3Message&6Plus&8] &7";
	public static String not_allowed = "&cYoure not allowed to use this command";
	
	public static void load() {
		messages.add("&7Check out our TeamSpeak now!");
		messages.add("&7We have also an very cool Website!");
		
		message_time = setObject("Messages.Time", message_time);
		messages = setObject("Messages.Messages", messages);
		prefix = fixColors(setObject("Global.Prefix", prefix));
		not_allowed = fixColors(setObject("Global.Not-Allowed", not_allowed));
	}
	
	public static void addMessage(String message) {
		messages.add(message);
		cfg.set("Messages.messages", messages);
		save();
	}
	
	public static String fixColors(String code) {
		code = code.replace("&", "§");
		return code;
	}
	
	public static String setObject(String path, String obj) {
		if(cfg.contains(path)) {
			return cfg.getString(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static int setObject(String path, int obj) {
		if(cfg.contains(path)) {
			return cfg.getInt(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static List<String> setObject(String path, List<String> obj) {
		if(cfg.contains(path)) {
			return cfg.getStringList(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
