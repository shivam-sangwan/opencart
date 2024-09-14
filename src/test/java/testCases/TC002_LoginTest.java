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
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {


  //code for opening and closing the app is used from base class(reusability)
  
  
  @Test(groups = {"regression"})  //beforeclass will run before test..so it will look for beforeclass in current class..
  //if beforeclass is not found in current class then it will look for same in parent class
  public void testLogin() {
	  
	  logger.info("***starting execution for TC002***");
	  
	  try
	  {
	  //login on application
		  
	  //home page
	  HomePage  hp = new HomePage(driver);
	  hp.clickMyaccount();
	  hp.clickLogin();
	
	  String usrname = propobj.getProperty("username");
	  String pwd = propobj.getProperty("password");
	  
	  //login page
	  LoginPage  lp = new LoginPage(driver);
	  lp.SetFirstName(usrname);  //taking username from properties file
	  lp.SetPassword(pwd);       //taking password from properties file
	  lp.ClickLogin();
	 
	  //MyAccount Page
	  MyAccountPage ma = new MyAccountPage(driver);
	  logger.info("***validating expected message***");
	  Assert.assertTrue(ma.isMyAccountPageExists());
	  }
	  
	  catch(Exception e)
	  {
		  logger.error("test failed"); //error(): provides error info
		  Assert.fail();  //if any exception occur then it means our test is failed so in catch block we will manually fail test case
	  }
  }
  
  
  

}
