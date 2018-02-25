package com.yyf.ecshop.tests;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import com.yyf.ecshop.data.WrappedRemoteWebDriver;

/**
 * DriverUtils�������ṩservice�ĵ������������ṩƥ�䲻ͬ�������driver����
 *
 */
public class DriverUtils {
	/**
	 * service�������ڱ�������û����õ�ϵͳ�����������Ĳ�ͬ�������driverservice
	 */
	private static DriverService service;
	/**
	 * browser�ַ��������ڻ�ȡ�������û�������ϵͳ�����е�ֵ
	 */
	private static String browser;
	/**
	 * ��̬���أ������Ķ���ģʽ��service���󣬲�����
	 */	
	private static final Logger logger = LogManager.getLogger("DriverUtils");
	static {	
		Config config = new Config("Config.properties");
		browser = System.setProperty("yyf.selenium.browser",config.getConfig("browser")); // ��ȡϵͳ����	
		  logger.info("��ȡϵͳ����yyf.selenium.browser"+browser);
		/*
		 * ����browser�������������ͣ��ֱ𴴽�DriverService����
		 */		
		if("firefox".equalsIgnoreCase(browser)) {
			//File foxfile = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");	
			//FirefoxBinary foxbinary = new FirefoxBinary(foxfile);
			service = new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File(config.getConfig("firefoxbinary"))))
							// ָ����������ִ���ļ�
					.usingAnyFreePort() // ָ��ʹ����һ���ö˿�
					.usingDriverExecutable(new File(config.getConfig("firefoxdriver"))) // ָ��driver���������λ��
					.build(); // ��Builder��������DriverService����		
		}else if("chrome".equalsIgnoreCase(browser)) {
			service = new ChromeDriverService.Builder()
					.usingAnyFreePort()
					.usingDriverExecutable(new File(
							config.getConfig("chromedriver")))
					.build();					
		}else if("ie".equalsIgnoreCase(browser)){
			service = new InternetExplorerDriverService.Builder()
					.usingAnyFreePort()
					.usingDriverExecutable(new File(config.getConfig("iedriver")))
					.build();
		}else if("edge".equalsIgnoreCase(browser)) {
			service = new EdgeDriverService.Builder()
					.usingAnyFreePort()
					.usingDriverExecutable(new File(config.getConfig("edgedriver")))
					.build();			
		}else {
			logger.error("δ֧�ֵ���������ͣ�����ϵͳ����yyf.selenium.browser"); // ͨ����־��¼�����������Ϣ�Ƿ�����
			throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����");
		}
		try {
			service.start(); // ����service
			logger.info("driver��������"); // ͨ����־��¼�����Ƿ���ȷ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getDriver��̬����������ʹ�����ṩ����Ļ�ȡ��ͬ���������driver����
	 * @return driver
	 */
	public static WebDriver getDriver() {
		WebDriver driver = null;
		DesiredCapabilities caps = null;
		/*
		 * ����browser��ֵ�ж�������browser����
		 */
		if("firefox".equalsIgnoreCase(browser)) {
			caps = DesiredCapabilities.firefox();
		}else if("chrome".equalsIgnoreCase(browser)) {
			caps = DesiredCapabilities.chrome();
		}else if("ie".equalsIgnoreCase(browser)){			
			caps = DesiredCapabilities.internetExplorer();
		}else if("edge".equalsIgnoreCase(browser)){
			caps = DesiredCapabilities.edge();				
		}else {
			logger.error("δ֧�ֵ���������ͣ�����ϵͳ����yyf.selenium.browser");
			throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
		}
		driver = new WrappedRemoteWebDriver(service.getUrl(), caps);
		return driver;
	}
	/**
	 * ֹͣ����
	 */
	public static void stopService() {
		service.stop();
		logger.info("driver����ֹͣ");
	}
}
