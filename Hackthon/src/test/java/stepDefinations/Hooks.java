package stepDefinations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.CucumberReusableComponents;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	WebDriverWait mywait;
	@Before
	public void startup() throws FileNotFoundException {
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//		Date d=new Date();
//		String stamp=sdf.format(d);
//		fos=new FileOutputStream(System.getProperty("user.dir")+"//ExcelData//"+stamp+".xlsx");
//		wbook=new XSSFWorkbook();
//		sheet=wbook.createSheet();
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
