package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ReusableComponents {

	public static WebDriver driver;
	public ReusableComponents() {
		
	}
	@BeforeSuite
	public void InitializeBrowser() {
		driver=new ChromeDriver();
		driver.get("https://www.coursera.org/");
		driver.manage().window().maximize();
	}
//	@AfterSuite
//	public void closeBrowser() {
//		driver.close();
//	}
	
}
