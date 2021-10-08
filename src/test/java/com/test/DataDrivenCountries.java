package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.SpreadSheetData;
import com.page.DetailPage;
import com.page.MainPage;

public class DataDrivenCountries extends BaseTest{
	
	private MainPage main;
	private DetailPage detail;
	

	@Test(dataProvider = "countriesList")
	public void testValidateContries(String searchCountry, String expectedCoutry) {
		main = new MainPage();
		detail = main.open().search(searchCountry);
		assertEquals(detail.getTextTitle(), expectedCoutry);		
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderList() {
		return new Object[][] {
			{"India", "India"},			
			{"Brazil", "Brasil" },
			{"Brasil", "Brazil" },
			{"Argentina", "Argentina"},
			{"Italy", "Italy"},
			{"Venezuela", "Venezuela"},
			{"United States", "United States"}			
		};
	}
	
	@Test(dataProvider = "countriesExcel")
	public void testValidateContriesExcel(String searchCountry, String expectedCoutry) {
		main = new MainPage();
		detail = main.open().search(searchCountry);
		assertEquals(detail.getTextTitle(), expectedCoutry);	
	}
	
	@DataProvider(name = "countriesExcel")
	public Object[][] dataProviderExcel() {
		Object[][] testData = SpreadSheetData
				.readExcelData("Paises", "src/test/resources/paises.xls", "Dados");
		return testData;
	}

}
