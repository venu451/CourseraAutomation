package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CucumberReusableComponents {
	public static WebDriver driver;
	
	public static WebDriver initializeBrowser() {
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
