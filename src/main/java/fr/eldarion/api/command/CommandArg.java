package fr.eldarion.api.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eldarion.api.storage.PluginConfig;

public class CommandArg {

	private String argName;
	private BasicCommandClosure closure;
	private boolean ignoreCase;
	private boolean playerOnly;
	
	
	public CommandArg(String argsName, BasicCommandClosure closure) {
		this(argsName, closure, true);
	}
	
	public CommandArg(String argsName, BasicCommandClosure closure, boolean ignoreCase) {
		this.argName = argsName;
		this.closure = closure;
		this.ignoreCase = ignoreCase;
	}
	
	public CommandArg(String argsName, BasicCommandClosure closure, boolean ignoreCase, boolean playerOnly) {
		this.argName = argsName;
		this.closure = closure;
		this.ignoreCase = ignoreCase;
		this.playerOnly = playerOnly;
	}
	
	
	public String getArgName() {
		return this.argName;
	}
	
	public boolean ignoreCase() {
		return this.ignoreCase;
	}
	
	
	public void execute(PluginConfig config, CommandSender sender, String[] args) {
		if(this.playerOnly && !(sender instanceof Player)) {
			sender.sendMessage(config.getOnlyPlayerMessage());
			return;
		}
		
		this.closure.commandClosure(sender, argName, args);
	}
	
}
