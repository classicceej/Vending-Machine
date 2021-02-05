package com.techelevator;

//import java.io.File;
import java.util.Scanner;

public class Software {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		
		
		Scanner scan = new Scanner(System.in);
        while (true) {
        	System.out.println("(1) Display Vending Machine Items (2) Purchases (3) Exit ");
        	int userInput = scan.nextInt();
        	
        	if (userInput == 1) {    //displaying
        		//for(String s : );   put the list of items to s
        		System.out.println(s);
        		
        		if (userInput == 3 ) {// exit the application
        			System.exit(0);
        		}
        		
        		if (userInput == 4) {
        			//software.printsalesreport
        		}
        		
        		    if(userInput == 2) {  //Purchases
        			System.out.println("(1) Feed Money > (2) Select Product >(3) Finish Transaction");
        			int inputNumber = scan.nextInt();
        			
        			     if (inputNumber == 1) {  // purchases option 1 Feed money
        			    	 System.out.println("Please Select the amonut of Dollar");
        			    	 int amount = scan.nextInt();
        			    	 int balance;
        			    	 balance += amount /100;
        			    	 System.out.println ("Current Money provided: $" + amount);
        			    	 
        			     }
        			     
        			     if (inputNumber == 2) {// purchases option 2 Select product displays list of items
        			    	 System.out.println("Enter your Selection");
        			    	 
        			     }
        			     
        			     if (inputNumber == 3) {
        			    	 System.out.println("Your Change is:") ;//provide change to user and complete the transaction
        			     }
        			
        		}
        	}
        }
=======

		Scanner keyboard = new Scanner(System.in);

		VendingMachine thisMachine = new VendingMachine();

		// Main Menu()

		// Display Vending Machine Items

		thisMachine.DisplayVendingMachineItems();

		// Purchase
		// to purchase menu

		// Exit
		// exit(0)

		// Purchase Menu()

		// Feed Money
		// Take money as int from bank account
		// add that money to cmp

		// Select Product

		// Show MAP key and values
		// Take a response
		// if response valid print name, price, cmp - price >>> quantity -1 >>> print
		// message >>> audit >>> return to main
		// if not valid return to main menu

		// Finish Transaction
		// Return Change using smallest amount of coins possible
		// CMP = 0
		// Return to Main

>>>>>>> 7fd032507260bf58d5e0aa7b5f9aa53f8966107b
	}

}
