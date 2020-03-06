package commonfuntions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commonfunction 
{
	public static Properties prop=null;
	public static WebDriver driver=null;
	
	Logger logger = Logger.getLogger(commonfunction.class);
	
	public Properties loadpropertyfile() throws IOException
	{
			FileInputStream fis= new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(fis);
		
		return prop;
	}
	
	
	@BeforeSuite
	public void launchbrowser() throws IOException
	{
		PropertyConfigurator.configure("log4j.properties");
		loadpropertyfile();
		logger.info("loading property file");
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String driverlocch= prop.getProperty("DriverLocationchrome");
	
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverlocch);
			 driver=new ChromeDriver();
			 logger.info("Invoking chrome");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",driverlocch);
			 driver=new FirefoxDriver();
			 logger.info("Invoking firefox");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		logger.info("Navigating to application");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void teardown()
	{
	
		driver.quit();
		logger.info("CLosing browser");
	}
}
