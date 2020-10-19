package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomer_003 extends BaseClass {
	
	@Test
	public void editCustomer() throws InterruptedException 
	{
		LoginPage lPage = new LoginPage(driver);
		lPage.setUserName(username);
		lPage.setPassword(password);
		lPage.clickSubmit();
		
		EditCustomerPage ecPage = new EditCustomerPage(driver);
		
		TC_AddCustomerTest_002 tc = new TC_AddCustomerTest_002();
		String userID = tc.toString();
		System.out.println(userID);
		ecPage.editcustomerlink();
		ecPage.txtCustID(userID);
		ecPage.Submit();
		Thread.sleep(2000);
		
		try {
			captureScreenshot(driver, "editCustomer");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
