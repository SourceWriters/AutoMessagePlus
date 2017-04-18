package de.yellowphoenix18.automessageplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.yellowphoenix18.automessageplus.config.MainConfig;

public class AutoMessagePlusCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("automessageplus.*") || p.hasPermission("automessageplus.help")) {
					p.sendMessage(MainConfig.prefix + "§7For help enter §c/amp help");
				} else {
					p.sendMessage(MainConfig.prefix + MainConfig.not_allowed);
				}
			} else {
				if(args[0].equalsIgnoreCase("help")) {
					if(p.hasPermission("automessageplus.*") || p.hasPermission("automessageplus.help")) {
						p.sendMessage("§7» §bAuto§3Message§6Plus §7«");
						p.sendMessage("§6/amp help §8- §7Shows the help for AutoMessagePlus");
						p.sendMessage("§6/amp list §8- §7Shows all Messages");
						p.sendMessage("§6/amp add <Message> §8- §7Add a new Message to MessagePool");
						p.sendMessage("§7» §bAuto§3Message§6Plus §7«");
					} else {
						p.sendMessage(MainConfig.prefix + MainConfig.not_allowed);
					}
				} else if(args[0].equalsIgnoreCase("list")) {
					if(p.hasPermission("automessageplus.*") || p.hasPermission("automessageplus.list")) {
						p.sendMessage("§7» §bAuto§3Message§6Plus §7«");
						for(String message : MainConfig.messages) {
							p.sendMessage("§8- " + message.replace("&", "§"));
						}
						p.sendMessage("§7» §bAuto§3Message§6Plus §7«");
					} else {
						p.sendMessage(MainConfig.prefix + MainConfig.not_allowed);
					}
				} else if(args[0].equalsIgnoreCase("add")) {
					if(p.hasPermission("automessageplus.*") || p.hasPermission("automessageplus.add")) {
						if(args.length >= 2) {
							String message = "";
							int i = 1;
							while(args.length > i) {
								message = message + args[i] + " ";
								i++;
							}
							MainConfig.addMessage(message);
							p.sendMessage(MainConfig.prefix + "§7Message has §asuccessfully §7been added to Message-Pool");
						} else {
							p.sendMessage(MainConfig.prefix + "§7Please use §c/amp add <Message>");
						}
					} else {
						p.sendMessage(MainConfig.prefix + MainConfig.not_allowed);
					}
				}
			}
		} else {
			System.out.println("[AutoMessagePlus] Only Players can use this command");
		}
		
		return true;
	}

}
