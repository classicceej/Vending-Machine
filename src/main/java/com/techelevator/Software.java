package com.techelevator;

import java.math.BigDecimal;
//import java.io.File;
import java.util.Scanner;

public class Software {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		VendingMachine thisMachine = new VendingMachine();

		System.out.println("Make a selection: ");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");

		String response1 = keyboard.nextLine();

		if (response1.contains("1")) {
			thisMachine.DisplayVendingMachineItems();
			// RETURN TO MAIN MENU
		} else if (response1.contains("2")) {
			System.out.println("Make a selection: ");
			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			System.out.println(thisMachine.getCurrentMoneyProvided());

			String response2 = keyboard.nextLine();

			if (response2.contains("1")) {
				// Feed Money
				Boolean feeding = true;
				while (feeding) {
					System.out.println("Enter cash: ");
					int moneyIn = Integer.parseInt(keyboard.nextLine());

					thisMachine.setFedMoney(moneyIn);

					thisMachine.feedMoney();
					System.out.println("There is $" + thisMachine.getCurrentMoneyProvided() + " in the machine");

					System.out.println("Enter more?  Y/N ");
					String responseFeeding = keyboard.nextLine();

					if (responseFeeding.toUpperCase().contains("N")) {
						feeding = false;
						// RETURN TO PURCHASING MENU
					}
				}
			} else if (response2.contains("2")) {

				// Select Product
				for (String k : thisMachine.getContents().getStock().keySet()) {
					Slot v = thisMachine.getContents().getStock().get(k);
					System.out.println(k + "\t" + v.getSlotItem().getName());
				}
				System.out.println("Enter a Selection: ");
				String selection = keyboard.nextLine();
				if (!thisMachine.getContents().getStock().containsKey(selection)) {
					System.out.println("That is not a valid key");
					// WE HAVE TO RETURN THEM TO THE PURCHASE MENU
				} else if (thisMachine.getContents().getStock().get(selection).isSoldOut()) {
					System.out.println("That item is currently out of stock");
					// WE HAVE TO RETURN THEM TO THE PURCHASE MENU
				} else {
					if (thisMachine.getCurrentMoneyProvided() >= thisMachine.getContents().getStock().get(selection)
							.getSlotItem().getPrice()) {
						double x = thisMachine.getCurrentMoneyProvided();
						x -= thisMachine.getContents().getStock().get(selection).getSlotItem().getPrice();
						thisMachine.setCurrentMoneyProvided(x);

						System.out.println(thisMachine.getContents().getStock().get(selection).getSlotItem().getName()
								+ thisMachine.getContents().getStock().get(selection).getSlotItem().getPrice());
						System.out.println(thisMachine.getCurrentMoneyProvided());
						System.out.println(
								thisMachine.getContents().getStock().get(selection).getSlotItem().getMessage());

						int newQuant = thisMachine.getContents().getStock().get(selection).getSlotItem().getQuantity()
								- 1;
						thisMachine.getContents().getStock().get(selection).getSlotItem().setQuantity(newQuant);

						if (thisMachine.getContents().getStock().get(selection).getSlotItem().getQuantity() == 0) {
							thisMachine.getContents().getStock().get(selection).setSoldOut(true);
						}
						// QUANTITY
						// ADD TO LOG
						// RETURN TO PURCHASE MENU

					} else {
						System.out.println("You don't have enough money for that selection!");
						// WE HAVE TO RETURN THEM TO THE PURCHASE MENU
					}

				}
			} else if (response2.contains("3")) {
				BigDecimal Q = new BigDecimal("0.25");
				BigDecimal D = new BigDecimal("0.10");
				BigDecimal N = new BigDecimal("0.05");
				int countQ = 0;
				int countD = 0;
				int countN = 0;

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

				System.out.println(
						"Your change is: \n" + countQ + " Quarters!\n" + countD + " Dimes!\n" + countN + " Nickles!");
			}

		} else if (response1.contains("3")) {
			System.exit(0);
		} else if (response1.contains("4")) {
			// PRINT ACCOUNT LOGS
			// PRINT AUDIT
		}

	}

}
