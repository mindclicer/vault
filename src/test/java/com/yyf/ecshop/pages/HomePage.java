package com.yyf.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//*[@id=\"ECS_MEMBERZONE\"]/a[1]")
	public WebElement login_link;
	@FindBy(xpath="//*[@class=\"top_menu1\"]/font/font/font")
	public WebElement username;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clicklogin() {
		login_link.click();
	}
	
}
