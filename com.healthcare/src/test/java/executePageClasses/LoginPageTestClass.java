package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class LoginPageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
  
	
  @Test(priority=1,retryAnalyzer = RetryAnalyzer.class,groups= {"group1"})
  public void verifyThePageOpenWhileHittingUrl() {
      
	  lp=new LoginPageClass(driver);
	  String expectedUrl="https://demo.openmrs.org/openmrs/login.htm";
	  String actualUrl=lp.getUrlOfWebpage();
	  Assert.assertEquals(actualUrl,expectedUrl);
	  
  }
	

  @Test(dataProvider ="SuccessfulLogin",dataProviderClass = DataProviderClass.class, priority=2,retryAnalyzer = RetryAnalyzer.class,groups= {"group2"})
  public void verifySuccessfulLogin(String uname1,String passwd1) throws IOException {	
	  
	   lp=new LoginPageClass(driver);
	   lp.login(uname1,passwd1);
	   
	   hp=new HomePageClass(driver);
	   String expectedMessage=hp.readStringData(2,1);
	   String actualMessage=hp.getTextOfAdminMessage();
	   Assert.assertEquals(actualMessage,expectedMessage);
	     
 }
  
  
  @Test(dataProvider = "unSuccessfulLogin",dataProviderClass = DataProviderClass.class,priority=3,retryAnalyzer = RetryAnalyzer.class,groups= {"group3"})
  public void verifyUnSuccessfulLogin(String uname,String passwd) throws IOException {
	  
	   lp=new LoginPageClass(driver);
	   lp.login(uname, passwd);
	   String expectedMessage=lp.readStringData(2,2);
	   String actualMessage=lp.getTextOfErrorMessage();
	   Assert.assertEquals(actualMessage,expectedMessage);
	   
  }
  
  
  
  
  
}
