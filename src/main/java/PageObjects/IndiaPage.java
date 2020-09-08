package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndiaPage {
	
	@FindBy(xpath="//div[text()='Sections']")
	private WebElement tab_sections;
	
	@FindBy(xpath="//h1[text()='India News']")
	private WebElement header_indiaNews;
	
	@FindBy(xpath="//a[text()='Weather']")
	private WebElement link_weather;
	
	WebDriver driver;
	public IndiaPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, IndiaPage.class);
		header_indiaNews.isDisplayed();
	}
	
	private void clickOnSectionTab() {
		tab_sections.click();
	}
	
	private void clickOnWeatherLink() {
		link_weather.click();
	}
	
	public WeatherPage navigateToWeatherPage() {
		clickOnSectionTab();
		clickOnWeatherLink();
		return new WeatherPage(driver);
	}

}
