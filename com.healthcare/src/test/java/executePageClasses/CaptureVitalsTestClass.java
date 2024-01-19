package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.CaptureVitalsClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class CaptureVitalsTestClass extends BaseClass {
	
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientClass rp;
	CaptureVitalsClass cp;
	GeneralUtilities gl;
	
	
  @Test(dataProvider ="SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
  public void verifyCaptureVitalsOfPatientSuccessfullyRegistered(String uname1,String passwd1) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickonRegister();
	  
	  rp=new RegisterAPatientClass(driver);
	  rp.enterName(rp.getFirstName());
	  rp.enterFamilyName(rp.getFamilyName());
	  rp.clickOnButton();
	  rp.clickOnGender(0);
	  rp.clickOnButton();
	  rp.clickOnButton();
	  rp.enterBirthDay(rp.getBirthDay());
	  rp.selectBirthMonth(3);
	  rp.enterBirthYear(rp.getBirthYear());
	  rp.clickOnButton();
	  rp.enterAddress(rp.getAddress());
	  rp.clickOnButton();
	  rp.clickOnButton();
	  rp.clickOnButton();
	  rp.clickOnConfirm();
	  rp.clickOnStart();
	  rp.clickOnConfirmRight();
	  rp.clickOnCaptureVitals();
	  
	  gl=new GeneralUtilities();
	  cp=new CaptureVitalsClass(driver);
	  cp.enterHeight(ExcelReadClass.getIntegerdata(11,4));
	  cp.clickonButton();
	  cp.enterWeight(ExcelReadClass.getIntegerdata(12,4));
	  cp.clickonButton();
	  cp.clickonButton();
	  cp.enterTemperature(ExcelReadClass.getIntegerdata(13,4));
	  cp.clickonButton();
	  cp.enterPulse(ExcelReadClass.getIntegerdata(14,4));
	  cp.clickonButton();
	  cp.clickonButton();
	  cp.enterlowBP(ExcelReadClass.getIntegerdata(15,4));
	  cp.enterHighBp(ExcelReadClass.getIntegerdata(16,4));
	  cp.clickonButton();
	  cp.clickonButton();
	  cp.clickonSave();
	  cp.clickonShowDeatils();
	  Boolean check=cp.detailsDisplayed();
	  Assert.assertTrue(check);
	  
	  
	  
  }
}
