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
	
	@Test
       public void test_machine_contains_item() {
		
		Assert.assertEquals("GUM", test.getContents().getStock().get("D1").getSlotItem());
	
}
	
	@Test
       public void test_machine_feed_money() {
   		test.feedMoney();
   		Assert.assertEquals(0.0, test.getCurrentMoneyProvided(),0.0);
       }  
}
