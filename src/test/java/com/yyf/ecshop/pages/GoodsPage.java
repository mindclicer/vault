package com.yyf.ecshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodsPage {
	@FindBy(xpath="//div [(text()=\"1F 家用电器\")]/../div[2]/div[2]/div/a")
	public List<WebElement> FirstFloorGoods;
	@FindBy(xpath="//div [(text()=\"2F 数码时尚\")]/../div[4]/div[2]/div/a")
	public List<WebElement> SecondFloorGoods;
	@FindBy(xpath="//div [(text()=\"3F 家居生活\")]/../div[6]/div[2]/div/a")
	public List<WebElement> ThirdFloorGoods;
	
	private WebDriver driver;
	public GoodsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	//选择点击获取的商品列表中的某个商品
	public String choosegood(List<WebElement> WebElement,int index) {
		WebElement Chosengood = null;
		String Goodname = null;
		Chosengood = WebElement.get(index-1).findElement(By.xpath("div[3]"));
		Goodname = Chosengood.getText();
	    System.out.println("点击进入"+Goodname+"的页面");
	    Chosengood.click();
		return Goodname;
	}
}
