package com.yyf.ecshop.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.yyf.ecshop.data.LoginProvider;
import com.yyf.ecshop.data.Mytestlistener2;
import com.yyf.ecshop.pages.BillPage;
import com.yyf.ecshop.pages.GoodsPage;
import com.yyf.ecshop.pages.HomePage;
import com.yyf.ecshop.pages.LRpage;
import com.yyf.ecshop.pages.Shoppingcarpage;
import com.yyf.ecshop.pages.Singlegoodpage;

@Listeners({Mytestlistener2.class})
public class ShoppingTest1 extends Basetest{
	 @Test(dataProvider="shoppingdata",dataProviderClass = LoginProvider.class)
	 public void testShopping_success(String username,String password) throws InterruptedException {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置元素查找的等待时间  
	        driver.get("http://localhost/ECshop/index.php");
	        driver.manage().window().maximize();//窗口最大化
		    HomePage Homepage = new HomePage(driver);
		    Homepage.clicklogin();
		    LRpage Lrpage = new LRpage(driver);
	        Lrpage.input_username(username);//输入用户名
	        Lrpage.input_password(password);//输入密码
	        Lrpage.click_WebElement(Lrpage.submit_btn);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,1000);	//滚动页面
			GoodsPage Goodspage = new GoodsPage(driver);
			String LastPageGoodName = null;
			LastPageGoodName = Goodspage.choosegood(Goodspage.SecondFloorGoods, 1);	//点击第一个商品		
			Singlegoodpage Singlegood = new Singlegoodpage(driver);
			Singlegood.inputbuynumber(Singlegood.BuyNumInput,"2");//输入购买数量
			Singlegood.assertGoodname(LastPageGoodName);
			Singlegood.Buygoodimg.click();			
		    Shoppingcarpage Shoppingcar = new Shoppingcarpage(driver);
		    Shoppingcar.resolvebutton.click();
		    BillPage Billpage = new BillPage(driver);
		    jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,800);
		    Billpage.choosepayment(Billpage.Paymentoptions, BillPage.Balance_Pay);//选择支付方法
		    jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,800);
		    Billpage.SubmitBillButton.click();		
		    Thread.sleep(3000);
	 }
}
