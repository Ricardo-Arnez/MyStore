package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='PrivacyDataNotice--heading--2VTdU']")
    public WebElement popUpText;

    @FindBy(name = "close")
    public WebElement closePopUpBtn;

    @FindBy(name = "facebook")
    public WebElement facebookBtn;

    @FindBy(name = "twitter")
    public WebElement twitterBtn;

    @FindBy(name = "youtube")
    public WebElement youtubeBtn;

}
