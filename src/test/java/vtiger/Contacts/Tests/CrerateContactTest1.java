package vtiger.Contacts.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrgPage;
import vtigerGenericUtilitu.BaseClass;
import vtigerGenericUtilitu.ExcelFileUtility;
import vtigerGenericUtilitu.JavaUtility;
import vtigerGenericUtilitu.ProppertyFileUtility;
import vtigerGenericUtilitu.WebDriverUtilities;

public class CrerateContactTest1 extends BaseClass {

	@Test
	public void CreateContactTest() throws IOException
	{
		
		String ORGNAME = eu.readDataFromExcel("Contact", 4, 3)+ju.getRandomNumber();
		String LASTNAME = eu.readDataFromExcel("Contact", 4, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("click on org", true);
		
		OrgPage op = new OrgPage(driver);
		op.createorg();
		Reporter.log("click on create org", true);
		
		CreateNewOrgPage cn = new CreateNewOrgPage(driver);
		cn.createNewOrg(ORGNAME);
		
		
		OrgInfoPage oip = new OrgInfoPage(driver);
		String header = oip.getOrg();
		System.out.println(header);
		
		if(header.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		Reporter.log("created org", true);
		
		
		hp.clickOnConLink();
		Reporter.log("contacts page", true);
		
		ContactsPage cp = new ContactsPage(driver);
		cp.createCon();
		Reporter.log("create contacts page", true);
		
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("contacts created", true);
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String header1 = cip.getCon();
		System.out.println(header1);
		
		if(header1.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		Reporter.log("created org", true);
	}

}
