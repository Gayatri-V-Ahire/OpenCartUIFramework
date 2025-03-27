package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElementUtil;
import com.qa.opencart.Utils.TimeUtil;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Step;

public class RegisterationPage {
	
	//Page class/Page Library/Page Object
	private WebDriver driver;
	private ElementUtil eleUtil;
    
	// 1. Private By Locators
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telePhone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '0']");
	private By agreeCheckBox = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMessage = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	private By pop = By.linkText("pop");
	

	// 2. Public Page Class Const...
	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	@Step("User registeration")
	public boolean userRegister(String firstName, String lastName, String email, String telePhone, String password,
			String confirmPassword, String subscribe) {

		eleUtil.waitForElementVisible(this.firstName, 10).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telePhone, telePhone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPassword, confirmPassword);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);

		String regSuccessMessg = eleUtil.waitForElementVisible(successMessage,TimeUtil.DEFAULT_LONG_TIME).getText();
		System.out.println(regSuccessMessg);

		if (regSuccessMessg.equals(AppConstants.USER_REG_SUCCESS_MESSG)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		return false;

	}

}
