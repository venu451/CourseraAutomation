package pageObjectClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResult extends BasePage {
	
	public SearchResult(WebDriver driver) throws IOException{
		super(driver);
	}
	
	By rating=By.xpath("//main/section[2]/div/div/div[2]/div/div/section/div[2]/div/div");
	By titile=By.xpath("//h1[@data-e2e='hero-title']");
	By durationByText=By.xpath("//div[@data-e2e='key-information']//section/div[2]/div[3]/div[1]");
	By lastElementWhileLoading=By.cssSelector("div#onetrust-consent-sdk");
	
	public void switchToChild() {
		// TODO Auto-generated method stub
		Set<String> se=driver.getWindowHandles();
		List<String> ids=new ArrayList<String>(se);
		String child=ids.get(1);
		driver.switchTo().window(child);
	}
	
	public String getCourseTitle() {	
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(lastElementWhileLoading)));
		return driver.findElement(titile).getText();
	}
	
	public String getRating() {
//		mywait.until(ExpectedConditions.visibilityOf(rating1));
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(lastElementWhileLoading)));
		return driver.findElement(rating).getText();
	}
	
	public int getDuration() {
		
		String rawDuration=driver.findElement(durationByText).getText();
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
		return (months*4)*hours;
	}
	
	public void closeChildWindow() {
		driver.close();
	}
}
