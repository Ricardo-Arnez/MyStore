package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.SeleniumUtils;

import java.util.List;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetUp(){
        homePage = new HomePage(getDriver());
    }

    @Test(testName = "Validate pop-up text")
    public void test01(){
        System.out.println(homePage.getText(homePage.popUpText));
        homePage.click(homePage.closePopUpBtn);
    }

    @Test(testName = "Test social media buttons - Facebook")
    public void test02(){
        homePage.click(homePage.closePopUpBtn);
        homePage.click(homePage.facebookBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, "The Weather Channel - Home | Facebook");
    }

    @Test(testName = "Test social media buttons - Twitter")
    public void test03(){
        homePage.click(homePage.twitterBtn);
        homePage.click(homePage.closePopUpBtn);
        homePage.click(homePage.twitterBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, "The Weather Channel (@weatherchannel) / Twitter");
    }

    @Test(testName = "Test social media buttons - Youtube")
    public void test04(){
        homePage.click(homePage.youtubeBtn);
        homePage.click(homePage.closePopUpBtn);
        homePage.click(homePage.youtubeBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, "The Weather Channel - YouTube");
    }

}
