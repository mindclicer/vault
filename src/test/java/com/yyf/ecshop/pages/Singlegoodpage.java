package com.yyf.ecshop.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Singlegoodpage {
	   @FindBy(xpath="//*[@class=\"goods_style_name\"]")
       public WebElement CenterGood;//页面中间的商品名称
	   @FindBy(xpath="//*[@id=\"number\"]")
	   public WebElement BuyNumInput;//购买数量的输入框
	   @FindBy(xpath="//*[@class=\"td1\"]/a/img")
	   public WebElement Buygoodimg;//立即购买按钮
	   
		private WebDriver driver;
		public Singlegoodpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		//对有默认值的输入框进行先清除原有内容再输入的操作
		public void inputbuynumber(WebElement WebElement,String keys) {
			String value = null;
			WebElement.click();
			WebElement.clear();
			//WebElement.sendKeys(Keys.chord(Keys.BACK_SPACE));
			WebElement.sendKeys(keys);
			value =  WebElement.getAttribute("value");	
			System.out.println(CenterGood.getText()+"的购买数量是"+value);
		}
		//判断商品名称是否输入正确
		public void assertGoodname(String LastPageGoodname) {
			assertEquals(CenterGood.getText(),LastPageGoodname);
		}		
}
