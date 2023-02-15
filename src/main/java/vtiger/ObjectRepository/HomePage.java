package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilitu.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {

	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement oppLin;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization 
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOppLin() {
		return oppLin;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	//Busines Logic
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrgLink()
	{
		orgLink.click();
	}
	
	/**
	 * This method will click on contact link
	 */
	public void clickOnConLink()
	{
		contactLink.click();
	}
	
	/**
	 * This method will click on opportunity link
	 */
	public void clickOnOppLink()
	{
		oppLin.click();
	}
	
	/**
	 * This method will click on Products link
	 */
	public void clickOnProLink()
	{
		productsLink.click();
	}
	
	/**
	 * This method will click on signOut link
	 */
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, adminImage);
		signOut.click();
	}
}
