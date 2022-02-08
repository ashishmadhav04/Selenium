package Pages;

import Utilities.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BaseTest
{
    public GooglePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@title='Search']")
    public WebElement Searchbox;

    @FindBy(xpath = "//input[@aria-label='Google Search']")
    public WebElement GoogleSearchButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Feeling Lucky')]")
    public WebElement IAmFeelingLuckyButton;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    public WebElement GmailLink;

    @FindBy(xpath = "//div[@class='OBMEnb']/ul/li")
    public WebElement SearchDropdown;

    public void launchPage ()
    {
        driver.get("https://www.google.com");
    }
}
