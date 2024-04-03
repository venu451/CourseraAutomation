package pageObjectClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CourseraHomePage extends BasePage{
	
	public CourseraHomePage(WebDriver driver) throws IOException {
		super(driver);
		
	}

	// @CacheLookup This annotation, when applied over a WebElement, instructs Selenium to keep a 
	//cache of the WebElement instead of searching for the WebElement every time from the WebPage. 
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']") @CacheLookup 
	private WebElement searchBox;
	//search button
	@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']") @CacheLookup
	private WebElement submitSearch;

// beginers level check box
	@FindBy(xpath="(//input[@id='cds-react-aria-89'])[1]") @CacheLookup 
	private WebElement beginerLevelCheckBox;
	// english check box
	@FindBy(xpath="(//input[@id='cds-react-aria-51'])[1]") @CacheLookup 
	private WebElement englishLanguageCheckBox;
	
	//after beginer and english click on first course and title of course 
	@FindBy(xpath="//h1[normalize-space()='Meta Front-End Developer Professional Certificate']") @CacheLookup
	private WebElement course1Title;
	//rating
	@FindBy(xpath="(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121']") @CacheLookup
	private WebElement rating1;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[1]/div[2]/section/div[2]/div[3]/div[1]") @CacheLookup
	private WebElement duration;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/div/main/div[1]/div/div/div/div/div[2]/ul/li[1]") @CacheLookup
	private WebElement firstCourse;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/div/main/div[1]/div/div/div/div/div[2]/ul/li[1]") @CacheLookup
	private WebElement secondCourse;
	public void searchCourse() {
		mywait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(p.getProperty("searchCategory"));
		submitSearch.click();
	}
	public void selectLanguage() {
		englishLanguageCheckBox.click();
	}
	public void selectLevel() {
		beginerLevelCheckBox.click();
	}
	
	public void selectFirstCourse(){
		firstCourse.click();
	}
	public String getCourseTitle() {
		return course1Title.getText();
	}
	public String getRating() {
		return rating1.getText();
	}
	public int getDuration() {
		String rawDuration=duration.getText();
		String[] temp1=rawDuration.split("months");
		String rawMonths=temp1[0].strip();
		int months=Integer.parseInt(rawMonths);

		String[] temp2=temp1[1].split("hours");
		//temp2=[" at 6 "," a week"]
		String rawHours="";
		for(int asci=0;asci<temp2[0].length();asci++) {
			if((int)temp2[0].charAt(asci)>=48 && (int)temp2[0].charAt(asci)<=57) {
				rawHours+=temp2[0].charAt(asci);
			}
		}
		int hours=Integer.parseInt(rawHours);
		return months*hours;
	}
	
	public void selectSecondCourse(){
		firstCourse.click();
	}

//	Set<String> ids = driver.getWindowHandles();
//	List<String> lis = new ArrayList<String>(ids);
//	String parent = lis.get(0);
//	String child = lis.get(1);
//	driver.switchTo().window(child);
}
