package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Inventory {

	private Map<String, Slot> stock;

	public Inventory() {

		stock = new LinkedHashMap<String, Slot>();

		String path = "vendingmachine.csv";
		File inputFile = new File(path);
		try (Scanner goodies = new Scanner(inputFile)) {
			while (goodies.hasNextLine()) {
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

					System.out.println("Error");

				}

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}

	public Map<String, Slot> getStock() {
		return stock;
	}

}
