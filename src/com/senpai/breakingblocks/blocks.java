package com.senpai.breakingblocks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class blocks implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(!Main.activ) {
			Main.activ = true;
			arg0.sendMessage(Main.PLUGINNAME + " Wurde aktiviert!");
		} else {
			Main.activ = false;
			arg0.sendMessage(Main.PLUGINNAME + " Wurde deaktiviert!");
		}
		
		return true;
	}
	
	

}
