package search;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import driver.DriverSetup;
import excelUtils.ExcelUtils;



public class SearchFunctions {
	
	// Setting up the browser

		public static WebDriver driver;
		public WebDriver setUp() {
		driver=DriverSetup.getWebDriver();
		return driver;
		}
		
		
		//Selecting the School link
		
		public void selectSchool() throws InterruptedException {
		WebElement school=driver.findElement(By.xpath("//a[normalize-space()='Schools']"));
		school.click();
		Thread.sleep(5000);
		}
		
		
		//Selecting the courseType as CBSE
		
		public void selectCourseType(String course) throws InterruptedException {
		Thread.sleep(5000);	
		WebElement drpele1=driver.findElement(By.xpath("//select[@id='ddl_Category']"));
		Select drpCourse=new Select(drpele1);
		drpCourse.selectByVisibleText(course);
		
		}
		
		
		//Selecting the city as Pune
		
		public void selectCity(String city) throws InterruptedException {
		Thread.sleep(5000);		
		WebElement drpele2=driver.findElement(By.xpath("//select[@id='ddl_City']"));
		Select drpCity=new Select(drpele2);
		drpCity.selectByVisibleText(city);
		}
		
		//Clicking the Search Button
		
		public void searchButton() throws InterruptedException {
		Thread.sleep(2000);		
		WebElement search=driver.findElement(By.xpath("//input[@id='btnSearch']"));
		search.click();

		}
		
	
		//Writing Data to Excel O/P
		public void writeData() throws IOException {
		List<WebElement> list=driver.findElements(By.xpath("//div[@class=\'contentblock\']/a"));
		int len=list.size();
		for(int i=0;i<len;i++) {
		WebElement ele= list.get(i);
		String data=ele.getText();
		System.out.println(data);
		ExcelUtils obj=new ExcelUtils();
		obj.setCellData("Write", i, 0, data);
		}
		System.out.println("-------------------------------------------------------------------");
		}
		
		public void getScreenShot() throws IOException
		{
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("./src/screenshots/img1.png");
			FileHandler.copy(sourceFile, destinationFile);
			
		}

		//Closing Browser
		
		public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed");
		}

}
