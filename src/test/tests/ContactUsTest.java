package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactUsTest extends BaseTest {
    HomePage homePage;
    ContactUsPage contactUsPage;
    List<String> expectedSubject = new ArrayList<>(Arrays.asList("Customer service", "Webmaster"));
    String expectedResult = "Your message has been successfully sent to our team.";
    String testOrder = "1234567890";
    String testMessage = "Random Message for Text Area";
    String uploadFilePath = "C:/Users/yanet/OneDrive/Getting started with OneDrive.pdf";

    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.click(homePage.contactUsLink);
    }

    @Test(testName = "IN-2.1 - Test Subject", description = "validating options for subject")
    public void test101() {
        Select select = new Select(contactUsPage.subject);
        List<WebElement> actual = select.getOptions();

        for (String eachExp : expectedSubject) {
            boolean found = false;
            for (WebElement eachActual : actual) {
                String optionStr = eachActual.getText();
                if (eachExp.equals(optionStr))
                    found = true;
            }
            Assert.assertEquals(found, true);
        }
    }

    @Test(testName = "IN-2.2.1 - Test email address", description = "Testing valid email address")
    public void test102() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        this.fillOrderRef();
        this.fillMessage();
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(expectedResult.equals(contactUsPage.getText(contactUsPage.result)));

    }

    @Test(testName = "IN-2.2.2 - Test email address", description = "Testing invalid email address")
    public void test103() {
        this.fillSubject();
        this.fillEmail(2); //invalid address
        this.fillOrderRef();
        this.fillMessage();
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(!expectedResult.equals(contactUsPage.getText(contactUsPage.result)));
    }

    @Test(testName = "IN-2.2.3 - Test email address", description = "Testing empty email address")
    public void test104() {
        this.fillSubject();
        // empty email address
        this.fillOrderRef();
        this.fillMessage();
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(!expectedResult.equals(contactUsPage.getText(contactUsPage.result)));
    }

    @Test(testName = "IN-2.3.1 - Test Order Reference", description = "Testing 10 digits order reference")
    public void test105() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        this.fillOrderRef();
        this.fillMessage();
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(expectedResult.equals(contactUsPage.getText(contactUsPage.result)));

    }

    @Test(testName = "IN-2.3.2 - Test Order Reference", description = "Testing empty order reference")
    public void test106() {
        this.fillSubject();
        this.fillEmail(1); //valid address
// empty order Reference
        this.fillMessage();
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(expectedResult.equals(contactUsPage.getText(contactUsPage.result)));

    }

    @Test(testName = "IN-2.4.1 - Attach File Btn", description = "Validate File can be uploaded")
    public void test107() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        this.fillOrderRef();
        this.fillMessage();
        contactUsPage.sendKeys(contactUsPage.attachBtn, uploadFilePath);
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(expectedResult.equals(contactUsPage.getText(contactUsPage.result)));
    }

    @Test(testName = "IN-2.5.1 - Message Area", description = "Verify message gets sent with text in Message Area")
    public void test108() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        this.fillOrderRef();
        this.fillMessage();
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(expectedResult.equals(contactUsPage.getText(contactUsPage.result)));

    }

    @Test(testName = "IN-2.5.2 - Message Area", description = "Verify message is not sent if message area is empty")
    public void test109() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        this.fillOrderRef();
// empty message
        contactUsPage.click(contactUsPage.sendBtn);
        Assert.assertTrue(!expectedResult.equals(contactUsPage.getText(contactUsPage.result)));

    }


    public void fillSubject() {
        Select select = new Select(contactUsPage.subject);
        select.selectByIndex(1);
    }

    public void fillEmail(int emailType) {
        //  case 1 valid email address, case 2 invalid email address
        String inputEmail = "";
        switch (emailType) {
            case 1:
                inputEmail = "validemail@gmail.com";
                break;
            case 2:
                inputEmail = "invalid@email@gmail.com";
                break;
            default:
                System.out.println("Invalid email type number");

        }
        contactUsPage.sendKeys(contactUsPage.email, inputEmail);

    }

    public void fillOrderRef() {
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
    }

    public void fillMessage() {
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
    }


}


