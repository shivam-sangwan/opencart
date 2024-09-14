package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends _BasePage{
	 
	//constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//webelements
    @FindBy(xpath = "//a[text() = 'Logout']")
    WebElement btnLogout;
    
    @FindBy(xpath = "//h2[text() = 'My Account']")
    WebElement msgconfirmation;
    
    
    
  
    //action methods
    public void ClickLogout()
    {
    	btnLogout.click();
    }
    
    public boolean isMyAccountPageExists()
    {
    	try 
    	{
    		
    		return  msgconfirmation.isDisplayed();
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    	
    	
    }
	
	
}
