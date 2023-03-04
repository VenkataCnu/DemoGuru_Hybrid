package com.testcases;

import org.testng.annotations.Test;

import com.pageobjects.LoginPage;
import com.pageobjects.NewCustomer_Page;
import com.utilities.XLUtils;

public class TC_AddCustomer_002 extends BaseClass {

	@Test(priority = -1)
	public void login() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUser(username);
		logger.info("User entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.setLogin();
		logger.info("Logged in");
		Thread.sleep(5000);
	}

	@Test
	public void addCust() throws Exception {
		NewCustomer_Page nc = new NewCustomer_Page(driver);
		String filePath = "D:\\Workspace\\Framework Workspace\\Demo_Guru\\src\\test\\java\\com\\testdata\\Add_Customer.xlsx";
		String sh = "Sheet1";
		Thread.sleep(5000);
		nc.custMenu();
		logger.info("Menu Entered");
		Thread.sleep(5000);

		XLUtils util = new XLUtils();
		util.getRowCount(filePath, sh);
		util.getCellCount(filePath, sh, 1);

		nc.setName(XLUtils.getCellData(filePath, sh, 2, 1));
		logger.info("Entered Name");
		nc.setDate(XLUtils.getCellData(filePath, sh, 2, 2));
		logger.info("Enterd dob");
		nc.setAddress(XLUtils.getCellData(filePath, sh, 2, 3));
		logger.info("Address entered");
		nc.setCity(XLUtils.getCellData(filePath, sh, 2, 4));
		logger.info("Entered city");
		nc.setState(XLUtils.getCellData(filePath, sh, 2, 5));
		logger.info("Entered state");
		nc.setPin(XLUtils.getCellData(filePath, sh, 2, 6));
		logger.info("Entered Pin");
		nc.setTelephone(XLUtils.getCellData(filePath, sh, 2, 7));
		logger.info("Entered Phone");
		nc.setEmail(XLUtils.getCellData(filePath, sh, 2, 8));
		logger.info("Entered mail");
		nc.submit();
		logger.info("Clicked on Submit");
		Thread.sleep(5000);
	}

}
