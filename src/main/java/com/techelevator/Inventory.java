package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
<<<<<<< HEAD
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
=======
import java.util.HashMap;
import java.util.LinkedHashMap;
>>>>>>> 7fd032507260bf58d5e0aa7b5f9aa53f8966107b
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class Inventory {
	
	private Map <String, Slot> stock;
	
	public Inventory() {
<<<<<<< HEAD
		stock = new HashMap<String, Slot>();
=======
		stock = new LinkedHashMap<String, Slot>();
>>>>>>> 7fd032507260bf58d5e0aa7b5f9aa53f8966107b
		
		String path = "vendingmachine.csv";
		File inputFile = new File(path);
		try(Scanner goodies = new Scanner(inputFile)){
			while(goodies.hasNextLine()) {
				String currentLine = goodies.nextLine();
				String[] info = currentLine.split("\\|");
				if (info[3].contains("Chip")) {
					Chip vendChip = new Chip(info[1], Double.parseDouble(info[2]));
					Slot chipSlot = new Slot(vendChip);
					stock.put(info[0], chipSlot);
				} else if (info[3].contains("Drink")) {
					Drink vendDrink = new Drink(info[1], Double.parseDouble(info[2]));
					Slot drinkSlot = new Slot(vendDrink);
					stock.put(info[0], drinkSlot);
				} else if (info[3].contains("Gum")) {
					Gum vendGum = new Gum(info[1], Double.parseDouble(info[2]));
					Slot gumSlot = new Slot(vendGum);
					stock.put(info[0], gumSlot);
				} else if (info[3].contains("Candy")) {
					Candy vendCandy = new Candy(info[1], Double.parseDouble(info[2]));
					Slot candySlot = new Slot(vendCandy);
					stock.put(info[0], candySlot);
				} else {
<<<<<<< HEAD
					System.out.println("Error");
=======
					System.out.println("error");
>>>>>>> 7fd032507260bf58d5e0aa7b5f9aa53f8966107b
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
<<<<<<< HEAD
			
			
=======
>>>>>>> 7fd032507260bf58d5e0aa7b5f9aa53f8966107b
		}

	}

	public Map <String, Slot> getStock() {
		return stock;
	}
	
	     
	  	
	
	}
	
	

