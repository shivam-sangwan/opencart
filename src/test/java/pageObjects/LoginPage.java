package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends _BasePage{
	 
	//constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//webelements
    @FindBy(xpath = "//input[@id = 'input-email']")
    WebElement txtEmail;
    
    @FindBy(xpath = "//input[@id = 'input-password']") 
    WebElement txtPwd;
    
    
    @FindBy(xpath = "//button[text() = 'Login']")
    WebElement btnLogin;
    
    @FindBy(xpath = "//h2[text() = 'My Account']")
    WebElement msgconfirmation;
    
    
    
  
    //action methods
    public void SetFirstName(String emailadd)
    {
    	txtEmail.sendKeys(emailadd);
    }
    
    
  
    public void SetPassword(String pwd)
    {
    	txtPwd.sendKeys(pwd);
    }
    
    
    
    public void ClickLogin()
    {
    	btnLogin.click();
    }
    
    public boolean VerifyLogin()
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
