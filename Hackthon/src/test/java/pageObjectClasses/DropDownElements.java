package pageObjectClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.ExcelUtility;

public class DropDownElements extends BasePage {
	ExcelUtility eu;
	public DropDownElements(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By language_learning=By.xpath("//header/div/div/div[2]/div[1]/div[2]/div/div/nav/div/div/div[1]/div/div/div[2]/ul/li[5]");
	//header/div/div/div[2]/div[1]/div[2]/div/div/nav/div/div/div[2]/div[9]/div/section/div/div[2]/div[2]/div[2]/ul/li[2]
	By allLanguages=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[1]/div/a");
	
	By chines=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[2]/div/a");
	By english=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[3]/div/a");
	By french=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[4]/div/a");
	By korean=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[5]/div/a");
	By mandarin=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[6]/div/a");
	By spanish=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[7]/div/a");
	By toesl=By.xpath("//ul[@aria-labelledby=\"Language-Learning-tab-Popular-skills-title\"]/li[8]/div/a");
	
	By levels=By.xpath("//div[@data-testid=\"search-filter-group-Level\"]/div/div/div/label/div/span/span");
	By levelCount=By.xpath("//div[@data-testid=\"search-filter-group-Level\"]/div/div/div/label/div/span/span/span");
	
	public void clickOnLanguageLearning() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-e2e='megamenu-item~language-learning']"))).click();
//		driver.findElement(language_learning).click();
	}
	public void clickOnAllLanguages() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(allLanguages))).click();
	}
	public void clickOnchines() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(chines))).click();
	}
	public void clickOnEnglish() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(english))).click();
	}
	public void clickOnFrench() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(french))).click();
	}
	public void clickOnKorean() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(korean))).click();
	}
	public void clickOnmandarin() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(mandarin))).click();
	}
	public void clickOnSpanish() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(spanish))).click();
	}
	public void clickOnToesl() {
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(toesl))).click();
	}
	public void verifyLanguagePage() {
		String s=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-e2e=\"NumberOfResultsSection\"]/span"))).getText();
		if(s.contains("Language Courses")) {
			System.out.println("page loaded");
		}
	}
	By showmore=By.xpath("//div[@data-testid=\"search-filter-group-Language\"]/div[2]/button/span");
	By boxCheck=By.xpath("//div[@data-testid=\"scroll-container\"]/div/h2");
	//By eng=By.xpath("//div[@id=\"checkbox-group\"]/div[2]/label/div/span/span");
	By allLanguageCheckBoxes=By.xpath("//div[@id=\"checkbox-group\"]/div/label/div/span/span");
	By close=By.xpath("//div[@aria-labelledby=\"checkbox-group\"]/div/button/span");
	public List<Map<String,String>> getCount() throws InterruptedException, IOException {
		eu=new ExcelUtility("Levels_Courses");
		List<WebElement> lev=driver.findElements(levels);
		
		JavascriptExecutor jsp=(JavascriptExecutor)driver;
		jsp.executeScript("arguments[0].scrollIntoView(false);",lev.get(3));
		List<Map<String,String>> finalList=new ArrayList<>();
		for(int i=0;i<lev.size();i++) {
			Map<String,String> map=new HashMap<String,String>();
			System.out.println("----------------");
			String temp=lev.get(i).getText();
			String [] hh=temp.split(" ");
			System.out.println(hh[0]);
			System.out.println(hh[1].substring(1,hh[1].length()-1));
			lev.get(i).click();
			jsp.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(showmore));
			driver.findElement(showmore).click();
			try {
				if(driver.findElement(boxCheck).getText().contains("Language")){
					List<WebElement> ll=driver.findElements(allLanguageCheckBoxes);
					Thread.sleep(3000);
					for(WebElement each:ll) {
						String languagecheckbox=each.getText();
						String [] language_count=languagecheckbox.split(" ");
						if(language_count.length==3) {
							map.put(language_count[0], language_count[1].substring(1,language_count[2].length()-1));
						}else {
						map.put(language_count[0], language_count[1].substring(1,language_count[1].length()-1));
						}
						System.out.println(language_count[0]);
						System.out.println(language_count[1].substring(1,language_count[1].length()-1));
					}
				}
			}catch(Exception e) {
				List<WebElement> ll=driver.findElements(allLanguageCheckBoxes);
				Thread.sleep(3000);
				for(WebElement each:ll) {
					String languagecheckbox=each.getText();
					String [] language_count=languagecheckbox.split(" ");
					map.put(language_count[0], language_count[1].substring(1,language_count[1].length()-1));
					System.out.println(language_count[0]);
					System.out.println(language_count[1].substring(1,language_count[1].length()-1));
				}
				finalList.add(map);
			}
			driver.findElement(close).click();
			jsp.executeScript("arguments[0].scrollIntoView(false);",lev.get(3));
			lev.get(i).click();
		}
		eu.setCucumberData(0,0,finalList);
		eu.closeExcel();
		return finalList;
		
	}
}
