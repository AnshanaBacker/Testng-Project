package utilities;



import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class GeneralUtilities {
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	public void typeElement(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
	}
	public Boolean elementIsDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public String getCurrentUrlOfPage(WebDriver driver)//Browser commands
	{
		return driver.getCurrentUrl();
	}
	public String getTitleOfPage(WebDriver driver)
	{
		return driver.getTitle();
	}
	public void clickUsingJs(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void scrollToElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void toAcceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void toDismissAler(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String toGetTextOfAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void typeInAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	public void toSelectElementByIndex(WebElement element,int num)
	{
		Select select=new Select(element);
		select.selectByIndex(num);
	}
	public void toSelectElementByVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void toSelectElementByValue(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByValue(text);
	}
	
	public String readStringData(int row,int column) throws IOException
	{
		return ExcelReadClass.getStringdata(row,column);
		
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.getIntegerdata(row,column);
	}
	
	
	
	
	
	
	
	
    
}
