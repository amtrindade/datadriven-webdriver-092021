package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.DriverFactory;

public class MainPage {
	
	public MainPage open() {
		DriverFactory.getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
		return this;
	}

	public DetailPage search(String searchCountry) {
		WebElement tfSearch = getDriver().findElement(By.id("searchInput"));
		tfSearch.sendKeys(searchCountry);
		
		WebElement btSearch = getDriver().findElement(By.id("searchButton"));
		btSearch.click();
		
		return new DetailPage();
	}

}
