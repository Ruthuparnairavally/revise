package vtiger.Pratice;

import org.testng.annotations.Test;

public class TestNgPractice {

	@Test(priority = -1)
	public void createCustomerTest()
	{
		System.out.println("Created");
	}
	
	@Test(priority = 2)
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
