package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule 1: Create java class pagewise
//Declaration
public class LoginPage {

	//rule 2: Identify all the web elements in the page using @Findy, @FindAll, @FindBys
	//Declaration
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement PassWordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPassWordEdt() {
		return PassWordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	//Business Library
	
	public void loginToApp(String userName, String Password )
	{
		UserNameEdt.sendKeys(userName);
		PassWordEdt.sendKeys(Password);
		LoginBtn.click();
	}
}
