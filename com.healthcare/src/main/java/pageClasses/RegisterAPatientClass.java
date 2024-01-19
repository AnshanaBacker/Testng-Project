package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.ExcelReadClass;

import utilities.GeneralUtilities;
import utilities.RandomDataUtility;

public class RegisterAPatientClass {

	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	
	
	public RegisterAPatientClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="givenName")
	WebElement given;
	
	@FindBy(name="familyName")
	WebElement familyName;
	
	@FindBy(id="next-button")
	WebElement button;
	
	@FindBy(id="gender-field")
	WebElement gender;
	
	@FindBy(id="birthdateDay-field")
	WebElement birthDay;
	
	@FindBy(id="birthdateMonth-field")
	WebElement birthMonth;
	
	@FindBy(id="birthdateYear-field")
	WebElement birthYear;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="submit")
	WebElement confirm;
	
	@FindBy(xpath="//div[contains(text(),'Start Visit')]")
	WebElement startVisit;
	
	@FindBy(xpath="(//button[@class='confirm right'])[6]")
	WebElement confirmRight;
	
	@FindBy(xpath="//span[@class='PersonName-familyName']")
	WebElement nameOfFamily;
	
	@FindBy(css=".icon-home.small")
	WebElement homeIcon;
	
	@FindBy(xpath="(//a[@class='button task activelist'])[1]")
	WebElement endVisit;
	
	@FindBy(xpath="(//button[text()='Yes'])[3]")
	WebElement yes;
	
	@FindBy(xpath="//h4[text()='No active visit']")
	WebElement noActiveVisit;
	
	@FindBy(id="referenceapplication.realTime.vitals")
	WebElement captureVitals;
	
	
	public void enterName(String name)
	{
		gl.typeElement(given, name);
		
	}
	public String getFirstName()
	{
		return RandomDataUtility.getfName();
	}
	public void enterFamilyName(String name1)
	{
		gl.typeElement(familyName,name1);
	}
	public String getFamilyName()
	{
		return RandomDataUtility.getFullName();
	}
	public void clickOnButton()
	{
		gl.clickElement(button);
	}
	public void clickOnGender(int num)
	{
		gl.toSelectElementByIndex(gender,num);
		
	}
	
	public void enterBirthDay(String day)
	{
		gl.typeElement(birthDay,day);
	}
	public String getBirthDay()
	{
		return RandomDataUtility.getBirthDayDate();
	}
	public void selectBirthMonth(int num)
	{
		gl.toSelectElementByIndex(birthMonth, num);
	}
	public void enterBirthYear(String year)
	{
		gl.typeElement(birthYear, year);
	}
	public String getBirthYear()
	{
		return RandomDataUtility.getBirthDayYear();
	}
	
	public void enterAddress(String add)
	{
		gl.typeElement(address,add);
	}
	public String getAddress()
	{
		return RandomDataUtility.getFullAddress();
	}
	
	public void clickOnConfirm()
	{
		gl.clickElement(confirm);
	}
	public String textOfFamilyName()
	{
		return gl.getTextOfElement(nameOfFamily);
	}
	public void clickOnStart()
	{
		gl.clickElement(startVisit);
	}
	public void clickOnConfirmRight()
	{
		gl.clickElement(confirmRight);
	}
		
	public void clickHomeicon() 
	{
		gl.clickUsingJs(homeIcon, driver);
	}
	
	public void clickOnEndVisit()
	{
		gl.clickElement(endVisit);
	}
	public void clickOnYes()
	{
		gl.clickElement(yes);
	}
	public String textOfNoactivevisit()
	{
		return gl.getTextOfElement(noActiveVisit);
	}
	public void clickOnCaptureVitals()
	{
		gl.clickElement(captureVitals);
	}
	
	
	
	
	
	
}
