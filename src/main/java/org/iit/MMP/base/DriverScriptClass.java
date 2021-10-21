package org.iit.MMP.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScriptClass {
	
	protected WebDriver driver;
	protected Properties prop;
    
	//protected ExtentTest logger;
	//protected  ExtentReports reports;
	
	//protected ITestResult result;
		
	public DriverScriptClass()
	{
	  try{
	 File f = new File("./mmpconfig/config.properties");
	 FileInputStream fis = new FileInputStream(f);
	 prop = new Properties();
	 prop.load(fis);
	  }
	catch(Exception e)
	{
		System.out.println("Error message is :"+ e.getMessage());
	}
	}

    
	public void initSetUp()
	{
	String browser = prop.getProperty("browser");

	 if(browser.equalsIgnoreCase("chrome".trim()))
	{
		
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	}
	 else if(browser.equalsIgnoreCase("edge".trim()))
	{
		
	  WebDriverManager.edgedriver().setup();
	  driver = new EdgeDriver();
	}
	 else if(browser.equalsIgnoreCase("firefox".trim()))
	{
		 
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	}
	  driver.manage().window().maximize();	 
   
  }
    /*
    @BeforeSuite
	public void setUpReports()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./mmpReports/report.html");
		reports = new ExtentReports();
		reports.attachReporter(extent);		
	}

    @AfterMethod
    public void tearDown()
	{
    	
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		logger.fail("Failed here");
    	}
    	
		driver.close();		
		//reports.flush();
	}
	*/
}
