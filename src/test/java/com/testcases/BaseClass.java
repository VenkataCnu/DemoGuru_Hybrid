package com.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig config = new ReadConfig();

	public String baseURL = config.baseUrl();
	public String username = config.emailId();
	public String password = config.passWord();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException {
		logger = Logger.getLogger("e-Commerse");
		PropertyConfigurator.configure("log4j.properties");
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			// options.addArguments("headless");
			options.addArguments("disable-infobars");
			options.addArguments("version");

			driver = new ChromeDriver(options);
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
