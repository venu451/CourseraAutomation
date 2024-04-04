package testCases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ReusableComponents {

	public static WebDriver driver;
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	public ReusableComponents() {
		
	}
	@BeforeTest
	@Parameters({"browser"})
	public void InitializeBrowser(String br) throws IOException {
		
		if(br.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(br.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println(br+" browser is not available");
			return ;
		}
		driver.get("https://www.coursera.org/");
		driver.manage().window().maximize();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date d=new Date();
		String stamp=sdf.format(d);
		fos=new FileOutputStream(System.getProperty("user.dir")+"//ExcelData//"+stamp+".xlsx");
		wbook=new XSSFWorkbook();
		sheet=wbook.createSheet();
	}
	@AfterTest
	public void closeBrowser() throws IOException {
		wbook.write(fos);
		wbook.close();
		fos.close();
		driver.quit();
	}
public static String captureScreen( WebDriver d) 
	
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)d;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+"_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
}
