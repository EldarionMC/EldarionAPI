package fr.eldarion.api.storage;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class YamlStorage {
	
	private JavaPlugin instance;
	private String fileName;
	
	private File file;
	private FileConfiguration fileConfig;
	
	public YamlStorage(JavaPlugin instance, String fileName) {
		this.instance = instance;
		this.fileName = fileName;
		
		loadYaml();
	}
	
	
	
	private void loadYaml() {
		file = new File(instance.getDataFolder(), fileName + ".yml");
		if(!file.exists()) {
			instance.saveResource(fileName + ".yml", false);
		}
		
		fileConfig = new YamlConfiguration();
		try {
			fileConfig.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public FileConfiguration getYaml() {
		return this.fileConfig;
	}
	
	public void saveYaml() {
		try {
			getYaml().save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
