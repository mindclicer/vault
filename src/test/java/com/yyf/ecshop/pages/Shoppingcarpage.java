package com.yyf.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppingcarpage {
	@FindBy(xpath="//*[@class=\"flowBox\"]/table/tbody2/tr/td[2]/a/img")
	public WebElement resolvebutton;
	
	private WebDriver driver;
	public Shoppingcarpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
}
