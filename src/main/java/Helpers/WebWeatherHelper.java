package Helpers;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;

public class WebWeatherHelper {
	
	WebDriver driver;
	public WebWeatherHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectCityAndGetWeatherReport() {
		
		HomePage homePage= new HomePage(driver);
	}

}
