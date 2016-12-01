package com.test.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.main.pages.CareerPage;
import com.main.pages.HomePage;
import com.utils.InitiateDriver;

public class TestClass {

	private WebDriver driver;
	HomePage objHomePage;
	CareerPage objCareerPage;

	@Before
	public void setup() throws IOException {
		InitiateDriver driverInst = new InitiateDriver();
		driver = driverInst.getDriver();
	}

	@Test
	public void testChromeDriver() {
		objCareerPage = new CareerPage(driver);
		assertThat(driver.getTitle(), is(equalTo("OneTrust | Careers")));

		for (int i = 1; i <= objCareerPage.getCityNameList(); i++) {
			
			objCareerPage.clickTab(i);
			
			String cityNames = objCareerPage.getCityName(i);
			String cityName;
			if (cityNames.equals("SAN FRANCISCO")) {
				cityName = "san-francisco";
			}else {
				cityName = cityNames.toLowerCase();
			}
			System.out.println(cityNames);
			System.out.println("*******************************************");
			
			for (int j = 1; j <= objCareerPage.getCityJobDomainRows(cityName); j++) {
				
				for (int k = 1; k <= objCareerPage.getCityJobDomainColumns(cityName,j); k++) {
					
					System.out.println(objCareerPage.getJobCategoryName(cityName,j, k));
					System.out.println("-------------------------");
					
					for (int m = 1; m <= objCareerPage.getJobRows(cityName, j,k); m++) {
						System.out.println(objCareerPage.getJobName(cityName,j,k,m));
					}
					
					System.out.println(" ");
				}
			}
		}
	}
	
	@After
	public void closeBrowsers() throws Exception {
		driver.quit();
	}
}