package com.yyf.ecshop.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.reporters.jq.Main;

public class Config {
	private Properties Proper ;
	public Config(String filename) {
		Proper = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
		try {
			Proper.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getConfig(String key) {
		return Proper.getProperty(key);
	}
//	public static void main(String[] args) {
//		Config config = new Config("Config.properties");
//		System.out.println(config.getConfig("yyf.selenium.browser"));
//	}
}
