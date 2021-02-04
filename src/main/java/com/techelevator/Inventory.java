package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
	public static void main(String[] args) {
   List<String> itemList = new ArrayList<String>();
  
  
  
       File inputFile = new File("vendingmachine.csv"); 
        
       if( !inputFile.exists() ) { 
		System.out.println(inputFile +" does not exist");
		System.exit(1); 
		
	    } else if (!inputFile.isFile() ) {
		System.out.println(inputFile +" is not a file");
		System.exit(1); 
	    }
	return;
}
  
 

} 

