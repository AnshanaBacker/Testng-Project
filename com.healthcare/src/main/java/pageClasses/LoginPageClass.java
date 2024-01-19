package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public LoginPageClass (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='Registration Desk']")
	WebElement registrationDesk;
		
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	@FindBy(id="error-message")
	WebElement errorMessage;
	
	public void login(String uname,String passwd)
	{   
		gl.clickElement(username);
	   	gl.typeElement(username,uname);
	   	gl.typeElement(password, passwd);
	   	gl.clickElement(registrationDesk);
	   	gl.clickElement(loginButton);
	}
	
	
	public String getTextOfErrorMessage()
	{
		return gl.getTextOfElement(errorMessage);
		
	}
	
	public String getUrlOfWebpage()
	{
		return gl.getCurrentUrlOfPage(driver);
	}
	}
