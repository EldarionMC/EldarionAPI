package fr.eldarion.api.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackCreator {

	public static ItemStack getItemStack(Material material, String name, List<String> lore, boolean unbreakable, int customModelData, List<ItemFlag> flags, HashMap<Enchantment, Integer> enchantments, HashMap<Attribute, AttributeModifier> attributes) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(name);
		meta.setLore(lore);
		meta.setUnbreakable(unbreakable);
		if(customModelData != -1) meta.setCustomModelData(customModelData);
		
		for(ItemFlag flag : flags) {
			meta.addItemFlags(flag);
		}
		
		for(Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			meta.addEnchant(entry.getKey(), entry.getValue(), true);
		}
		
		for(Map.Entry<Attribute, AttributeModifier> entry : attributes.entrySet()) {
			meta.addAttributeModifier(entry.getKey(), entry.getValue());
		}
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack getItemStack(Material material, String name, List<String> lore, boolean unbreakable, int customModelData, List<ItemFlag> flags, HashMap<Enchantment, Integer> enchantments) {
		return getItemStack(material, name, lore, unbreakable, customModelData, flags, enchantments, new HashMap<Attribute, AttributeModifier>());
	}
	
	public static ItemStack getItemStack(Material material, String name, List<String> lore, boolean unbreakable, int customModelData, List<ItemFlag> flags) {
		return getItemStack(material, name, lore, unbreakable, customModelData, flags, new HashMap<Enchantment, Integer>(), new HashMap<Attribute, AttributeModifier>());
	}
	
	public static ItemStack getItemStack(Material material, String name, List<String> lore, boolean unbreakable, int customModelData) {
		return getItemStack(material, name, lore, unbreakable, customModelData, new ArrayList<>(), new HashMap<Enchantment, Integer>(), new HashMap<Attribute, AttributeModifier>());
	}
	
	public static ItemStack getItemStack(Material material, String name, List<String> lore, boolean unbreakable) {
		return getItemStack(material, name, lore, unbreakable, -1, new ArrayList<>(), new HashMap<Enchantment, Integer>(), new HashMap<Attribute, AttributeModifier>());
	}
	
	public static ItemStack getItemStack(Material material, String name, List<String> lore) {
		return getItemStack(material, name, lore, false, -1, new ArrayList<>(), new HashMap<Enchantment, Integer>(), new HashMap<Attribute, AttributeModifier>());
	}
	
	public static ItemStack getItemStack(Material material, String name) {
		return getItemStack(material, name, null, false, -1, new ArrayList<>(), new HashMap<Enchantment, Integer>(), new HashMap<Attribute, AttributeModifier>());
	}
	
	
	public static ItemStack getItemStackWithoutName(Material material) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(" ");
		
		item.setItemMeta(meta);
		return item;
	}
}
