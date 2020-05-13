package testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfuntions.commonfunction;
import pageobjects.dashboard_pageobjects;
import pageobjects.loginpageobjects;

public class Test_Pending_Leave_Request extends commonfunction 
{
	Logger log = Logger.getLogger(Test_Pending_Leave_Request.class);
	
	public void login()
	{
		log.info("Logging application");
		PageFactory.initElements(driver, loginpageobjects.class);
		loginpageobjects.username.sendKeys(prop.getProperty("username"));
		loginpageobjects.password.sendKeys(prop.getProperty("password"));
		loginpageobjects.login.click();
	}
	
	
	@Test
	public void verifyPendingLeaveRequest()
	{
		login();
		log.info("Getting pending leave details");
		PageFactory.initElements(driver, dashboard_pageobjects.class);
		String Actualtext = dashboard_pageobjects.getpendingLeaveRequest().getText();
		Assert.assertEquals(Actualtext, "No Records are Available");
		log.info("Verifiying the Test_Pending_Leave_Request ");
	}
}
