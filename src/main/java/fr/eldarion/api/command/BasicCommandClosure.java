package fr.eldarion.api.command;

import org.bukkit.command.CommandSender;

public interface BasicCommandClosure {

	public void commandClosure(CommandSender sender, String argName, String[] args);
	
}
