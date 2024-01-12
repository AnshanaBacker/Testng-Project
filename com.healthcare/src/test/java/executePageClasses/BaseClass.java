package executePageClasses;





import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utilities.ScreenShotClass;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  
	WebDriver driver;
	ScreenShotClass sh;
	
	public static Properties p;
	
	public static void readproperty() throws IOException
	{
		p=new Properties();
		
		FileInputStream fs=new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Configuration.Properties");
		p.load(fs);
	}
	
  @Parameters({"browser"})	
  @BeforeMethod(groups= {"launch"})
  public void beforeMethod(String browserValue) throws IOException {
	  
	  readproperty();
	  
	  if(browserValue.equalsIgnoreCase("chrome"))
	  {
		  driver=new ChromeDriver();
	  }
	  else if(browserValue.equalsIgnoreCase("edge"))
	  {
		  driver=new EdgeDriver();
	  }
	  
	 
	  driver.get(p.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
  }

  @AfterMethod(groups= {"close"})
  public void afterMethod(ITestResult itr) throws IOException {
	  
	  if(itr.getStatus()==ITestResult.FAILURE)
	  {
		  sh=new ScreenShotClass();
		  sh.takeScreenShot(driver,itr.getName());
	  }
	  
	  
	  
	       driver.quit();
  }
  
  @BeforeSuite(alwaysRun = true) 
	public void createExtendReport(final ITestContext testContext)
	{
		extendReport.ExtentManager.createInstance().createTest(testContext.getName(),"message");
	}


}
