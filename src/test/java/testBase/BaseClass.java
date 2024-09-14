package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	//Contains reusable methods, which can be used by other test case classes
	//in future we we found that a method is frequently used in many test case classes..
	//we can put that method in base class
	
	public static WebDriver driver;
	public Properties propobj;
	
	//we want to generate log for every test case class, thats why logger is..
	//placed in base class
	 //Logger class is provided by apche poi
	//used to generate logs
	 public Logger logger;
	 
	 
	
	    @Parameters({"browser","os"}) //cross browser testing
	    @BeforeClass(groups = {"sanity","regression","datadriven"})
	    public void SetUp(@Optional("chrome") String br, String os) throws IOException {
	    	
	    	
	     //reading properties file
	   	 FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src/test/resources//config.properties");
	   			 
	   	 propobj = new Properties();
	   	 propobj.load(file);
	   	 String url = propobj.getProperty("appurl");
	       
	        
	   	    	
	    	
	    	
	    	
		  
		//getlogger() is function of LogManager class
		logger = LogManager.getLogger(this.getClass());
		
		//this line automatically loads the log4j2.xml file
		//this.getClass(): Returns the runtime class of this Object
		//now we can generate logs for given test case class using...
		//'logger' reference variable
		
		//for cross browser testing
		switch(br)
		{
		case "chrome":
		driver = new ChromeDriver();
		break;
		case "edge":
		driver = new EdgeDriver();
		break;
		
		
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url); //taking url from properties file
		driver.manage().window().maximize();
	  }
	  
	  @AfterClass(groups = {"sanity","regression","datadriven"})
	  public void tearDown() {
		  driver.quit();
	  }
	  
	  
	  //method to capture screenshot
	  public String CaptureScreenShot(String ssfilename)//ssfilename: name of failed test case..will be passed by extentreportmanager class
	  {
		  //ssfilename: name of failed test method..will be passed by extentreportmanager class when calling this method
		 
		  //capturing timestamp
		  String timestamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date()); 
		  
		  //taking screenshot
		  File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  //target file path
		  String targetfilepath = System.getProperty("user.dir")+ "//screenshots" + ssfilename + "_" +timestamp+".png";
		  File targetfile = new File(targetfilepath);
		  sourcefile.renameTo(targetfile);
		  return targetfilepath; //will be used in extentreportmanager listener to attach ss to report
	  }
}
