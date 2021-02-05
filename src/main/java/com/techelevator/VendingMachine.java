package com.techelevator;
<<<<<<< HEAD
import java.io.File;
import java.util.Scanner;

public class VendingMachine {
     public static void main (String[] args) {
    
    	 
    //Scanner keyboard = new Scanner (System.in);	 
    //File inputFile = new File ("vendingmachine.csv");
    
    
   // while(true) {
    	//Sytsem.out.println ()
   // }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }   	 
     
} 
=======

public class VendingMachine {
	private Inventory contents;
	private double currentMoneyProvided = 0;
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
	
	
	public Inventory getContents() {
		return contents;
	}
	public double getCurrentMoneyProvided() {
		return currentMoneyProvided;
	}
	public double getChange() {
		return change;
	}
	
	public void DisplayVendingMachineItems(){
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
	
}
>>>>>>> 7fd032507260bf58d5e0aa7b5f9aa53f8966107b
