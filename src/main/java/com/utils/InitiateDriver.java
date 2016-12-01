package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class InitiateDriver
{

	public WebDriver getDriver() throws IOException
	{
		WebDriver driver = null;
		Properties prop = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\config\\envConfig.properties");
		prop.load(f);
		String browserName = prop.getProperty("Browser");
		String url = prop.getProperty("URL");

		if (browserName.equalsIgnoreCase("iexplore"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "\\lib\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		} else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")	+ "\\lib\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
		} else if (browserName.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		} else
		{
			System.out.println("invalid browser");
		}
		return driver;

	}

	
}
