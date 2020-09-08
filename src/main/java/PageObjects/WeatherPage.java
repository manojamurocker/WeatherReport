package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeatherPage {
	
	@FindBy(css="#searchBox[type='text']")
	private WebElement input_pinCity;
	
	@FindBy(xpath="//a[text()='Weather']")
	private WebElement link_weather;
	
	WebDriver driver;
	public WeatherPage(WebDriver driver) {
		this.driver=driver;
	}

}
