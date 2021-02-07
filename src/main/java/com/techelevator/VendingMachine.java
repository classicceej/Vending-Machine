package com.techelevator;

import java.math.BigDecimal;

public class VendingMachine {
	private Inventory contents;
	private double currentMoneyProvided = 0;
	private int fedMoney = 0;
	BigDecimal Q = new BigDecimal("0.25");
	BigDecimal D = new BigDecimal("0.10");
	BigDecimal N = new BigDecimal("0.05");
	int countQ = 0;
	int countD = 0;
	int countN = 0;

	
	private Customer user;
	
	public VendingMachine(){
		this.contents = new Inventory();
		
	}
	
	
	public void returnChange(){
		currentMoneyProvided = 0;
	
		//Change must be dispensed in smallest amount of coins
	}
	
	public void makeChange() {
		while ((Q.compareTo(BigDecimal.valueOf(getCurrentMoneyProvided())) <= 0)) {
			BigDecimal newVal = BigDecimal.valueOf(getCurrentMoneyProvided()).subtract(Q);
			setCurrentMoneyProvided(newVal.doubleValue());
			countQ++;
		}
		while ((D.compareTo(BigDecimal.valueOf(getCurrentMoneyProvided())) <= 0)) {
			BigDecimal newVal = BigDecimal.valueOf(getCurrentMoneyProvided()).subtract(D);
			setCurrentMoneyProvided(newVal.doubleValue());
			countD++;
		}
		while ((N.compareTo(BigDecimal.valueOf(getCurrentMoneyProvided())) <= 0)) {
			BigDecimal newVal = BigDecimal.valueOf(getCurrentMoneyProvided()).subtract(N);
			setCurrentMoneyProvided(newVal.doubleValue());
			countN++;
		}

	}
	
	
	public void setContents(Inventory contents) {
		this.contents = contents;
	}





	public void setCountQ(int countQ) {
		this.countQ = countQ;
	}


	public void setCountD(int countD) {
		this.countD = countD;
	}


	public void setCountN(int countN) {
		this.countN = countN;
	}



	public BigDecimal getQ() {
		return Q;
	}


	public BigDecimal getD() {
		return D;
	}


	public BigDecimal getN() {
		return N;
	}


	public int getCountQ() {
		return countQ;
	}


	public int getCountD() {
		return countD;
	}


	public int getCountN() {
		return countN;
	}


	public void setCurrentMoneyProvided(double currentMoneyProvided) {
		this.currentMoneyProvided = currentMoneyProvided;
	}


	public void feedMoney() {
		currentMoneyProvided += getFedMoney();
	}

	
	public int getFedMoney() {
		return fedMoney;
	}


	public void setFedMoney(int fedMoney) {
		this.fedMoney = fedMoney;
	}


	public void DisplayVendingMachineItems(){
		for (String k : getContents().getStock().keySet()) {
			Slot v = getContents().getStock().get(k);
			if (v.isSoldOut()) {
				System.out.print(k + " " + v.getSlotItem().getName() + " >>>>> " + " IS SOLD OUT!" + "\n");
			} else {
				System.out.print(k + " " + v.getSlotItem().getName() + " $" + v.getSlotItem().getPrice() + " >>>>> " + v.getSlotItem().getQuantity() + "\n");
			}
		}
	}


	public Customer getUser() {
		return user;
	}
	public Inventory getContents() {
		return contents;
	}
	public double getCurrentMoneyProvided() {
		return currentMoneyProvided;
	}
	


}

