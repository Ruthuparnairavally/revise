package vtiger.Pratice;

import org.testng.annotations.Test;

public class TestNgPractice1 {

	@Test(invocationCount = 3, priority = 1)
	public void createCustomerTest()
	{
		System.out.println("Created");
	}
	
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("modify");
	}
	
	@Test
	public void deleteCustomerTest()
	{
		System.out.println("delete");
	}
}
