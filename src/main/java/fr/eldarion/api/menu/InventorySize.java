package fr.eldarion.api.menu;

public enum InventorySize {
	ONE_ROW(9),
	TWO_ROW(18),
	THREE_ROW(27),
	FOUR_ROW(36),
	FIVE_ROW(45),
	SIX_ROW(54);

	
	private int value;
	
	public int value() {
		return this.value;
	}
	
	InventorySize(int value) {
		this.value = value;
	}
}
