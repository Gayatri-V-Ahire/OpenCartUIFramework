 package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterationPage;
import com.qa.opencart.pages.SearchResultsPage;

import io.qameta.allure.Step;

public class BaseTest {
	
	WebDriver driver;
	protected Properties prop;
	DriverFactory df;
    
	
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResultPage;
	protected ProductInfoPage proInfoPage;
	protected RegisterationPage registerationPage;
	protected SoftAssert softAssert;
	
	@Step("Setup: launching {0} browser & init the properties")
    @Parameters({"browser"})
	@BeforeTest 
	public void setup(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();
		
		if(browserName!=null) {
			prop.setProperty("browser",browserName);
		}
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);	
		softAssert = new SoftAssert();
		
	}
	
    @Step("Closing browser")
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
