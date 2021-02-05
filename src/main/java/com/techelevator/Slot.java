package com.techelevator;

public class Slot {

	private Item slotItem;
	private boolean SoldOut = false;
	
	
	
	public Slot(Item slotItem) {
		this.slotItem = slotItem;
	}


	public void sellOut() {
		if(getSlotItem().getQuantity() == 0) {
			SoldOut = true;
		}
	}
	
	
	public Item getSlotItem() {
		return slotItem;
	}
	public boolean isSoldOut() {
		return SoldOut;
	}


	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Object getStock() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
