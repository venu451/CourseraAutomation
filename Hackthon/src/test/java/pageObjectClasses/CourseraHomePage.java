package pageObjectClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CourseraHomePage {
	// @CacheLookup This annotation, when applied over a WebElement, instructs Selenium to keep a 
	//cache of the WebElement instead of searching for the WebElement every time from the WebPage. 
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']") @CacheLookup private WebElement whatDoYouWantToLearn;
	//search button
	@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']") @CacheLookup private WebElement submitSearch;

	public void searchCourse() {
		
	}
// beginers level check box
	@FindBy(xpath="(//input[@id='cds-react-aria-89'])[1]") @CacheLookup private WebElement beginerLevelCheckBox;
	// english check box
	@FindBy(xpath="(//input[@id='cds-react-aria-51'])[1]") @CacheLookup private WebElement englishLanguageCheckBox;
	
	//after beginer and english click on first course and title of course 
	@FindBy(xpath="//h1[normalize-space()='Meta Front-End Developer Professional Certificate']") @CacheLookup private WebElement course1Title;
	//rating
	@FindBy(xpath="(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121']") @CacheLookup private WebElement rating1;

	
	
//	Set<String> ids = driver.getWindowHandles();
//	List<String> lis = new ArrayList<String>(ids);
//	String parent = lis.get(0);
//	String child = lis.get(1);
//	driver.switchTo().window(child);
}
