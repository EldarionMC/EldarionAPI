package fr.eldarion.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicCommand implements CommandExecutor {	
	
	private BasicCommandClosure closure;
	
	
	public BasicCommand(JavaPlugin instance, String name, BasicCommandClosure closure) {
		this.closure = closure;
		
		instance.getCommand(name).setExecutor(this);
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return this.closure.commandClosure(sender, command, label, args);
	}

}
