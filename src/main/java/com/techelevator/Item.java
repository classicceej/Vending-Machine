package com.techelevator;

//import java.math.BigDecimal;

public abstract class Item {

	private static String name;
	private double price;  //This may have to change to BigDecimal at some point
	private String message;
	private int quantity = 5;
	private String slot;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}


	public static String getName() {
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
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
}