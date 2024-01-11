package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindAPatientClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class FindAPatientTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	FindAPatientClass fp;
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
  public void verifyToFindAPatient(String uname1,String passwd1) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickOnFindpatient();
	  
	  fp=new FindAPatientClass(driver);
	  Boolean check=fp.isPatientNameDisplayed(fp.readStringData(0, 5));
	  Assert.assertTrue(check);
	  
  }
 


}