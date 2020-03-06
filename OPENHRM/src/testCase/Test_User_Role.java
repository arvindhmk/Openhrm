package testCase;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfuntions.commonfunction;
import pageobjects.userrole_page_requests;

public class Test_User_Role extends commonfunction 
{
	@Test
	public void checkuserrole()
	{
		PageFactory.initElements(driver, userrole_page_requests.class);
		Actions act = new Actions(driver);
		
		act.moveToElement(userrole_page_requests.Adminlink);
		act.moveToElement(userrole_page_requests.UsermanageLink);
		act.moveToElement(userrole_page_requests.Users).click();
		act.build().perform();
		selectuserrole();
		selectstatus();
		userrole_page_requests.search.click();
		
		String actualuserRole = userrole_page_requests.searchuserroleresult.getText();
		String actualstatus = userrole_page_requests.searchresultstatus.getText();
		
		Assert.assertEquals(actualuserRole, "Admin");
		Assert.assertEquals(actualstatus, "Enabled");
		
	}
	
		public void selectuserrole() 
		{
		Select selrole = new Select(userrole_page_requests.User_role);
		selrole.selectByIndex(1);
		}
		
		public void selectstatus()
		{
			Select selstatus = new Select(userrole_page_requests.status);
			selstatus.selectByIndex(1);
		}	
}
