package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userrole_page_requests 
{
	@FindBy(xpath = "//b[contains(text(),'Admin')]")
	public static WebElement Adminlink;
	
	@FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
	public static WebElement UsermanageLink;

	@FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
	public static WebElement Users;

	@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
	public static WebElement User_role;
	
	@FindBy(xpath = "//select[@id='searchSystemUser_status']")
	public static WebElement status;
	
	@FindBy(xpath = "//input[@id='searchBtn']")
	public static WebElement search;
	
	@FindBy(xpath = "//tr[1]//td[3]")
	public static WebElement searchuserroleresult;
	
	@FindBy(xpath = "//tr[1]//td[5]")
	public static WebElement searchresultstatus; 
	
}
