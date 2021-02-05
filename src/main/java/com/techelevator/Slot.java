package com.techelevator;

public class Slot {

	private Item slotItem;
	private boolean SoldOut = false;
	
	
	
	public Slot(Item slotItem) {
		this.slotItem = slotItem;
	}


	public void sellOut() {
		if(getSlotItem().getQuantity() == 0) {
			SoldOut = true; //wrong
		}
	}
	
	
	public Item getSlotItem() {
		return slotItem;
	}
	public boolean isSoldOut() {
		return SoldOut;
	}
	
	
	
}
