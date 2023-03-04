package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	WebElement user;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(name = "btnLogin")
	WebElement login;

	public void setUser(String userId) {
		user.sendKeys(userId);
	}

	public void setPassword(String passw) {
		pwd.sendKeys(passw);
	}

	public void setLogin() {
		login.click();
	}

}
