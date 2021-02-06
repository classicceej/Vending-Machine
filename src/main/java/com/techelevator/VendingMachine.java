package com.techelevator;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {

	private Inventory contents;
	private double currentMoneyProvided = 0;
	private double change = 0;
	private Customer user;
	private double balance = 0;

	public VendingMachine() {
		this.contents = new Inventory();

	}

	public void returnChange() {
		currentMoneyProvided = 0;
		change = 0;
		// Change must be dispensed in smallest amount of coins
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

	public void DisplayVendingMachineItems() {
		for (String k : getContents().getStock().keySet()) {
			Slot v = getContents().getStock().get(k);
			if (v.isSoldOut()) {
				System.out.print(v.getSlotItem().getName() + "\t" + v.getSlotItem().getName() + " IS SOLD OUT!" + "\n");
			} else {
				System.out.print(v.getSlotItem().getName() + "\t" + v.getSlotItem().getQuantity() + "\n");
			}
		}
	}

	public Customer getUser() {
		return user;
	}

	public void feedMoney() {
		double addedMoney = 0;

		balance += addedMoney;

	}

	public double getBalance() {
		return balance;
	}

	public void giveChange() {
		Double[] change = new Double[] { 0.25, 0.10, 0.05 };
		String[] coinName = new String[] { "Quarter(s)", "Dime(s)", "Nickle(s)" };
		for (int i = 0; i < change.length; i++) {
			int counter;
			counter = (int) (balance / change[i]);

			balance -= (change[i] * counter);
			System.out.println(counter + " " + coinName[i]);
		}
	}
}