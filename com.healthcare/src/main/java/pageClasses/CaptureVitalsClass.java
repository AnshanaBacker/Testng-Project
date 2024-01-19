package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class CaptureVitalsClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public CaptureVitalsClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="w8")
	WebElement height;
	
	@FindBy(id="next-button")
	WebElement button;
	
	@FindBy(id="w10")
	WebElement weight;
	
	@FindBy(id="w12")
	WebElement temperature;
	
	@FindBy(id="w14")
	WebElement pulse;
	
	@FindBy(id="w18")
	WebElement lowBP;
	
	@FindBy(id="w20")
	WebElement highBP;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
	@FindBy(xpath="//i[@class='icon-caret-right']")
	WebElement showDetails;
	
	@FindBy(xpath="//div[@class='encounter-summary-container']")
	WebElement details;
	
	public void enterHeight(String hgt)
	{
		gl.typeElement(height,hgt);
	}
	public void clickonButton()
	{
		gl.clickElement(button);
	}
	public void enterWeight(String wght)
	{
		gl.typeElement(weight,wght);
	}
	public void enterTemperature(String temp)
	{
		gl.typeElement(temperature,temp);
	}
	public void enterPulse(String pul)
	{
		gl.typeElement(pulse,pul);
	}
	public void enterlowBP(String low)
	{
		gl.typeElement(lowBP,low);
	}
	public void enterHighBp(String high)
	{
		gl.typeElement(highBP,high);
	}
	public void clickonSave()
	{
			gl.clickElement(save);
	}
	public void clickonShowDeatils()
	{
			gl.clickElement(showDetails);
	}
	public Boolean detailsDisplayed()
	{
		return gl.elementIsDisplayed(details);
	}
	
	
}
