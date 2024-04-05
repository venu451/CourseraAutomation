package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClasses.Enterprises;
import testBase.ReusableComponents;

public class TC4enterprises extends ReusableComponents {
	static Enterprises obj5;
	
	@Test(priority=0,groups= {"sanity"})
	public void forEnterprise() throws IOException {
		obj5 = new Enterprises(driver);
        obj5.clkEnterprises();
        logger.info("----- forEnterprises method runs succesful------");
	}
	
	@Test(priority=1)
	public void submitForm() throws IOException {
		obj5 = new Enterprises(driver);
		obj5.filltheform();
		obj5.errormsg();
		logger.info("------error message is shown------");
	}

}
