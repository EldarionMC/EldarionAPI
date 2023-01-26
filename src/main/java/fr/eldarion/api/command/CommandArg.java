package fr.eldarion.api.command;

import org.bukkit.command.CommandSender;

public class CommandArg {

	private String argName;
	private String[] args;
	private BasicCommandClosure closure;
	private boolean ignoreCase;
	
	
	public CommandArg(String argsName, String[] args, BasicCommandClosure closure) {
		this(argsName, args, closure, true);
	}
	
	public CommandArg(String argsName, String[] args, BasicCommandClosure closure, boolean ignoreCase) {
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
	
	
	public void execute(CommandSender sender) {
		this.closure.commandClosure(sender, argName, args);
	}
	
}
