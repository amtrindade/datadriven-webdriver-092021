package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DetailPage {

	public String getTextTitle() {
		WebElement labelTitle = getDriver().findElement(By.id("firstHeading"));
		return labelTitle.getText();
	}

}
