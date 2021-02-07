package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//import java.util.List;
//=======
//import java.util.HashMap;
import java.util.LinkedHashMap;


import java.util.Map;
import java.util.Scanner;

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

		

		}

	}

	public Map<String, Slot> getStock() {
		return stock;
	}

	public void logFile() throws IOException  {
		File outputFile = new File("log.txt");
		List<String> list = getList();
		try(FileWriter logWriter = new FileWriter(outputFile, true)){
			for(String str : list) {
				logWriter.write(str);
				logWriter.write("\n");
			}
		}
	}
	  //Audit file 
	public void logFile(String itemName, String itemSlot, int itemPrice)
	{
		File logFile = new File("log.txt");
		if(!logFile.exists())
		{
			try
			{
				logFile.createNewFile();
			}
			catch(Exception e)
			
			{
				System.out.println();
			}
			
			}
		
		try(PrintWriter pw = new PrintWriter(logFile))
		{
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");
			pw.print(formatter.format(dateTime) + " : ");
			pw.print( + " : ");
			pw.print(item + "   : ");
			pw.print(itemSlot + "   : ");
			pw.print(getBalance() + " : ");
			
		}
		catch(Exception e)
		{
			System.out.println("There was a problem writing to the log file.");
			
		}


	}
}



