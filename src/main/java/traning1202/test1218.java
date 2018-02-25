package traning1202;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class test1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", 
				"H:\\mindclicer\\IT文件\\精品班\\selenuimjava\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.atstudy.com");
		GeckoDriverService.createDefaultService();
		
		
		
		
	}

}
