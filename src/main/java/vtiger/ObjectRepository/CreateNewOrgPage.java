package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilitu.WebDriverUtilities;

public class CreateNewOrgPage extends WebDriverUtilities {

	@FindBy(name = "accountname")
	private WebElement orgNametext;
	
	@FindBy(name="industry")
	private WebElement industryDd;
	
	@FindBy(name="accounttype")
	private WebElement accountType;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	/*@FindBy(name="button")
	private WebElement saveBtn;*/
	
	//Initialization
	
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	//
	public WebElement getOrgNametext() {
		return orgNametext;
	}

	public WebElement getIndustryDd() {
		return industryDd;
	}

	public WebElement getAccountType() {
		return accountType;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Libraries
	
	/**
	 * This method will create org
	 * @param OrgName
	 */
	public void createNewOrg(String OrgName)
	{
		orgNametext.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create org with industry and type
	 * @param OrgName
	 * @param indType
	 */
	public void createNewOrg(String OrgName, String indType)
	{
		orgNametext.sendKeys(OrgName);	
		handleDropDown(indType, industryDd);
		saveBtn.click();
	}
	
	/**
	 * This method will create or with industry and type
	 * @param OrgName
	 * @param indType
	 * @param type
	 */
	public void createNewOrg(String OrgName, String indType, String type )
	{
		orgNametext.sendKeys(OrgName);
		handleDropDown(indType, industryDd);
		handleDropDown(type, accountType);
		saveBtn.click();
	}
}
