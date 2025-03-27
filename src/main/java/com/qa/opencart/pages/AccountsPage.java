package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElementUtil;
import com.qa.opencart.constants.AppConstants;

public class AccountsPage {
	// Page class/Page Library/Page Object
	WebDriver driver;
	ElementUtil eleUtil;

	// 1. Private By Locators
	private By logoutLink = By.linkText("Logout");
	private By myAccoutLink = By.linkText("My Account");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	// 2. Public Page Class Const...
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, 5);
		System.out.println("Acc Page Title:" + title);
		return title;
	}

	public String getAccPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.ACC_PAGE_URL_FRACTION, 5);
		System.out.println("Acc Page URL:" + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
	}

	public boolean myAccLinkExist() {
		return eleUtil.waitForElementVisible(myAccoutLink, 5).isDisplayed();
	}

	public ArrayList<String> getAccountsPageHeaderslist() {
		List<WebElement> headerEleList = eleUtil.getElements(headers);
		ArrayList<String> headersList = new ArrayList<String>();
		for(WebElement e: headerEleList) {
			String text = e.getText();
			headersList.add(text);
		}
		return headersList;
	}
	
	public SearchResultsPage doSearch(String SearchKey) {
		System.out.println("searching for: " + SearchKey);
		eleUtil.doSendKeys(search, SearchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);

	}
}
