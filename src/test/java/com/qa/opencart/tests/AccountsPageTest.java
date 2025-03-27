package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void accPageURLTest() {
		String actUrl = accPage.getAccPageURL();
		Assert.assertTrue(actUrl.contains(AppConstants.ACC_PAGE_URL_FRACTION));
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void isMyAccountLinkExistTest() {
	Assert.assertTrue(accPage.myAccLinkExist());
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> accHeaderList = accPage.getAccountsPageHeaderslist();
		System.out.println(accHeaderList);
	}
	
	@Test
	public void searchTest() {
		accPage.doSearch("macbook");
	
	}

}
