package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[text()='INDIA']")
	private WebElement link_india;
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, HomePage.class);
		link_india.isDisplayed();
	}
	
	public IndiaPage clickOnIndiaLink()
	{
		link_india.click();
		return new IndiaPage(driver);
	}
	

}
