package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectClasses.CourseraHomePage;
import pageObjectClasses.SearchResult;
import utilities.ExcelUtility;

//@Listeners(utilities.ExtentReportCreator.class)
public class Test_001_CourseraSearchWebDev extends ReusableComponents{

	
	@Test(priority=0)
	public void searchCourses() throws IOException, InterruptedException {
		CourseraHomePage ch=new CourseraHomePage(driver);
		SearchResult res=new SearchResult(driver);
		ExcelUtility eu=new ExcelUtility();
		ch.searchCourse();
		ch.selectLanguage();
		Thread.sleep(3000);
		ch.selectLevel();
		ch.scrollToCourse();
		
		ch.selectFirstCourse();
		ch.changeDriver();
		Thread.sleep(5000);
		String courseTitle1=res.getCourseTitle();
		eu.setData(0, 0, "Course - 1 Title");
		eu.setData(0, 1, courseTitle1);
		String courseRating1=res.getRating();
		eu.setData(1, 0, "Course - 1 Rating");
		eu.setData(1, 1, courseRating1);
		int duration=res.getDuration();
		eu.setData(2, 0,"Course - 1 duration in hours");
		eu.setData(2,1, String.valueOf(duration));
		System.out.println(duration);
		
		res.closeChildWindow();
		//ch.switchToParentWindow();
		ch.selectSecondCourse();
		ch.changeDriver();
		Thread.sleep(5000);
		String courseTitle2=res.getCourseTitle();
		eu.setData(3, 0, "Course - 2 Title");
		eu.setData(3, 1, courseTitle2);
		String courseRating2=res.getRating();
		eu.setData(4, 0, "Course - 2 Rating");
		eu.setData(4, 1, courseRating2);
		int duration2=res.getDuration();
		eu.setData(5, 0,"Course - 2 duration in hours");
		eu.setData(5,1, String.valueOf(duration2));
		System.out.println(duration2);
		System.out.println(courseTitle1);
		System.out.println(courseRating1);
		System.out.println(courseTitle2);
		System.out.println(courseRating2);
		res.closeChildWindow();
	}
}
