package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dashboard_pageobjects 
{
	
	@FindBy(xpath = "//div[@id='task-list-group-panel-menu_holder']//following::td[1]")
	public static WebElement pendingleaveRequest;
	
	
}
