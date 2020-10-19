package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass {

	ReadConfig rfConfig = new ReadConfig();

	public static WebDriver driver;
	public String baseURL = rfConfig.getApplicationURL();
	public String username = rfConfig.getUsername();
	public String password = rfConfig.getPassword();
	public static Logger logger;

	@Parameters("browser")
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup(String browser)
	{
		logger = Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("log4j.properties");

		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rfConfig.getchromePath());
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(capabilities);
		}

		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rfConfig.getfirefoxPath());
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new FirefoxDriver(capabilities);
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
		logger.info("Opening website");		
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

	public boolean isAlertpresent() throws IOException
	{
		try 
		{
			String failureMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			System.out.println(failureMessage);
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	public String RandomEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
}
