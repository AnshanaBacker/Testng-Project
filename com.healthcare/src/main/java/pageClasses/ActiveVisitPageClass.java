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

public class ActiveVisitPageClass {

	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	

	
	
	public ActiveVisitPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//div[@class='active-visit-started-at-message']")
	WebElement visit;
	
	@FindBy(xpath="//table[@id='active-visits']//tr")
	List<WebElement> row1;
	
	@FindBy(xpath="//table[@id='active-visits']//th")
	List<WebElement> column1;
	
	
	
	public Boolean textDisplayed()
	{
		return gl.elementIsDisplayed(visit);
	}
	

	public Boolean isActivevisitNameDisplayed(String name)
	{
		
		int rowCount = row1.size();   
		int colCount = column1.size();	
		System.out.println(rowCount+"  "+colCount);   
		
		boolean flag = false;
		
		for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<colCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='active-visits']//tr["+row+"]//td["+col+"]")).getText();
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

	public String readStringData(int row,int column) throws IOException
	{
		return ExcelReadClass.getStringdata(row,column);
		
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.getIntegerdata(row,column);
	}
}
