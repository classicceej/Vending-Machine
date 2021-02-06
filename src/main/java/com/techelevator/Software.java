package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import java.io.File;
import java.util.Scanner;

public class Software {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String fileName = "Log.txt";

		File auditFile = new File(fileName);
		

		VendingMachine thisMachine = new VendingMachine();

		// Main Menu()
		Boolean mainMenu = true;
		// Display Vending Machine Items

		while (mainMenu) {
			System.out.println("\nMake a selection: ");
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");

			String response1 = keyboard.nextLine();

			if (response1.contains("1")) {
				thisMachine.DisplayVendingMachineItems();
				// RETURN TO MAIN MENU
			} else if (response1.contains("2")) {
				Boolean purchaseMenu = true;
				while (purchaseMenu) {
					System.out.println("\nMake a selection: ");
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Product");
					System.out.println("(3) Finish Transaction");
					System.out.println(thisMachine.getCurrentMoneyProvided());

					String response2 = keyboard.nextLine();

					if (response2.contains("1")) {
						// Feed Money
						Boolean feeding = true;
						while (feeding) {
							System.out.println("\nEnter cash: ");
							int moneyIn = Integer.parseInt(keyboard.nextLine());

							thisMachine.setFedMoney(moneyIn);

							thisMachine.feedMoney();
							System.out
									.println("There is $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()) + " in the machine");

							System.out.println("Enter more?  Y/N ");
							String responseFeeding = keyboard.nextLine();

							if (responseFeeding.toUpperCase().contains("N")) {
								feeding = false;

								// LOG myDT + FEED MONEY: + moneyIn(".00") + CMP
							}
						}
					} else if (response2.contains("2")) {

						// Select Product
						for (String k : thisMachine.getContents().getStock().keySet()) {
							Slot v = thisMachine.getContents().getStock().get(k);
							System.out.println(k + "\t" + v.getSlotItem().getName());
						}
						System.out.println("\nEnter a Selection: ");
						String selection = keyboard.nextLine();
						if (!thisMachine.getContents().getStock().containsKey(selection.toUpperCase())) {
							System.out.println("That is not a valid key");
						} else if (thisMachine.getContents().getStock().get(selection.toUpperCase()).isSoldOut()) {
							System.out.println("That item is currently out of stock");
						} else {
							if (thisMachine.getCurrentMoneyProvided() >= thisMachine.getContents().getStock()
									.get(selection.toUpperCase()).getSlotItem().getPrice()) {

								// LOG myDT + selectionname + selection + cmp

								BigDecimal X = BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided());
								X = (X.subtract(BigDecimal.valueOf(thisMachine.getContents().getStock()
										.get(selection.toUpperCase()).getSlotItem().getPrice())));
								thisMachine.setCurrentMoneyProvided(X.doubleValue());

								// LOG new CMP same line

								System.out.println(thisMachine.getContents().getStock().get(selection.toUpperCase())
										.getSlotItem().getName() + "\t"
										+ thisMachine.getContents().getStock().get(selection.toUpperCase())
												.getSlotItem().getPrice());
								System.out.println(thisMachine.getCurrentMoneyProvided());
								System.out.println(thisMachine.getContents().getStock().get(selection.toUpperCase())
										.getSlotItem().getMessage());

								int newQuant = thisMachine.getContents().getStock().get(selection.toUpperCase())
										.getSlotItem().getQuantity() - 1;
								thisMachine.getContents().getStock().get(selection.toUpperCase()).getSlotItem()
										.setQuantity(newQuant);

								if (thisMachine.getContents().getStock().get(selection.toUpperCase()).getSlotItem()
										.getQuantity() == 0) {
									thisMachine.getContents().getStock().get(selection.toUpperCase()).setSoldOut(true);
								}

								// ADD TO LOG

							} else {
								System.out.println("You don't have enough money for that selection!");

							}

						}
					} else if (response2.contains("3")) {

						// LOG myDT + GIVE CHANGE: + BigDecimal(CMP) + $0.00
						BigDecimal Q = new BigDecimal("0.25");
						BigDecimal D = new BigDecimal("0.10");
						BigDecimal N = new BigDecimal("0.05");
						int countQ = 0;
						int countD = 0;
						int countN = 0;

						try (PrintWriter pw = new PrintWriter(fileName)) {
							System.out.println();
						} catch (IOException e) {
							System.out.println("Could not open file.");
						}

						while ((Q.compareTo(BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided())) <= 0)) {
							BigDecimal newVal = BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()).subtract(Q);
							thisMachine.setCurrentMoneyProvided(newVal.doubleValue());
							countQ++;
						}
						while ((D.compareTo(BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided())) <= 0)) {
							BigDecimal newVal = BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()).subtract(D);
							thisMachine.setCurrentMoneyProvided(newVal.doubleValue());
							countD++;
						}
						while ((N.compareTo(BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided())) <= 0)) {
							BigDecimal newVal = BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()).subtract(N);
							thisMachine.setCurrentMoneyProvided(newVal.doubleValue());
							countN++;
						}

						System.out.println("Your change is: \n" + countQ + " Quarters!\n" + countD + " Dimes!\n"
								+ countN + " Nickles!");

						purchaseMenu = false;
					}
				}

			} else if (response1.contains("3")) {
				System.exit(0);
			} else if (response1.contains("4")) {
				// PRINT ACCOUNT LOGS
				// PRINT AUDIT
			}

		}
	}

}
