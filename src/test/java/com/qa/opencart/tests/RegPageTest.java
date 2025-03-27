package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.CSVUtils;
import com.qa.opencart.Utils.ExcelUtil;
import com.qa.opencart.Utils.StringUtils;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class RegPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		registerationPage = loginPage.navigateToRegisterPage();
	}

	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"gayatri","ahire","9876655131","gay@123","gay@123","yes"},
			{"yash","suman","9876612131","suman@123","suman@123","no"},
		};
		}
	
	@DataProvider
	public Object[][] getUserRegTestDataFromExcel(){
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	@DataProvider
	public Object[][] getUserRegTestDataFromCSV(){
		return CSVUtils.csvData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getUserRegTestDataFromCSV")
	public void userRegTest(String firstName, String lastName, String telePhone, String password,
			String confirmPassword, String subscribe) {
		Assert.assertTrue(
				registerationPage.userRegister(firstName,lastName,StringUtils.getRandomEmailId(),
						telePhone,password,confirmPassword,subscribe));
	}
	
	
}