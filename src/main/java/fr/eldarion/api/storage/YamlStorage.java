package fr.eldarion.api.storage;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class YamlStorage {
	
	private JavaPlugin instance;
	private String fileName;
	private String resourceFileName;
	
	private File file;
	private FileConfiguration fileConfig;
	
	public YamlStorage(JavaPlugin instance, String fileName) {
		this(instance, fileName, fileName);
	}
	
	public YamlStorage(JavaPlugin instance, String fileName, String resourceFileName) {
		this.instance = instance;
		this.fileName = fileName;
		this.resourceFileName = resourceFileName;
		
		loadYaml();
	}
	
	
	
	public void set(String path, Object value) {
		fileConfig.set(path, value);
		saveYaml();
	}
	
	
	
	private void loadYaml() {
		file = new File(instance.getDataFolder(), fileName + ".yml");
		if(!file.exists()) {
			instance.saveResource(resourceFileName + ".yml", false);
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
