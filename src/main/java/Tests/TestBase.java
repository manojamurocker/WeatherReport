package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {   

		String browser=System.getProperty("browser","firefox");
		String execution=System.getProperty("executions","local");
		DesiredCapabilities caps=new DesiredCapabilities();

		if(execution.equalsIgnoreCase("local")) {
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","./drivers/geckodriver_76" );  
				// Initialize Gecko Driver using Desired Capabilities Class  
				FirefoxOptions options = new FirefoxOptions().addPreference("marionette",true);
				// capabilities.setCapability();  
				driver = new FirefoxDriver(options);
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{

			}
		}
		else if(execution.equalsIgnoreCase("remote")) {
			if(browser.equalsIgnoreCase("firefox")) {
				caps=new DesiredCapabilities();
				caps.setBrowserName("firefox");
				caps.setPlatform(Platform.LINUX);
				driver=new RemoteWebDriver(new URL("url/wd/hub"), caps);
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				caps.setBrowserName("chrome");
				caps.setPlatform(Platform.LINUX);
				caps.setVersion("83");
				driver=new RemoteWebDriver(new URL("url/wd/hub"), caps);
			}
		}




	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	@Test(invocationCount=1, threadPoolSize=1)
	public void remoteTest_firefox() throws MalformedURLException {

		driver.get("https://social.ndtv.com/static/Weather/report/");

	}

}
