package fr.eldarion.api.command;

import org.bukkit.command.CommandSender;

public class CommandArg {

	private CommandSender sender;
	private String argName;
	private String[] args;
	private BasicCommandClosure closure;
	private boolean ignoreCase;
	
	
	public CommandArg(CommandSender sender, String argsName, String[] args, BasicCommandClosure closure) {
		this(sender, argsName, args, closure, true);
	}
	
	public CommandArg(CommandSender sender, String argsName, String[] args, BasicCommandClosure closure, boolean ignoreCase) {
		this.sender = sender;
		this.argName = argsName;
		this.args = args;
		this.closure = closure;
		this.ignoreCase = ignoreCase;
	}
	
	
	public String getArgName() {
		return this.argName;
	}
	
	public boolean ignoreCase() {
		return this.ignoreCase;
	}
	
	
	public void execute() {
		this.closure.commandClosure(sender, argName, args);
	}
	
}
