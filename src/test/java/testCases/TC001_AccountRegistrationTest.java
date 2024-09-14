package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


  //code for opening and closing the app is used from base class(reusability)
  
  
  @Test(groups = {"sanity"})  //beforeclass will run before test..so it will look for beforeclass in current class..
  //if beforeclass is not found in current class then it will look for same in parent class
  public void testLogin() {
	  
	  logger.info("***starting execution for TC001***"); 
	  //will log given string in file/console(depending on log4j2.xml configration)
	  //info(): provides normal info
	  //we can use above line anywhere in any test case class to generate logs
	  
	  try
	  {
	  //registering on application
	  logger.info("***registering on application***");
	  HomePage  hp = new HomePage(driver);
	  hp.clickMyaccount();
	  hp.clickRegister();
	  Assert.assertEquals(driver.getTitle(), "Register Account");
	  
	  logger.info("***entering user details***");
	  AccountRegistrationPage  ap = new AccountRegistrationPage(driver);
	  ap.SetFirstName("shivam");
	  ap.SetLastName("sangwan");
	  ap.SetEmail("shivamsangwan2012@gmail.com");
	  ap.SetPassword("abc123@");
	  ap.SetPolicy();
	  ap.ClickContinue();
	  
	  logger.info("***validating expected message***");
	  Assert.assertEquals(ap.Verifyregistration(), "Your Account Has Been Created!");
	  }
	  
	  catch(Exception e)
	  {
		  logger.error("test failed"); //error(): provides error info
		  Assert.fail();  //if any exception occur then it means our test is failed so in catch block we will manually fail test case
	  }
  }
  
  
  

}
