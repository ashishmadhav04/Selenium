package stepDefinition;

import Pages.GooglePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class googleSearchSteps
{
    GooglePage gPage;
    WebDriver driver = new ChromeDriver();

    @Given("Navigate to gmail page")
    public void navigate_to_gmail_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashishmadhav/Downloads/chromedriver");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com");
    }

    @When("I type keyword ashish in the search box and then hit Forgot email link")
    public void i_type_keyword_ashish_in_the_search_box_and_then_hit_forgot_email_link() {
        driver.findElement(By.xpath("//div/input[@name='identifier']")).sendKeys("ashish");
        driver.findElement(By.xpath("//div/button[contains(text(),'Forgot email')]")).click();
    }

    @Then("It takes me to the next page and i verify the title")
    public void it_takes_me_to_the_next_page_and_i_verify_the_title() {
        Assert.assertEquals(driver.getTitle(), "Gmail");
    }

    @Then("i am able to close the browser")
    public void i_am_able_to_close_the_browser() {
        driver.close();
    }

    @Then("It takes me to the next page and i verify the title and wait")
    public void it_takes_me_to_the_next_page_and_i_verify_the_title_and_wait() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), "Gmail");
        driver.navigate().back();
        Thread.sleep(10000);
    }

    @Given("Navigate to google page")
    public void navigate_to_google_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashishmadhav/Downloads/chromedriver");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        gPage = new GooglePage(driver);
        gPage.launchPage();
        //driver.get("https://www.google.com");
    }
    @When("Type keyword {string} in the search box")
    public void type_keyword_in_the_search_box(String sString) {
        gPage.Searchbox.sendKeys(sString);
        //driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(sString);
    }
    @Then("Wait for {long} milliseconds")
    public void wait_for_milliseconds(Long iMSeconds) throws InterruptedException {
        Thread.sleep(iMSeconds);
    }

}