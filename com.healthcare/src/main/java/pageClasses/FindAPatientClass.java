package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class FindAPatientClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public FindAPatientClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//table[@id='patient-search-results-table']//tr")
	List<WebElement> row;
	
	@FindBy(xpath="//table[@id='patient-search-results-table']//th")
	List<WebElement> column;
	
	@FindBy(xpath="//table[@id='patient-search-results-table']//tr[3]//td[2]")
	WebElement nameonTable;
	
	@FindBy(xpath="(//*[contains(text(),'sam')])[4]")
	WebElement middleName;
	
	@FindBy(xpath="//table[@id='patient-search-results-table']//tr[1]//td[2]")
	WebElement rodrigoSocolosky;
	
	@FindBy(id="org.openmrs.module.coreapps.createVisit")
	WebElement startVisit;
	
	@FindBy(id="start-visit-with-visittype-confirm")
	WebElement confirm;
	
	@FindBy(xpath="//div[contains(text(),'Active')]")
	WebElement activeVisit;
	
	@FindBy(xpath="(//*[contains(text(),'10012R')])[1]")
    WebElement number;
	

	
	
	public Boolean isPatientNameDisplayed(String name)
	{
		int rowCount = row.size();   
		int colCount = column.size();	
		System.out.println(rowCount+"  "+colCount);   
		
		boolean flag = false;
		
		for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<colCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='patient-search-results-table']//tr["+row+"]//td["+col+"]")).getText();
				if (actValue.equalsIgnoreCase(name)) {
					
					flag = true;  
					System.out.println(row+" : "+col); 
					break;
					
				}
			}
}
		if (flag) {  
			return true;
		}
		return flag;
		
	}
	public void clickOnName()
	{
		gl.clickElement(nameonTable);
		
	}
	public Boolean nameDisplayed()
	{
		return gl.elementIsDisplayed(number);
		
	}
	
	
	

	}
	
	
	

