package com.senpai.breakingblocks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class senpai implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender Sender, Command arg1, String arg2, String[] arg3) {
		Player s = (Player) Sender;
		s.sendTitle(Main.PLUGINNAME, "Made by InteractiveNinja");
		return true;
		
	}

}
