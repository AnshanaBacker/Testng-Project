package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotClass {

	public void takeScreenShot(WebDriver driver,String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; 
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE); 
																	

		String dest = System.getProperty("user.dir") + "//Test_Evidence"; 
																			
																		
		File f1 = new File(dest);
		if (!f1.exists()) { 
			f1.mkdirs(); 

		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); 
																							

		String destinationPath = System.getProperty("user.dir") + "//Test_Evidence//" + name + timeStamp + ".png"; 
																													
																													
																													
		File finalDestination = new File(destinationPath);
		FileHandler.copy(screenshotFile, finalDestination); 
															

	}

}
