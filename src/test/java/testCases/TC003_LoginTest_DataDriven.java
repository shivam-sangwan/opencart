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
import utilities.DataProviderUtilities;


public class TC003_LoginTest_DataDriven extends BaseClass {


  //tc003 is taking data from dataprovider utility which took data from excel
  
  //we are using dataproviders from another class so have to mention classname.class
  @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtilities.class, groups = {"datadriven"})
  public void testLogin(String usrname, String pwd, String exp) {
	  
	  try  //whole code of function is put in try catch to handle exception	
	  {
	  logger.info("***starting execution for TC003***");
	  MyAccountPage ma;
	  //login on application
		  
	  //home page
	  HomePage  hp = new HomePage(driver);
	  hp.clickMyaccount();
	  hp.clickLogin();
	  
	  //login page
	  LoginPage  lp = new LoginPage(driver);
	  lp.SetFirstName(usrname);  
	  lp.SetPassword(pwd);       
	  lp.ClickLogin();
	 
	  //MyAccount Page
	  ma = new MyAccountPage(driver);
	  boolean targetPage = ma.isMyAccountPageExists();
	  
//    data set from excel()covers +ve as well as -ve scenarios:
//	  valid data> login success  test pass	
//	  valid data> login fail  test fail
	  
//	  invalid data> login success  test fail	
//	  invalid data> login fail  test pass
	  
	  if(usrname == "shivam" && pwd == "abc123")  //took valid values from properties file
	  { 
			  Assert.assertTrue(ma.isMyAccountPageExists());
			  ma.ClickLogout();
	  }
	  else  //invalid data cases
	  {
		  try
		  {
			Assert.assertFalse(ma.isMyAccountPageExists());  //invalid data m login success nhi hona chahiye
		  }
		  catch(Exception e) //ager invalid data m login success ho gya..to catch m ayega
		  {
			  ma.ClickLogout();
			  Assert.fail();
		  }
		  
	  }
	  
	  }
	  catch(Exception e)
	  {
		  Assert.fail();  //ager poore code m koi bhi exception aaye(apart from exception of nested try/catch) to fail krdo
	  }
	  
	  
	  
	 
	
	  
  }
  
  
  

}
