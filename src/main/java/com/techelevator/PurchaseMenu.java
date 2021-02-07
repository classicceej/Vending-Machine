package com.techelevator;

public class PurchaseMenu extends Software {

	private VendingMachine hardware;

	PurchaseMenu(VendingMachine hardware) {
		this.hardware = hardware;
	}

	public void feed() {
		System.out.println("How much money are you inserting? >>>");
		int insert = scan.nextInt();
		double dubInsert = insert;
		getHardware().CurrentMoneyProvided() += dubInsert; // += dubInsert;
		getHardware().getUser().getBankAccount() -= dubInsert;
		System.out.println(getHardware().getCurrentMoneyProvided());
	}

	public VendingMachine getHardware() {
		return hardware;
	}

}
