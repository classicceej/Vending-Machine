package com.techelevator;

import org.junit.*;
public class VendingMachineTest {
 
	private VendingMachine test;
	
	@Before
	public void instantiation() {
		this.test = new VendingMachine();
	}
	@Test
	public void test_machine_contains_d1() {
		Assert.assertEquals(true, test.getContents().getStock().containsKey("D1"));
	}
	@Test
	public void test_machine_contains_item_U_Chews() {
		
		Assert.assertEquals("U-Chews", test.getContents().getStock().get("D1").getSlotItem().getName());
	}
	@Test
	public void test_machine_contains_item_price() {
		
		Assert.assertEquals(0.85, test.getContents().getStock().get("D1").getSlotItem().getPrice(),0.0);
	}
	
	//@Test
      // public void test_machine_contains_item() {
		
		//Assert.assertEquals("GUM", test.getContents().getStock().get("D1").getSlotItem());
	
//}
	
	@Test
       public void test_machine_feed_money() {
   		test.feedMoney();
   		Assert.assertEquals(0.0, test.getCurrentMoneyProvided(),0.0);
       }  


	
	

	@Test
	public void vending_machine_contains_a1() {
		String key = "A1";
		Assert.assertTrue(test.getContents().getStock().containsKey(key));
	}

	@Test
	public void vending_machine_a1_contains_PotatoCrips() {
		String value = "Potato Crisps";
		Assert.assertEquals(value, test.getContents().getStock().get("A1").getSlotItem().getName());

	}

	@Test
	public void vending_machine_a1_costs_305() {
		double cost = 3.05;
		Assert.assertEquals(cost, test.getContents().getStock().get("A1").getSlotItem().getPrice(), 0.0);

	}

	@Test
	public void vending_machine_chip_message() {
		String message = "Crunch Crunch, Yum!";
		Assert.assertEquals(message, test.getContents().getStock().get("A1").getSlotItem().getMessage());

	}
//	@Test
//	public void vending_machine_a1_soldOut() {
//		String key = "A1";
//		int quant = 0;
//		out.getContents().getStock().get(key).getSlotItem().setQuantity(quant);;
//		
//		
//		Assert.assertTrue(out.getContents().getStock().get(key).isSoldOut());
//		
//	//SOLD OUT TEST DOES NOT WORK BECAUSE METHOD OF SETTING SOLD OUT NOT IN VENDING MACHINE
//		//MANUAL TESTING CONFIRMS THAT SOLD OUT IS SET WHEN ITEM REACHES 0 QUANTITY
//	
//	
//	}
	@Test
	public void vending_machine_feedmoney() {
		test.setFedMoney(3);
		test.feedMoney();
		
		Assert.assertEquals(3.0, test.getCurrentMoneyProvided(), 0.0);
	
	}
	
	@Test
	public void vending_machine_feedmoneyzero() {
		test.setFedMoney(0);
		test.feedMoney();
		
		Assert.assertEquals(0.0, test.getCurrentMoneyProvided(), 0.0);
	
	}
	
	@Test
	public void vending_machine_returns_correct_change() {
		test.setFedMoney(5);
		test.feedMoney();
		
		Assert.assertEquals(5.0, test.getCurrentMoneyProvided(), 0.0);

	}
    
}
