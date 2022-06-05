package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactUsPage extends BasePage {
    protected WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='id_contact']")
    public WebElement subject;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='id_order']")
    public WebElement orderRef;

    @FindBy(xpath = "//input[@id='fileUpload']")
    public WebElement attachBtn;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement messageArea;

    @FindBy(xpath = "//button[@id='submitMessage']")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[@id='center_column']//p[@class='alert alert-success']")
    public WebElement result;

}
