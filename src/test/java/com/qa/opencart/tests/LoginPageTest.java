package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtenReportListener.class)
@Epic("Epic 100: Design open cart login page")
@Story("US 101: Design login page feature for open cart application")
@Feature("Feature 201: Adding login features")
public class LoginPageTest extends BaseTest{
  
	@Description("Checking login page title...")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest() {	
       String actTitle = loginPage.getLoginPageTitle();
       Assert.assertEquals(actTitle,AppConstants.LOGIN_PAGE_TITLE,AppError.TITLE_NOT_FOND);
	}
	
	@Description("Checking login page URL...")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageURL();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_URL_FRACTION),AppError.URL_NOT_FOUND);
	}
	
	@Description("Checking forgot pwd link on login page...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgottenPwdLinkExist());
	}
	
	@Description("Checking user is able to login page...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		 accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals( accPage.getAccPageTitle(),AppConstants.ACCOUNTS_PAGE_TITLE);
	}
}


