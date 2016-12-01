package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By companyNavigationTab = By.cssSelector("#navigation>ul>li:nth-of-type(6)");
	By careersOption = By.cssSelector("#navigation>ul>li:nth-of-type(6)>ul>li:nth-of-type(1)>a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Get Company Tab web Element
	public WebElement getCompanyNavigationTab() {
		return driver.findElement(companyNavigationTab);
	}
}
