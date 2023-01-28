package fr.eldarion.api.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicCommand implements CommandExecutor {	
	private String commandName;
	private List<CommandArg> commandArgs;
	private boolean ignoreCase;
	
	
	public BasicCommand(JavaPlugin instance, String commandName) {
		this(instance, commandName, true);
	}
	
	public BasicCommand(JavaPlugin instance, String commandName, boolean ignoreCase) {
		this.commandName = commandName;
		this.commandArgs = new ArrayList<>();
		this.ignoreCase = ignoreCase;
		
		instance.getCommand(commandName).setExecutor(this);
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if((this.ignoreCase && command.getName().equalsIgnoreCase(this.commandName)) || (!this.ignoreCase && command.getName().equals(this.commandName))) {
			if(args.length >= 1) {
				for(CommandArg arg : this.commandArgs) {
					if((arg.ignoreCase() && arg.getArgName().equalsIgnoreCase(args[0])) || (!arg.ignoreCase() && arg.getArgName().equals(args[0]))) {
						arg.execute(sender, Arrays.copyOfRange(args, 1, args.length));
						break;
					}
				}
			}
			
			System.out.println("test: true");
			return true;
		}

		return false;
	}
	
	
	public void addArgument(CommandArg arg) {
		this.commandArgs.add(arg);
	}

}
