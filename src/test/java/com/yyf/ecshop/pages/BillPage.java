package com.yyf.ecshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPage {
	private WebDriver driver;
	public static final int Balance_Pay = 1;
	public static final int Transfer_Pay = 2;
	public static final int cash_on_arrival = 3;
	
	@FindBy(xpath="//*[@id=\"paymentTable\"]/tbody/tr/td/input")
	public List<WebElement>  Paymentoptions;
	
	@FindBy(xpath="//*[@align=\"center\"]/input")
	public WebElement SubmitBillButton;
		
	public BillPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void choosepayment(List<WebElement> WebElement,int index) {
		WebElement.get(index-1).click();		
	}
}
