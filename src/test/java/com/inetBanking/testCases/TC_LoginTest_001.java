package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void logintest() throws InterruptedException, IOException
	{	
		LoginPage LP = new LoginPage(driver);
		LP.setUserName(username);
		logger.info("Entered username");

		LP.setPassword(password);
		logger.info("entered password");

		LP.clickSubmit();
		logger.info("Clicked submit");
		
		isAlertpresent();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else 
		{
			captureScreenshot(driver, "logintest");
			Assert.assertFalse(false);
			logger.info("Testcase failed");

		}
		
		LP.clickLogout();
		logger.info("Clicked logout");
	}

}
