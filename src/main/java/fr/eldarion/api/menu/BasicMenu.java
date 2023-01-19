package fr.eldarion.api.menu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class BasicMenu {

	public void createMenu() {
		
	}
	
	private Inventory createInventory(InventorySize size, String name) {
		Inventory inv = Bukkit.createInventory(null, size.value(), name);
		
		return inv;
	}
	
}
