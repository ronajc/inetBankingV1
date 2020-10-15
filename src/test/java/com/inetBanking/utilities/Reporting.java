package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	ExtentReports extentReports; // All three in-built available classes
	ExtentTest extentTest;
	ExtentSparkReporter htmlreporter;

	public void onStart(ITestResult testResult) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); // creating timestamp for report
		String reportname = "Test_Report_" + timestamp + ".html"; // setting report name

		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/" + reportname); 
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

		extentReports = new ExtentReports();

		extentReports.attachReporter(htmlreporter);
		extentReports.setSystemInfo("Host Name", "localhot");
		extentReports.setSystemInfo("Environment","QA");
		extentReports.setSystemInfo("User", "Vishal");

		htmlreporter.config().setDocumentTitle("inetBanking Test project");
		htmlreporter.config().setReportName("Functional Test Automation Report");
		htmlreporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult testResult) 
	{
		extentTest = extentReports.createTest(testResult.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult testResult)
	{
		extentTest = extentReports.createTest(testResult.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));

		String screenshotPath = System.getProperty("user.dir"+ "\\Screenshots\\" + testResult.getName() + ".png");

		File f = new File(screenshotPath);

		if(f.exists()) {
			extentTest.fail("Screenshot ofr failed case :" + extentTest.addScreenCaptureFromPath(screenshotPath));
		}
	}

	public void onTestSkip(ITestResult testResult)
	{
		extentTest = extentReports.createTest(testResult.getName());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestResult testResult)
	{
		extentReports.flush();
	}
}
