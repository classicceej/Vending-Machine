package com.techelevator;

public class Slot {

	private Item slotItem;
	private boolean SoldOut = false;
	
	
	
	public Slot(Item slotItem) {
		this.slotItem = slotItem;
	}

	
	
	public Item getSlotItem() {
		return slotItem;
	}
	public boolean isSoldOut() {
		return SoldOut;
	}

	public void setSoldOut(boolean soldOut) {
		this.SoldOut = true;
	}

	
}
