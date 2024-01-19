package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindAPatientClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class FindAPatientTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	FindAPatientClass fp;
	GeneralUtilities gl;
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
  public void verifyToFindAPatient(String uname1,String passwd1) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickOnFindpatient();
	  
	  gl=new GeneralUtilities();
	  
	  fp=new FindAPatientClass(driver);
	  Boolean check=fp.isPatientNameDisplayed(ExcelReadClass.getStringdata(0, 5));
	  Assert.assertTrue(check);
	  
  }
 


}