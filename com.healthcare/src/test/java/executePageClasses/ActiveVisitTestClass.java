package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ActiveVisitPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientClass;
import retryAnalyzer.RetryAnalyzer;

public class ActiveVisitTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientClass rp;
	ActiveVisitPageClass ap;

	@Test(dataProvider = "SuccessfulLogin", dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
	public void verifyThePatientIsInActivevisitPagewhileStartVisit(String uname1, String passwd1) throws IOException, InterruptedException {

		lp = new LoginPageClass(driver);
		lp.login(uname1, passwd1);

		hp = new HomePageClass(driver);
		hp.clickonRegister();

		rp = new RegisterAPatientClass(driver);
		rp.enterName(rp.readStringData(5,3));
		rp.enterFamilyName(rp.readStringData(6,3));
		rp.clickOnButton();
		rp.clickOnGender(1);
		rp.clickOnButton();
		rp.clickOnButton();
		rp.enterBirthDay(rp.readIntegerData(7,3));
		rp.selectBirthMonth(4);
		rp.enterBirthYear(rp.readIntegerData(8,3));
		rp.clickOnButton();
		rp.enterAddress(rp.readStringData(9,3));
		rp.clickOnButton();
		rp.clickOnButton();
		rp.clickOnButton();
		rp.clickOnConfirm();
		rp.clickOnStart();
		rp.clickOnConfirmRight();
		rp.clickHomeicon();
        hp.clickOnActiveVisit();

		ap = new ActiveVisitPageClass(driver);
		Boolean find = ap.isActivevisitNameDisplayed(ap.readStringData(10,3));
		System.out.println(find);
		Assert.assertTrue(find);

	}

	
}
