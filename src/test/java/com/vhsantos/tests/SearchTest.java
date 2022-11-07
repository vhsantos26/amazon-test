package com.vhsantos.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vhsantos.pages.HomePage;

public class SearchTest {

	private HomePage homePage;
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/Users/victorhugo/Downloads/chromedriver");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}
	
	@Test
	public void test_totalOfSearchResult() throws InterruptedException {
		
		driver.navigate().to("https://www.amazon.com/");
		
		homePage.performSearch("wooden spoon");
		
		Assert.assertTrue(homePage.getHeaderResult().isDisplayed());
		
		System.out.println(homePage.getHeaderResult().getText().substring(13, 18));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
