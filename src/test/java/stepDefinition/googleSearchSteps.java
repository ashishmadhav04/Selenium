package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class googleSearchSteps
{
    WebDriver driver;

    @Given("Navigate to gmail page")
    public void navigate_to_gmail_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashishmadhav/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com");
    }

    @When("I type keywoard ashish in the search box and then hit Forgot email link")
    public void i_type_keywoard_ashish_in_the_search_box_and_then_hit_forgot_email_link() {
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
}