package com.techelevator;

public class VendingMachine {
	private Inventory contents;
	private double currentMoneyProvided = 0;
	private int fedMoney = 0;
	private double change = 0;
	private Customer user;
	
	public VendingMachine(){
		this.contents = new Inventory();
		
	}
	
	
	public void returnChange(){
		currentMoneyProvided = 0;
		change = 0;
		//Change must be dispensed in smallest amount of coins
	}
	
//	public void feedMoney() {
//		
//	}
	
	
	public void setCurrentMoneyProvided(double currentMoneyProvided) {
		this.currentMoneyProvided = currentMoneyProvided;
	}


	public void feedMoney() {
		currentMoneyProvided += getFedMoney();
	}

	
	public int getFedMoney() {
		return fedMoney;
	}


	public void setFedMoney(int fedMoney) {
		this.fedMoney = fedMoney;
	}


	public void DisplayVendingMachineItems(){
		for (String k : getContents().getStock().keySet()) {
			Slot v = getContents().getStock().get(k);
			if (v.isSoldOut()) {
				System.out.print(v.getSlotItem().getName() + "\t\t" + v.getSlotItem().getName() + " IS SOLD OUT!" + "\n");
			} else {
				System.out.print(v.getSlotItem().getName() + "\t\t" + v.getSlotItem().getQuantity() + "\n");
			}
		}
	}


	public Customer getUser() {
		return user;
	}
	public Inventory getContents() {
		return contents;
	}
	public double getCurrentMoneyProvided() {
		return currentMoneyProvided;
	}
	public double getChange() {
		return change;
	}
	
}

