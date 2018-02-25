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
 * DriverUtils类用于提供service的单例启动，并提供匹配不同浏览器的driver对象
 *
 */
public class DriverUtils {
	/**
	 * service对象，用于保存根据用户设置的系统属性来创建的不同浏览器的driverservice
	 */
	private static DriverService service;
	/**
	 * browser字符串，用于获取并保持用户设置在系统属性中的值
	 */
	private static String browser;
	/**
	 * 静态加载（单例的饿汉模式）service对象，并启动
	 */	
	private static final Logger logger = LogManager.getLogger("DriverUtils");
	static {	
		Config config = new Config("Config.properties");
		browser = System.setProperty("yyf.selenium.browser",config.getConfig("browser")); // 获取系统属性	
		  logger.info("获取系统属性yyf.selenium.browser"+browser);
		/*
		 * 根据browser保存的浏览器类型，分别创建DriverService对象
		 */		
		if("firefox".equalsIgnoreCase(browser)) {
			//File foxfile = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");	
			//FirefoxBinary foxbinary = new FirefoxBinary(foxfile);
			service = new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File(config.getConfig("firefoxbinary"))))
							// 指定火狐浏览器执行文件
					.usingAnyFreePort() // 指定使用任一闲置端口
					.usingDriverExecutable(new File(config.getConfig("firefoxdriver"))) // 指定driver驱动程序的位置
					.build(); // 将Builder对象打造成DriverService对象		
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
			logger.error("未支持的浏览器类型，请检查系统属性yyf.selenium.browser"); // 通过日志记录浏览器配置信息是否正常
			throw new RuntimeException("未支持的浏览器类型，请检查系统属性");
		}
		try {
			service.start(); // 启动service
			logger.info("driver服务启动"); // 通过日志记录服务是否正确启动
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getDriver静态方法用于向使用者提供方便的获取不同类型浏览器driver对象
	 * @return driver
	 */
	public static WebDriver getDriver() {
		WebDriver driver = null;
		DesiredCapabilities caps = null;
		/*
		 * 根据browser的值判断启动的browser类型
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
			logger.error("未支持的浏览器类型，请检查系统属性yyf.selenium.browser");
			throw new RuntimeException("未支持的浏览器类型，请检查系统属性bwf.test.browser");
		}
		driver = new WrappedRemoteWebDriver(service.getUrl(), caps);
		return driver;
	}
	/**
	 * 停止服务
	 */
	public static void stopService() {
		service.stop();
		logger.info("driver服务停止");
	}
}
