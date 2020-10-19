package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	WebElement editcustLink;
	
	@FindBy(name = "cusid")
	WebElement txtcutsidfield;

	@FindBy(name = "AccSubmit")
	WebElement btnsubmit;
	
	@FindBy(name = "res")
	WebElement btnreset;
	
	public void  editcustomerlink()
	{
		editcustLink.click();
	}
	public void txtCustID(String id)
	{
		txtcutsidfield.sendKeys(id);
	}
	public void Submit()
	{
		btnsubmit.click();
	}
	public void Reset()
	{
		btnreset.click();
	}
}
