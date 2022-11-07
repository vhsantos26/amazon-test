package com.vhsantos.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchInput;
	
	@FindBy(xpath = "//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div")
	private WebElement headerResult;

	public WebElement getSearchInput() {
		wait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(200))
			.until(ExpectedConditions.visibilityOf(searchInput));
		return searchInput;
	}

	public void setSearchInput(WebElement searchInput) {
		this.searchInput = searchInput;
	}
	
	public void performSearch(String text) {
		this.getSearchInput().sendKeys(text);
		this.getSearchInput().sendKeys(Keys.ENTER);
	}

	public WebElement getHeaderResult() {
		wait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(200))
			.until(ExpectedConditions.visibilityOf(headerResult));
		return headerResult;
	}

	public void setHeaderResult(WebElement headerResult) {
		this.headerResult = headerResult;
	}
	
}
