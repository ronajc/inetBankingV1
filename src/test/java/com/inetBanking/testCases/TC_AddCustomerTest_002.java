package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_002 extends BaseClass{

	public String USERID;
	public String expectedName;
	public String actualName;

	@Test
	public void addNewCustomer() throws IOException, InterruptedException {

		LoginPage lP = new LoginPage(driver);
		logger.info("Username added");
		lP.setUserName(username);
		logger.info("password added");

		lP.setPassword(password);
		logger.info("Clicked submit");

		lP.clickSubmit();
		if(isAlertpresent()== true)
			{
			logger.info("Login failed");
			};

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			AddCustomerPage acpPage = new AddCustomerPage(driver);
			logger.info("Providing customer info");
			acpPage.custButton();
			logger.info("Clicking add customer link");
			acpPage.custName("Vishal Thakur");
			acpPage.custGender("male");
			acpPage.custDOB("05", "12", "1994");
			acpPage.custAdress("India");
			acpPage.custCity("Delhi");
			acpPage.custState("Patel Nagar");
			acpPage.custPIN(110008);
			acpPage.custMobileNumber("8894962429");

			String email = RandomEmail() + "@gamil.com"; 
			acpPage.custEmail(email);
			acpPage.custPassword("Vishal@123");
			acpPage.custSubmit();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			logger.info("Validation started.....");
			isAlertpresent();
			boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");

			if(result==true) {
				Assert.assertTrue(true);
				logger.info("Testcase 1 passed");
				USERID = acpPage.custID();



				EditCustomerPage ecpCustomerPage = new EditCustomerPage(driver);
				ecpCustomerPage.editcustomerlink();
				ecpCustomerPage.txtCustID(USERID);
				ecpCustomerPage.Submit();
				Thread.sleep(3000);
				
				logger.info("executing verify name method");
				actualName = ecpCustomerPage.verifyname();
				
				if(actualName.equals("Vishal Thakur"))
				{
					Assert.assertTrue(true);
					logger.info("Testcase 2 passed");
				}
				else {
					{
						Assert.assertFalse(false);
						captureScreenshot(driver, "EditCustOpen");
						logger.info("Testcase 2 failed");
					}
				}
			}
			else {
				logger.info("switching to failed to add customer alert");
				logger.info("Testcase failed");
				captureScreenshot(driver, "AddCustomer");
				Assert.assertFalse(false);
			}
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Testcase failed");
			captureScreenshot(driver, "loginStep");
			
		}
	}
}
