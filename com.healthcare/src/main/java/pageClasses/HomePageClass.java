package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	ExplicitWaitClass ew=new ExplicitWaitClass();
	
	public HomePageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//h4[contains(text(),'Logged')]")
	WebElement LoggedInAsAdmin;
	
	@FindBy(xpath="//a[@href='/openmrs/referenceapplication/home.page']")
	WebElement openMRS;
	
	@FindBy(xpath="//*[@class='icon-user small']")
	WebElement adminIcon;
	
	@FindBy(xpath="//*[@class='nav-item identifier']")
	WebElement admin;
	
	@FindBy(id="selected-location")
	WebElement registrationDesk;
	
	@FindBy(className="icon-search")
	WebElement findPatientRecord;
	
	@FindBy(xpath="(//i[@class='icon-calendar'])[1]")
	WebElement activeVisits;
	
	@FindBy(className="icon-vitals")
	WebElement captureVitals;
	
	@FindBy(xpath="(//*[@class='icon-user'])[1]")
	WebElement registeraPatient;
	
	@FindBy(xpath="//*[@class='icon-calendar'])[2]")
	WebElement appointmentScheduling;
	
	@FindBy(className="icon-list-alt")
	WebElement reports;
	
	@FindBy(className="icon-hdd")
	WebElement dataManagement;
	
	@FindBy(className="icon-tasks")
	WebElement configureData;
	
	@FindBy(className="icon-cogs")
	WebElement systemConfiguration;
	
    @FindBy(xpath="//a[@class='btn btn-default btn-lg button app big align-self-center']")
    List<WebElement> allTiles;
    
    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement logOut;
    
    @FindBy(xpath="//i[@class='icon-lock small']")
    WebElement loginIcon;
    
    public Boolean isAllTilesDisplayed()
    {
    	for(WebElement e:allTiles)
    	{
    		gl.elementIsDisplayed(e);
    		return true;
    	}
		
    	return false;
    }
    
		
	public String getTextOfAdminMessage()
	{
		return gl.getTextOfElement(LoggedInAsAdmin);
	}

	public void clickOnFindpatient()
	{
		gl.clickElement(findPatientRecord);
	}
	public void clickonRegister()
	{
		gl.clickElement(registeraPatient);
	}
	public void clickOnActiveVisit()
	{
		ew.visibilityOfElementWait(driver,activeVisits);
		gl.clickElement(activeVisits);
	}
	public void clickOnLogout()
	{
		gl.clickElement(logOut);
	}
	public Boolean iconIsDisplayed()
	{
		return gl.elementIsDisplayed(loginIcon);
	}
	

	public void clickOnCaptureVitals()
	{
		gl.clickElement(captureVitals);
	}
}