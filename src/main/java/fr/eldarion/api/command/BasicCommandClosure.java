package fr.eldarion.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface BasicCommandClosure {

	public boolean commandClosure(CommandSender sender, Command command, String label, String[] args);
	
}
