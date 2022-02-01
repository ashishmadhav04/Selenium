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
    WebElement Searchbox;

    @FindBy(xpath = "//input[@aria-label='Google Search']")
    WebElement GoogleSearchButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Feeling Lucky')]")
    WebElement IAmFeelingLuckyButton;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    WebElement GmailLink;

    @FindBy(xpath = "//div[@class='OBMEnb']/ul/li")
    WebElement SearchDropdown;

    public void launchPage ()
    {
        driver.get("https://www.google.com");
    }
}
