package fr.eldarion.api.storage;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginConfig extends YamlStorage {

	public PluginConfig(JavaPlugin instance, String fileName) {
		super(instance, fileName);
		
		this.getYaml().set("message.only-player", "§cVous devez être un joueur pour exécuter cette commande");
		
		this.saveYaml();
	}
	
	
	public String getOnlyPlayerMessage() {
		return this.getYaml().getString("message.only-player");
	}

}
