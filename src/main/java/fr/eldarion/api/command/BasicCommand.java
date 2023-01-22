package fr.eldarion.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicCommand implements CommandExecutor {	
	
	private BasicCommandCallback callback;
	
	
	public BasicCommand(JavaPlugin instance, String name, BasicCommandCallback callback) {
		this.callback = callback;
		
		instance.getCommand(name).setExecutor(this);
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return this.callback.commandCallback(sender, command, label, args);
	}

}
