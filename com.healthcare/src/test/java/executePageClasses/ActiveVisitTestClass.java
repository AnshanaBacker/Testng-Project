package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ActiveVisitPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.GeneralUtilities;

public class ActiveVisitTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientClass rp;
	ActiveVisitPageClass ap;
	GeneralUtilities gl;

	@Test(dataProvider = "SuccessfulLogin", dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
	public void verifyThePatientIsInActivevisitPagewhileStartVisit(String uname1, String passwd1) throws IOException, InterruptedException {

		lp = new LoginPageClass(driver);
		lp.login(uname1, passwd1);

		hp = new HomePageClass(driver);
		hp.clickonRegister();
		gl=new GeneralUtilities();

		rp = new RegisterAPatientClass(driver);
		rp.enterName(gl.readStringData(5,3));
		rp.enterFamilyName(gl.readStringData(6,3));
		rp.clickOnButton();
		rp.clickOnGender(1);
		rp.clickOnButton();
		rp.clickOnButton();
		rp.enterBirthDay(gl.readIntegerData(7,3));
		rp.selectBirthMonth(4);
		rp.enterBirthYear(gl.readIntegerData(8,3));
		rp.clickOnButton();
		rp.enterAddress(gl.readStringData(9,3));
		rp.clickOnButton();
		rp.clickOnButton();
		rp.clickOnButton();
		rp.clickOnConfirm();
		rp.clickOnStart();
		rp.clickOnConfirmRight();
		rp.clickHomeicon();
        hp.clickOnActiveVisit();

		ap = new ActiveVisitPageClass(driver);
		Boolean find = ap.isActivevisitNameDisplayed(gl.readStringData(10,3));
		System.out.println(find);
		Assert.assertTrue(find);

	}

	
}
