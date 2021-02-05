package com.techelevator;

public class VendingMachine {
	private Inventory contents;
	private double currentMoneyProvided = 0;
	private double change = 0;
	private Customer user;
	
	
	
	public void returnChange(){
		currentMoneyProvided = 0;
		change = 0;
	}
	
//	public void feedMoney() {
//		
//	}
	
	
	public Inventory getContents() {
		return contents;
	}
	public double getCurrentMoneyProvided() {
		return currentMoneyProvided;
	}
	public double getChange() {
		return change;
	}


	public Customer getUser() {
		return user;
	}
	
}
