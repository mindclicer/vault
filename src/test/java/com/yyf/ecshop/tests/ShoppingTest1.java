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
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//����Ԫ�ز��ҵĵȴ�ʱ��  
	        driver.get("http://localhost/ECshop/index.php");
	        driver.manage().window().maximize();//�������
		    HomePage Homepage = new HomePage(driver);
		    Homepage.clicklogin();
		    LRpage Lrpage = new LRpage(driver);
	        Lrpage.input_username(username);//�����û���
	        Lrpage.input_password(password);//��������
	        Lrpage.click_WebElement(Lrpage.submit_btn);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,1000);	//����ҳ��
			GoodsPage Goodspage = new GoodsPage(driver);
			String LastPageGoodName = null;
			LastPageGoodName = Goodspage.choosegood(Goodspage.SecondFloorGoods, 1);	//�����һ����Ʒ		
			Singlegoodpage Singlegood = new Singlegoodpage(driver);
			Singlegood.inputbuynumber(Singlegood.BuyNumInput,"2");//���빺������
			Singlegood.assertGoodname(LastPageGoodName);
			Singlegood.Buygoodimg.click();			
		    Shoppingcarpage Shoppingcar = new Shoppingcarpage(driver);
		    Shoppingcar.resolvebutton.click();
		    BillPage Billpage = new BillPage(driver);
		    jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,800);
		    Billpage.choosepayment(Billpage.Paymentoptions, BillPage.Balance_Pay);//ѡ��֧������
		    jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,800);
		    Billpage.SubmitBillButton.click();		
		    Thread.sleep(3000);
	 }
}
