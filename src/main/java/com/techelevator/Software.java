package com.techelevator;

//import java.io.File;
import java.util.Scanner;

public class Software {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		Inventory thisInventory = new Inventory();
		VendingMachine thisMachine = new VendingMachine();
		System.out.println(thisMachine.getContents().getStock().keySet());
		System.out.println(thisMachine.getContents().getStock());
		
		for(String k : thisMachine.getContents().getStock().keySet()) {
			for(Slot j : thisMachine.getContents().getStock().values()) {
				System.out.println(j.getSlotItem().getQuantity());
				System.out.println(j.getSlotItem().getName());
			}
	
		}

		
		
		
		
	}

}
