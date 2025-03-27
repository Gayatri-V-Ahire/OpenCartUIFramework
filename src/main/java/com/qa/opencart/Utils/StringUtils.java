package com.qa.opencart.Utils;

public class StringUtils {
	
	public static String getRandomEmailId() {
		
		String emailId = "testautomation"+System.currentTimeMillis()+"@gmail.com";
		return emailId;
	}

}
