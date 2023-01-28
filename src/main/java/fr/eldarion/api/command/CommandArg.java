package fr.eldarion.api.command;

import org.bukkit.command.CommandSender;

public class CommandArg {

	private String argName;
	private BasicCommandClosure closure;
	private boolean ignoreCase;
	
	
	public CommandArg(String argsName, BasicCommandClosure closure) {
		this(argsName, closure, true);
	}
	
	public CommandArg(String argsName, BasicCommandClosure closure, boolean ignoreCase) {
		this.argName = argsName;
		this.closure = closure;
		this.ignoreCase = ignoreCase;
	}
	
	
	public String getArgName() {
		return this.argName;
	}
	
	public boolean ignoreCase() {
		return this.ignoreCase;
	}
	
	
	public void execute(CommandSender sender, String[] args) {
		this.closure.commandClosure(sender, argName, args);
	}
	
}
