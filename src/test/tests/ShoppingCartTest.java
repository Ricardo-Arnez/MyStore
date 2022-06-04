package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class ShoppingCartTest extends BaseTest {
    HomePage homePage;


    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
    }

    @Test(testName = "Validate shopping cart")
    public void test01() {
        Assert.assertTrue(homePage.shoppingCart.isDisplayed());

    }

    @Test(testName = "total validation")
    public void test02() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.buttonHover1).perform();

        homePage.addToCartBtn1.click();
        homePage.continueShopBtn.click();

        actions.moveToElement(homePage.buttonHover2).perform();

        homePage.addToCartBtn2.click();
        homePage.continueShopBtn.click();

        actions.moveToElement(homePage.shoppingCart).click().perform();

//        String shippingCost = homePage.shippingCost.getText();
//        int costNum = Integer.parseInt(shippingCost);
//
//        List<WebElement> prodPrices = homePage.productPrice;
//        for(WebElement proPr : prodPrices){
//            System.out.println(proPr.getText());
//        }

    }
}
