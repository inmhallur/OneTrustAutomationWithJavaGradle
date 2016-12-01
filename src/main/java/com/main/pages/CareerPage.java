package com.main.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerPage {

	WebDriver driver;
	By cityNameList = By.cssSelector(".container>.nav.nav-tabs>li");
	By cityName = By.cssSelector(".container>.nav.nav-tabs>li:nth-of-type(2)>a");
	By cityJobDomainRows = By.cssSelector("#atlanta>div>div");
	By cityJobDomainColumns = By.cssSelector("#san-francisco>div>div>div");
	By jobDomainName = By.cssSelector("#san-francisco>div>div>div:nth-of-type(1)>div>h3");
	By jobRows = By.cssSelector("#san-francisco>div>div>div:nth-of-type(1)>div>ul>li");
	By jobName = By.cssSelector("#san-francisco>div>div>div:nth-of-type(1)>div>ul>li:nth-of-type(1)");
	
	
	

	public CareerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Click on City Name Tab
	public void clickTab(int i) {
		driver.findElement(By.cssSelector(".container>.nav.nav-tabs>li:nth-of-type("+i+")>a")).click();
	}

	// Get the City Name List
	public int getCityNameList() {
		List<WebElement> ele = driver.findElements(cityNameList);
		return ele.size();
	}

	
	// Get the City Name List
	public int getCityJobDomainRows(String cityName) {
		List<WebElement> ele = driver.findElements(By.cssSelector(".tab-content>#"+cityName+">div>div"));
		return ele.size();
	}
	
	// Get the City Name List
	public int getCityJobDomainColumns(String cityName,int i) {
		List<WebElement> ele = driver.findElements(By.cssSelector("#"+cityName+">div>div:nth-of-type("+i+")>div"));
		return ele.size();
	}
	
	// Get the City Name
	public String getCityName(int i) {
		return driver.findElement(By.cssSelector(".container>.nav.nav-tabs>li:nth-of-type("+i+")>a")).getText();
	}

	public int getJobRows(String cityName,int i,int j) {
		List<WebElement> ele = driver.findElements(By.cssSelector("#"+cityName+">div>div:nth-of-type("+i+")>div:nth-of-type("+j+")>div:nth-of-type(1)>ul>li"));
		return ele.size();
	}
	
	// Get the Job Category Name
	public String getJobCategoryName(String cityName,int i,int j) {
		return driver.findElement(By.cssSelector("#"+cityName+">div>div:nth-of-type("+i+")>div:nth-of-type("+j+")>div>h3")).getText();
	}
	
	// Get the Job Name
	public String getJobName(String cityName, int i,int j,int k) {
		return driver.findElement(By.cssSelector("#"+cityName+">div>div:nth-of-type("+i+")>div:nth-of-type("+j+")>div:nth-of-type(1)>ul>li:nth-of-type("+k+")")).getText();
	}

}
