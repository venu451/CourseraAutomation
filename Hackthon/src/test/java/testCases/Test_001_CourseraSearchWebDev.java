package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClasses.CourseraHomePage;
import pageObjectClasses.SearchResult;

public class Test_001_CourseraSearchWebDev extends ReusableComponents{

	
	@Test(priority=0)
	public void searchCourses() throws IOException, InterruptedException {
		CourseraHomePage ch=new CourseraHomePage(driver);
		SearchResult res=new SearchResult(driver);
		ch.searchCourse();
		ch.selectLanguage();
		Thread.sleep(3000);
		ch.selectLevel();
		ch.scrollToCourse();
		
		ch.selectFirstCourse();
		ch.changeDriver();
		Thread.sleep(5000);
		String courseTitle1=res.getCourseTitle();
		String courseRating1=res.getRating();
		int duration=res.getDuration();
		System.out.println(duration);
		
		res.closeChildWindow();
		//ch.switchToParentWindow();
		ch.selectSecondCourse();
		ch.changeDriver();
		Thread.sleep(5000);
		String courseTitle2=res.getCourseTitle();
		String courseRating2=res.getRating();
		int duration2=res.getDuration();
		System.out.println(duration2);
		System.out.println(courseTitle1);
		System.out.println(courseRating1);
		System.out.println(courseTitle2);
		System.out.println(courseRating2);
		res.closeChildWindow();
	}
}
