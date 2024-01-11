package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	
	public void presenceOfElementLocatedWaitID(WebDriver driver,String locatorValue)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
	}
	public void presenceOfElementLocatedWaitXpath(WebDriver driver,String locatorValue)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
	}
	public void elementToBeClickableWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public void visibilityOfElementWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void elementToBeSelectedWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
	public void alertIsPresentWait(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	

}
