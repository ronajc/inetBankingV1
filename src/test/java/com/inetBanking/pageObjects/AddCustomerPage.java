package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement addCustomerbutton;

	@FindBy(name = "name")
	WebElement customerName;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	WebElement customerGender;

	@FindBy(id = "dob")
	WebElement DOB;

	@FindBy(name = "addr")
	WebElement Adress;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement PIN;

	@FindBy(name = "telephoneno")
	WebElement mobileNumber;

	@FindBy(name = "emailid")
	WebElement Email;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(name = "sub")
	WebElement btnSubmit;

	@FindBy(name = "res")
	WebElement btnReset;

	public void custButton() {
		addCustomerbutton.click();
	}
	
	public void custName(String cname) {
		customerName.sendKeys(cname);
	}
	public void custGender(String cgender) {
		customerGender.click();
	}
	public void custDOB(String cday, String cmonth, String cyear) {
		DOB.sendKeys(cday);
		DOB.sendKeys(cmonth);
		DOB.sendKeys(cyear);
	}
	public void custAdress(String cadress) {
		Adress.sendKeys(cadress);
	}
	public void custCity(String ccity) {
		city.sendKeys(ccity);
	}
	public void custState(String cstate) {
		state.sendKeys(cstate);
	}
	public void custPIN(int cpin) {
		PIN.sendKeys(String.valueOf(cpin));
	}
	public void custMobileNumber(String cnumber) {
		mobileNumber.sendKeys(String.valueOf(cnumber));
	}
	public void custEmail(String cemil) {
		Email.sendKeys(cemil);
	}
	public void custPassword(String cpassword) {
		Password.sendKeys(cpassword);
	}
	public void custSubmit() {
		btnSubmit.click();
	}
	public void custreset() {
		btnReset.click();
	}
}
