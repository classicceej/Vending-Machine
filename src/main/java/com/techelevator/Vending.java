package com.techelevator;

public class Vending {
	private Inventory vendingMachine;
	private double currentMoneyProvided = 0;
	private double change = 0;
	private Customer user;
	
	
	
	
	
	
	public void returnChange(){
		currentMoneyProvided = 0;
		change = 0;
	}
	
	
	
	
	
	
	
	
	public Inventory getVendingMachine() {
		return vendingMachine;
	}
	public double getCurrentMoneyProvided() {
		return currentMoneyProvided;
	}
	public double getChange() {
		return change;
	}
	
}
