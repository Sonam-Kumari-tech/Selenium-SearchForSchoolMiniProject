package driver;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	
	public static WebDriver driver;
	public static WebDriver getWebDriver() {
	
	// User Input for Browser Selection
		
	System.out.println("Enter 1 for ---> Chrome");
	System.out.println("Enter 2 for ---> Edge");
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	System.out.println("Browser Loading....");
	
	// For Using Multiple Windows
	
	if(num==1) {
		driver=new ChromeDriver();
		}
	else if(num==2) {
		driver=new EdgeDriver();
		}
	else{
		System.out.println("Enter Proper Input");
		}
	System.out.println("Browser Opened.");
			
		
	driver.get("https://www.eduvidya.com/");
	driver.manage().window().maximize();        //window maximize
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait for 10s
	
	//clicking the advanced

	WebElement advance=driver.findElement(By.xpath("//*[@id='details-button']"));
	advance.click();
	
	//clicking the advanced link
	
	WebElement advLink=driver.findElement(By.xpath("//*[@id='proceed-link']"));
	advLink.click();
	
	sc.close(); //Closing the Scanner 
	return driver;
	
	

}
}


