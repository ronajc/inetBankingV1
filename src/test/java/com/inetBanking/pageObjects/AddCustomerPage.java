package com.inetBanking.pageObjects;

import java.util.List;

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
	
	@FindBy(name = "rad1")
	List<WebElement> gender;

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
	
	@FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr/td")
	List<WebElement> customerDetails;

	public void custButton() {
		addCustomerbutton.click();
	}
	
	public void custName(String cname) {
		customerName.sendKeys(cname);
	}
	public void custGender(String cgender) {
		if(cgender.equalsIgnoreCase("Male"))
		{
			gender.get(0).click();
		}
		else 
		{
			gender.get(1).click();
		}
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
	public String custID() {
//		String randomvalue;
		String custID;
//		for(int i=0;i<customerDetails.size();i++)
//		{	
//			randomvalue = customerDetails.get(i).getText();
//			//System.out.println(randomvalue);
//		}
		custID = customerDetails.get(4).getText();
		System.out.println("-----"+custID+"------");
		return custID;
	}
}
