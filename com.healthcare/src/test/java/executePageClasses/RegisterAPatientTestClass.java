package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientClass;
import retryAnalyzer.RetryAnalyzer;

public class RegisterAPatientTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientClass rp;
	
  @Test(dataProvider ="SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
  public void verifyRegisterAPatientSuccessfully(String uname1,String passwd1) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickonRegister();
	  
	  rp=new RegisterAPatientClass(driver);
	  rp.enterName(rp.getFirstName());
	  String familyName=rp.getFamilyName();
	  rp.enterFamilyName(familyName);
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
	  String expectedName=familyName;
	  String actualName=rp.textOfFamilyName();
	  Assert.assertEquals(actualName,expectedName);
	  
  }
  
 


@Test(dataProvider = "SuccessfulLogin", dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
	public void verifyThePatientIsNotInActivevisitAfterEndVisit(String uname1, String passwd1) throws IOException {

		lp = new LoginPageClass(driver);
		lp.login(uname1, passwd1);

		hp = new HomePageClass(driver);
        hp.clickonRegister();

		rp = new RegisterAPatientClass(driver);
		rp.enterName(rp.getFirstName());
		rp.enterFamilyName(rp.getFamilyName());
		rp.clickOnButton();
		rp.clickOnGender(0);
		rp.clickOnButton();
		rp.clickOnButton();
		rp.enterBirthDay(rp.getBirthDay());
		rp.selectBirthMonth(1);
		rp.enterBirthYear(rp.getBirthYear());
		rp.clickOnButton();
		rp.enterAddress(rp.getAddress());
		rp.clickOnButton();
		rp.clickOnButton();
		rp.clickOnButton();
		rp.clickOnConfirm();
		rp.clickOnStart();
		rp.clickOnConfirmRight();
		rp.clickOnEndVisit();
		rp.clickOnYes();
		String expectedtext=rp.readStringData(10,2);
		String actualtext=rp.textOfNoactivevisit();
		Assert.assertEquals(actualtext,expectedtext);
		
		
		
		
		
	}

}
