package com.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pageobjects.LoginPage;

public class TC_Login_001 extends BaseClass {

	@Test
	public void start() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUser(username);
		logger.info("User entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.setLogin();
		logger.info("Logged in");
		Thread.sleep(2000);

		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			logger.info("Correct Page");
		} else {
			captureScreen(driver, "LoginTest");
			logger.info("Login Failed");
		}
		Thread.sleep(5000);
	}
}
