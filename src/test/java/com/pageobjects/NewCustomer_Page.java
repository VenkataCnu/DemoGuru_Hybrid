package com.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCustomer_Page {

	WebDriver ldriver;

	public NewCustomer_Page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "New Customer")
	WebElement newCust;

	@FindBy(name = "name")
	WebElement nameOf;

	@FindBy(id = "dob")
	WebElement dateOB;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pin;

	@FindBy(name = "telephoneno")
	WebElement telephone;

	@FindBy(name = "emailid")
	WebElement emailid;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public void custMenu() throws InterruptedException
	{
		Thread.sleep(2000);
		newCust.click();
	}

	public void setName(String uname) {
		nameOf.sendKeys(uname);
	}

	public void setDate(String dobb) {
		dateOB.sendKeys(dobb);
	}

	public void setAddress(String addr) {
		address.sendKeys(addr);
	}

	public void setCity(String cityN) {
		city.sendKeys(cityN);
	}

	public void setState(String stateR) {
		state.sendKeys(stateR);
	}

	public void setPin(String pinN) {
		pin.sendKeys(pinN);
	}

	public void setTelephone(String tele) {
		telephone.sendKeys(tele);
	}

	public void setEmail(String eId) {
		emailid.sendKeys(eId);
	}
	
	public void submit()
	{
		submit.click();
	}

}
