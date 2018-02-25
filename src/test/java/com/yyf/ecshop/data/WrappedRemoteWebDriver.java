package com.yyf.ecshop.data;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WrappedRemoteWebDriver extends RemoteWebDriver{
	private WrappedRemoteWebDriver driver;
	private JavascriptExecutor js;
    private Logger logger = LogManager.getLogger();	
	public WrappedRemoteWebDriver(URL remoteAddress, Capabilities capabilities) {
		super(remoteAddress,capabilities);
	}
	
	@Override
	protected List<WebElement> findElements(String by, String using) {
		List<WebElement> elements = null;
		try {
			logger.info("��ʼ����Ԫ�ؼ���");
			elements = super.findElements(by, using);			
			 //elements.getClass().
			logger.info("ͨ��"+by+"��������"+using+"Ԫ�أ����ҵ�"+elements.size()+"��");
		}catch(Exception e) {
			logger.error("ͨ��"+by+"��������"+using+"Ԫ��ʱ�����쳣��ԭ��"+e.getMessage());
		}
		return elements;
	}
	
	@Override
	protected WebElement findElement(String by, String using) {
		WebElement element = null;
		try {
			logger.info("��ʼ����Ԫ��");
			element = super.findElement(by, using);
			//driver.highlightElement(element);
			//Thread.sleep(2000);
			logger.info("ͨ��"+by+"��������"+using+"Ԫ�أ����ҵ�");
		}catch(Exception e) {
			logger.error("ͨ��"+by+"��������"+using+"Ԫ��ʱ�����쳣��ԭ��"+e.getMessage());
		}
		return element;
	}
	
	public void takeScreenShot(String filename) {
		File screenShot = ((TakesScreenshot)this).getScreenshotAs(OutputType.FILE);
		File directory = new File("screenshots");
		if(!directory.exists() || !directory.isDirectory()){
			logger.info("screenshotsĿ¼�����ڣ�������Ŀ¼");
			directory.mkdir();
		}
		File file = new File(directory,filename);
		screenShot.renameTo(file);
		logger.info("��������ɹ���������"+file.getAbsolutePath());
	}
    public void highlightElement(WebElement element) {
    	
    	js.executeScript("arguments[0].setAttribute('style',arguments[1];",
    			element,"background: yellow;border:2px soild red;");  	
    }	
}
