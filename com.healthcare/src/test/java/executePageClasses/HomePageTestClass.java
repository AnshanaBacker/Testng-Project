package executePageClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class HomePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class,groups= {"group2"})
  public void verifyAllTilesAreDisplayedInHomePage(String uname1,String passwd1) {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  Boolean actualResult=hp.isAllTilesDisplayed();
	  Assert.assertTrue(actualResult);
	  
  }
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class,groups= {"group3"})
  public void verifySuccessfulLogoutFromHomePage(String uname1,String passwd1) {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickOnLogout();
	  Boolean check=hp.iconIsDisplayed();
	  Assert.assertTrue(check);
	  
	  
	  
  }
	  
}