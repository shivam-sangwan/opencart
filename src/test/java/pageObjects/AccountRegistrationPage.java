package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends _BasePage{
	 
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//webelements
    @FindBy(xpath = "//input[@id = 'input-firstname']")
    WebElement txtFirstName;
    
    @FindBy(xpath = "//input[@id = 'input-lastname']")
    WebElement txtLastName;
    
    @FindBy(xpath = "//input[@id = 'input-email']")
    WebElement txtEmail;
    
    @FindBy(xpath = "//input[@id = 'input-password']")
    WebElement txtpassword;
    
    @FindBy(xpath = "//form[@id='form-register']//input[@name = 'agree']")
    WebElement chkpolicy;
    
    @FindBy(xpath = "//button[text() = 'Continue']")
    WebElement btncontinue;
    
    @FindBy(xpath = "//h2[text() = 'My Account']")
    WebElement loginConfirmation;
    
    
    
  
    //action methods
    public void SetFirstName(String fname)
    {
    	txtFirstName.sendKeys(fname);
    }
    
    
    public void SetLastName(String lname)
    {
    	txtLastName.sendKeys(lname);
    }
    
    
    public void SetEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    
    public void SetPassword(String pwd)
    {
    	txtpassword.sendKeys(pwd);
    }
    
    public void SetPolicy()
    {
    	chkpolicy.click();
    }
    
    public void ClickContinue()
    {
    	btncontinue.click();
    }
    
    public String Verifyregistration()
    {
    	try 
    	{
    		String s = loginConfirmation.getText();
    		return s;
    	}
    	catch(Exception e)
    	{
    		return e.getMessage();
    	}
    	
    	
    }
	
	
}
