package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_002 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lP = new LoginPage(driver);
		logger.info("Username added");
		lP.setUserName(username);
		logger.info("password added");

		lP.setPassword(password);
		logger.info("Clicked submit");

		lP.clickSubmit();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			AddCustomerPage acpPage = new AddCustomerPage(driver);
			logger.info("Providing customer info");
			acpPage.custButton();
			logger.info("Clicking add customer link");
			acpPage.custName("Julee");
			acpPage.custGender("female");
			acpPage.custDOB("05", "12", "1774");
			Thread.sleep(5000);
			acpPage.custAdress("India");
			acpPage.custCity("Delhi");
			acpPage.custState("Patel Nagar");
			acpPage.custPIN(110008);
			acpPage.custMobileNumber("8894962400");

			String email = RandomEmail() + "@gamil.com"; 
			acpPage.custEmail(email);
			acpPage.custPassword("Vishal@123");
			acpPage.custSubmit();

			Thread.sleep(3000);

			logger.info("Validation started.....");
			isAlertpresent();
			boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");

			if(result==true) {
				Assert.assertTrue(true);
				logger.info("Testcase passed");
			}
			else {
				logger.info("switching to failed to add customer alert");
				logger.info("Testcase failed");
				captureScreenshot(driver, "AddCustomer");
				Assert.assertTrue(false);
			}
		}
		else 
		{
			captureScreenshot(driver, "loginStep");
			Assert.assertFalse(false);
			logger.info("Testcase failed");

		}
	}

	public String RandomEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
}
