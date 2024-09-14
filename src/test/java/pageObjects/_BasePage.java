package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class _BasePage {
	//contains common methods which can be used by other page object classes
	//in future we we found that a method is frequently used in many page object classes..
    //we can put that method in basepage class
	
	
	WebDriver driver;
	
	public _BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

}
