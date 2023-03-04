package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {
		File file = new File("D:\\Workspace\\Framework Workspace\\Demo_Guru\\configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String baseUrl() {
		String url = prop.getProperty("baseurl");
		return url;

	}

	public String emailId() {
		String email = prop.getProperty("emailid");
		return email;

	}

	public String passWord() {
		String pwd = prop.getProperty("password");
		return pwd;

	}

}
