package screenshot;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class ScreenshotUtility {
	
	public static void getScreenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./src/screenshots/img1.png");
		FileHandler.copy(sourceFile, destinationFile);
		
	}

}
