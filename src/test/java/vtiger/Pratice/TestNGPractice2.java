package vtiger.Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice2 {

	@Test
	public void createCustomerTest()
	{
		Assert.fail();
		System.out.println("Created");
	}
	
	@Test(dependsOnMethods = "createCustomerTest" )
	public void modifyCustomerTest()
	{
		System.out.println("modify");
	}
	
	@Test(dependsOnMethods = {"createCustomerTest", "modifyCustomerTest"} )
	public void deleteCustomerTest()
	{
		System.out.println("delete");
	}
}
