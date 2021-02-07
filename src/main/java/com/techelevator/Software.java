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

//import java.io.File;
import java.util.Scanner;

public class Software {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");

		String salesFile = "SalesReport" + formatter.format(dateTime) + ".csv";
		File SalesReport = new File(salesFile);

		// CREATED NEW FILE FOR EACH DATE

		String fileName = "Log.txt";

		File logFile = new File(fileName);
		String initSource = "InitSales.txt";
		File InitFile = new File(initSource);

		try (PrintWriter pw = new PrintWriter(logFile)) {
			pw.print("");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		VendingMachine thisMachine = new VendingMachine();

//		String initSource = "InitSales.txt";
//		File InitFile = new File(initSource);
//		try (Scanner repo = new Scanner(InitFile)) {
//			while (repo.hasNextLine()) {
//				String currentLine = repo.nextLine();
//				String[] info = currentLine.split("\\|");
//
//				for (String k : thisMachine.getContents().getStock().keySet()) {
//					Slot v = thisMachine.getContents().getStock().get(k);
//					if (info[0].contains(v.getSlotItem().getName())) {
//					
//					}
//				}
//			}
//		} catch (FileNotFoundException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}
//		
		// READING IN INITIAL FILE

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
							String moneyString = keyboard.nextLine();
							try {
								int moneyIn = Integer.parseInt(moneyString);
								// ACCOUNT FOR NULLÏ

								thisMachine.setFedMoney(moneyIn);

								thisMachine.feedMoney();
								System.out.println(
										"There is $" + BigDecimal.valueOf((thisMachine.getCurrentMoneyProvided()))
												+ " in the machine");

								System.out.println("Enter more?  Y/N ");
								String responseFeeding = keyboard.nextLine();

								if (responseFeeding.toUpperCase().contains("N")) {
									feeding = false;

								}

								try (PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {
									pw.print(formatter.format(dateTime) + ":");
									pw.print(" FEED MONEY: ");
									pw.print(" $" + BigDecimal.valueOf(moneyIn));
									pw.print(" $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()) + "\n");
									pw.flush();

								} catch (FileNotFoundException e2) {

									e2.printStackTrace();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}catch (Exception eN) {
								break;
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

								try (PrintWriter pw = new PrintWriter(new FileWriter(SalesReport, true))) {

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
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

								thisMachine.getContents().getStock().get(selection.toUpperCase()).getSlotItem()
										.countUp();
								// RAISING THE COUNT

								try (PrintWriter pws = new PrintWriter(new FileWriter(SalesReport, false))) {

									try (Scanner repo = new Scanner(InitFile)) {
										while (repo.hasNextLine()) {
											String currentLine = repo.nextLine();
											String[] info = currentLine.split("\\|");

//											for (String k : thisMachine.getContents().getStock().keySet()) {
//												Slot v = thisMachine.getContents().getStock().get(k);

											if (info[0].contentEquals(thisMachine.getContents().getStock()
													.get(selection.toUpperCase()).getSlotItem().getName())) {
												// Diet Cola is Cola
												
												int toInt = Integer.parseInt(info[1]);
												toInt += thisMachine.getContents().getStock()
														.get(selection.toUpperCase()).getSlotItem().getCount();
												
												//Diet Cola gets Cola count
												
												info[1] = String.valueOf(toInt);
											}
											pws.println(info[0] + "|" + info[1]);
											pws.flush();

										}

									} catch (FileNotFoundException e2) {

										e2.printStackTrace();
									}

								} catch (IOException e3) {
									e3.printStackTrace();
								}
								
								thisMachine.getContents().getStock().get(selection.toUpperCase()).getSlotItem()
								.countDown();

								try (PrintWriter pwi = new PrintWriter(new FileWriter(initSource, false))) {
									try (Scanner repoS = new Scanner(SalesReport)) {
										while (repoS.hasNextLine()) {
											String currentLine = repoS.nextLine();
											String[] info = currentLine.split("\\|");

											pwi.println(info[0] + "|" + info[1]);
											pwi.flush();

										}

									} catch (FileNotFoundException e2) {

										e2.printStackTrace();
									}

								} catch (IOException e3) {
									e3.printStackTrace();
								}

								// READING IN INITIAL FILE

								if (thisMachine.getContents().getStock().get(selection.toUpperCase()).getSlotItem()
										.getQuantity() == 0) {
									thisMachine.getContents().getStock().get(selection.toUpperCase()).setSoldOut(true);
								}

							} else {
								System.out.println("You don't have enough money for that selection!");

							}

						}
					} else if (response2.contains("3")) {



						try (PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {
							pw.print(formatter.format(dateTime) + ":");
							pw.print(" GIVE CHANGE: ");
							pw.print(" $" + BigDecimal.valueOf(thisMachine.getCurrentMoneyProvided()));
							pw.print(" $0.00 \n");
							pw.flush();
						} catch (FileNotFoundException e2) {

							e2.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
						
						thisMachine.makeChange();

						System.out.println("Your change is: \n" + thisMachine.getCountQ() + " Quarters!\n" + thisMachine.getCountD() + " Dimes!\n"
								+ thisMachine.getCountN() + " Nickles!");
						
						thisMachine.setCountQ(0);
						thisMachine.setCountD(0);
						thisMachine.setCountN(0);

						purchaseMenu = false;
					}
				}

			} else if (response1.contains("3")) {
				System.out.println("THANK YOU!");
				System.exit(0);

			} else if (response1.contains("4")) {
				BigDecimal totalSales = new BigDecimal(0);
				double newTotal = 0;
				try (Scanner repo4 = new Scanner(InitFile)) {
					while (repo4.hasNextLine()) {

						String currentLine = repo4.nextLine();

						String[] info = currentLine.split("\\|");

						System.out.println(currentLine);

						for (String k : thisMachine.getContents().getStock().keySet()) {
							if (info[0].contentEquals(thisMachine.getContents().getStock().get(k).getSlotItem().getName())) {

								double jDub = thisMachine.getContents().getStock().get(k).getSlotItem().getPrice();

								BigDecimal BigJ = new BigDecimal(jDub);
								double hDub = Double.parseDouble(info[1]);

								BigDecimal BigH = new BigDecimal(hDub);
								if (BigH != BigDecimal.valueOf(0.0)) {
									BigDecimal Add = BigJ.multiply(BigH);
									totalSales = (totalSales.add(Add));
									newTotal = totalSales.doubleValue();
								}
							}
						}

					}
					double roundOff = Math.round((newTotal) * 100.00) / 100.00;
					System.out.println("\nTOTAL SALES: \n");
					System.out.println(roundOff);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
