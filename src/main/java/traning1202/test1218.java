package traning1202;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class test1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", 
				"H:\\mindclicer\\IT�ļ�\\��Ʒ��\\selenuimjava\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.atstudy.com");
		GeckoDriverService.createDefaultService();
		
		
		
		
	}

}
