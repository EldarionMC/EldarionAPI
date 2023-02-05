package fr.eldarion.api.menu;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicMenu implements Listener {

	public String title;
	
	private Inventory inventory;
	private BasicMenuClosure closure;
	
	
	
	public BasicMenu(JavaPlugin instance, String title, InventorySize size, BasicMenuClosure closure) {
		this.title = title;
		this.inventory = createInventory(size, title);
		this.closure = closure;
		
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	
	private Inventory createInventory(InventorySize size, String name) {
		Inventory inv = Bukkit.createInventory(null, size.value(), name);
		
		return inv;
	}
	
	
	public void setItem(int slot, ItemStack item) {
		getInventory().setItem(slot, item);
	}
	
	
	@EventHandler
	public void onPlayerInteractInventory(InventoryClickEvent e) {
		if(e.getView().getTitle() == this.getTitle()) {
			e.setCancelled(true);
			
			this.closure.menuClosure(e);
		}
	}
}


















