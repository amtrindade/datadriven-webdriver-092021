package com.core;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public abstract class BaseTest {
	
	@AfterMethod
	public void tearMethod(ITestResult testResult) throws IOException {
		File scr = ((TakesScreenshot)DriverFactory.getDriver())
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr , 
				new File("target"+ File.separator + testResult.getName()+"_"+ new Date() +".jpg"));
	}
	
	@AfterTest
	public void tearDown() throws IOException {
		DriverFactory.killDriver();
	}

}
