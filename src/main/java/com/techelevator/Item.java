package com.techelevator;

//import java.math.BigDecimal;

public abstract class Item {

	private String name;
	private double price;  //This may have to change to BigDecimal at some point
	private String message;
	private int quantity = 5;
	private int count = 0; 
	private String slot;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void countUp() {
		count++;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public int getQuantity() {
		return quantity;
	}

	public String getSlot() {
		return slot;
		
		
	}

	
	public int getCount() {
		return count;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
