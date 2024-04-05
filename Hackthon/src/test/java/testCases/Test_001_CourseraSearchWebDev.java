package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectClasses.CourseraHomePage;
import pageObjectClasses.SearchResult;
import testBase.ReusableComponents;
import utilities.ExcelUtility;

//@Listeners(utilities.ExtentReportCreator.class)
public class Test_001_CourseraSearchWebDev extends ReusableComponents{
	CourseraHomePage ch;
	SearchResult res;
	ExcelUtility eu;
	
	@Test(priority=0)
	public void searchForCourses() throws IOException, InterruptedException {
		ch=new CourseraHomePage(driver);
		res=new SearchResult(driver);
		eu=new ExcelUtility("testng");
		logger.info("------Searching for web development courses  --------");
		ch.searchCourse();
		logger.info("------shows the available web devolpment courses  --------");
//		ch.selectLanguage();
//		Thread.sleep(3000);
//		ch.selectLevel();
//		ch.scrollToCourse();
//		
//		ch.selectFirstCourse();
//		ch.changeDriver();
		//Thread.sleep(5000);
//		String courseTitle1=res.getCourseTitle();
//		eu.setData(0, 0, "Course - 1 Title");
//		eu.setData(0, 1, courseTitle1);
//		String courseRating1=res.getRating();
//		eu.setData(1, 0, "Course - 1 Rating");
//		eu.setData(1, 1, courseRating1);
//		int duration=res.getDuration();
//		eu.setData(2, 0,"Course - 1 duration in hours");
//		eu.setData(2,1, String.valueOf(duration));
//		System.out.println(duration);
		
//		res.closeChildWindow();
		//ch.switchToParentWindow();
		//ch.selectSecondCourse();
//		ch.changeDriver();
//		Thread.sleep(5000);
//		String courseTitle2=res.getCourseTitle();
//		eu.setData(3, 0, "Course - 2 Title");
//		eu.setData(3, 1, courseTitle2);
//		String courseRating2=res.getRating();
//		eu.setData(4, 0, "Course - 2 Rating");
//		eu.setData(4, 1, courseRating2);
//		int duration2=res.getDuration();
//		eu.setData(5, 0,"Course - 2 duration in hours");
//		eu.setData(5,1, String.valueOf(duration2));
//		System.out.println(duration2);
//		
//		System.out.println(courseTitle2);
//		System.out.println(courseRating2);
//		res.closeChildWindow();
	}
	@Test(priority=1)
	public void Applyfilters() throws InterruptedException{
		logger.info("------clicking on the language(English) and Level(Beginner) checkboxes--------");
		ch.selectLanguage();
		Thread.sleep(3000);
		ch.selectLevel();
		logger.info("------filtered courses is shown -------");
	}
	@Test(priority=2)
	public void selectFirstCourse() throws InterruptedException {
		logger.info("------Clicking on the first course--------");
		ch.scrollToCourse();		
		ch.selectFirstCourse();
		logger.info("------First course details page shown--------");
	}
	@Test(priority=3)
	public void getFirstCourseData() throws InterruptedException {
		logger.info("------Collectiong the title,rating,duration of First Course--------");
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
		try {
		res.closeChildWindow();
		}catch(Exception e) {
			System.out.println("no child window not avalable");
		}
		System.out.println(duration);
		System.out.println(courseTitle1);
		System.out.println(courseRating1);
		logger.info("------Data collected, prints on the console and written on excel file--------");
	}
	@Test(priority=4)
	public void selectSecondCourse() {
		logger.info("------Clicking on the Second course--------");
		ch.selectSecondCourse();
		logger.info("------Second course details page shown--------");
	}
	@Test(priority=5)
	public void getSecondCourseData() throws InterruptedException {
		logger.info("------Collectiong the title,rating,duration of Second Course--------");
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
		System.out.println(courseTitle2);
		System.out.println(courseRating2);
		try {
			res.closeChildWindow();
			}catch(Exception e) {
				System.out.println("no child window not avalable");
		}
		logger.info("------Data collected, prints on the console and written on excel file--------");
	}
}
