package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Software {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");

		String fileName = "Log.txt";

		File logFile = new File(fileName);

		try (PrintWriter pw = new PrintWriter(logFile)) {
			pw.print("");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		VendingMachine thisMachine = new VendingMachine();
		Boolean mainMenu = true;

		while (mainMenu) {
			System.out.println("\nMake a selection: ");
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");

			String response1 = keyboard.nextLine();

			if (response1.contains("1")) {
				thisMachine.DisplayVendingMachineItems();
			} else if (response1.contains("2")) {
				Boolean purchaseMenu = true;
				while (purchaseMenu) {
					System.out.println("\nMake a selection: ");
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Product");
					System.out.println("(3) Finish Transaction");
					System.out.println(BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()));

					String response2 = keyboard.nextLine();

					if (response2.contains("1")) {

						Boolean feeding = true;
						while (feeding) {
							System.out.println("\nEnter cash: ");
							int moneyIn = Integer.parseInt(keyboard.nextLine());
							// ACCOUNT FOR NULL

							thisMachine.setFedMoney(moneyIn);

							thisMachine.feedMoney();
							System.out.println("There is $"
									+ BigDecimal.valueOf((thisMachine.getCurrentMoneyProvided())) + " in the machine");

							System.out.println("Enter more?  Y/N ");
							String responseFeeding = keyboard.nextLine();

							if (responseFeeding.toUpperCase().contains("N")) {
								feeding = false;

							}

							try (PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {
								pw.print(formatter.format(dateTime) + ":");
								pw.print(" FEED MONEY: ");
								pw.print(" $" + BigDecimal.valueOf(moneyIn));
								pw.print("Total $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()) + "\n");
								pw.flush();

							} catch (FileNotFoundException e2) {

								e2.printStackTrace();
							} catch (IOException e1) {

								e1.printStackTrace();
							}
						}

					} else if (response2.contains("2")) {

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

								try (PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {
									pw.print(formatter.format(dateTime) + ": ");
									pw.print(thisMachine.getContents().getStock().get(selection.toUpperCase())
											.getSlotItem().getName() + " " + selection.toUpperCase());
									pw.print(" $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()));
									pw.flush();
								} catch (FileNotFoundException e2) {

									e2.printStackTrace();
								} catch (IOException e1) {

									e1.printStackTrace();
								}

								BigDecimal X = BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided());
								X = (X.subtract(BigDecimal.valueOf(thisMachine.getContents().getStock()
										.get(selection.toUpperCase()).getSlotItem().getPrice())));
								thisMachine.setCurrentMoneyProvided(X.doubleValue());

								try (PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {
									pw.print(" $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()) + "\n");
									pw.flush();
								} catch (FileNotFoundException e2) {

									e2.printStackTrace();
								} catch (IOException e1) {

									e1.printStackTrace();
								}

								System.out.println(thisMachine.getContents().getStock().get(selection.toUpperCase())
										.getSlotItem().getName() + "\t"
										+ BigDecimal.valueOf(thisMachine.getContents().getStock()
												.get(selection.toUpperCase()).getSlotItem().getPrice()));
								System.out.println(BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()));
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

							} else {
								System.out.println("You don't have enough money for that selection!");

							}

						}
					} else if (response2.contains("3")) {

						BigDecimal Q = new BigDecimal("0.25");
						BigDecimal D = new BigDecimal("0.10");
						BigDecimal N = new BigDecimal("0.05");
						int countQ = 0;
						int countD = 0;
						int countN = 0;

						try (PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {
							pw.print(formatter.format(dateTime) + ":");
							pw.print(" GIVE CHANGE: ");
							pw.print(" $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()));
							pw.print(" Balance: $0.00 \n");
							pw.flush();
						} catch (FileNotFoundException e2) {

							e2.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
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
				System.out.println("THANK YOU!");
				System.exit(0);
			} else if (response1.contains("4")) {

			}

		}

	}

}
