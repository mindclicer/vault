package com.yyf.ecshop.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Singlegoodpage {
	   @FindBy(xpath="//*[@class=\"goods_style_name\"]")
       public WebElement CenterGood;//ҳ���м����Ʒ����
	   @FindBy(xpath="//*[@id=\"number\"]")
	   public WebElement BuyNumInput;//���������������
	   @FindBy(xpath="//*[@class=\"td1\"]/a/img")
	   public WebElement Buygoodimg;//��������ť
	   
		private WebDriver driver;
		public Singlegoodpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		//����Ĭ��ֵ���������������ԭ������������Ĳ���
		public void inputbuynumber(WebElement WebElement,String keys) {
			String value = null;
			WebElement.click();
			WebElement.clear();
			//WebElement.sendKeys(Keys.chord(Keys.BACK_SPACE));
			WebElement.sendKeys(keys);
			value =  WebElement.getAttribute("value");	
			System.out.println(CenterGood.getText()+"�Ĺ���������"+value);
		}
		//�ж���Ʒ�����Ƿ�������ȷ
		public void assertGoodname(String LastPageGoodname) {
			assertEquals(CenterGood.getText(),LastPageGoodname);
		}		
}
