package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends _BasePage{
	 
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//webelements
    @FindBy(xpath = "//span[text() = 'My Account']")
    WebElement lnkMyaccount;
    
    @FindBy(xpath = "//a[text() = 'Register']")  
    WebElement lnkRegister;
    
    @FindBy(xpath = "//a[text() = 'Login']")  
    WebElement lnklogin;
    
    //action methods
    public void clickMyaccount()
    {
    	lnkMyaccount.click();
    }
    
    
    public void clickRegister()
    {
    	lnkRegister.click();
    }
    
    public void clickLogin()
    {
    	lnklogin.click();
    }
    
	
	
}
