package com.yyf.ecshop.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LRpage {
	//public WebDriver driver;
	/**
	 * �û����������
	 */
	@FindBy(name="username")
	private WebElement username_input;
	/**
	 * ����������
	 */
	@FindBy(name="password")
	private WebElement password_input;
	/**
	 * ������¼��ť
	 */
	@FindBy(name="submit")
	public WebElement submit_btn;
	
	//��¼��ע�����ʾ����ϢԪ��
	@FindBy(xpath="//*[@class=\"boxCenterList RelaArticle\"]/div/p")
	public WebElement LRcontent;
	
	public Alert loginalert;
	private WebDriver driver;
	
	public LRpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void input_username(String username) {
		username_input.sendKeys(username);		
	}
	public void input_password(String password) {
		password_input.sendKeys(password);		
	}
	public void click_WebElement(WebElement webelement) {
		webelement.click();
	}
	public void assert_result(String expectedText) {
		assertEquals(LRcontent.getText(), expectedText);		
	}
	public void assert_alert(String expectedText) {
		loginalert = driver.switchTo().alert();
		String loginalerttext = loginalert.getText();
		assertTrue(loginalerttext.contains(expectedText));
		loginalert.accept();
	}
	
	
}
