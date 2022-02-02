import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleTests extends BaseTest{
    @Test
    public void Simple_Test()
    {
        driver.get("https://localhost:5001/swagger/index.html");
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Swagger UI");
    }

    @Test
    public void Simple_Test_1()
    {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("ashish");
        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void Simple_Test_2() throws IOException {
        driver.get("https://www.google.com");
        String title = driver.getTitle();

        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Google");
        //ReadingPropertyFile.WritingPropertiesFile();
    }

    @Test
    public void JavaScript_Executor_Example()
    {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        driver.findElement(By.xpath("//a[contains(@href, 'https://mail.google.com/mail/&ogbl')]")).click();
        driver.findElement(By.xpath("//a/span[@class='laptop-desktop-only']")).click();
        System.out.println("Title of the page is: " + title);

        JavascriptExecutor jScript = (JavascriptExecutor)driver;
        jScript.executeScript("document.getElementById('firstName').value='trying to test Java Script Executor';");
        System.out.println(jScript.executeScript("return document.documentElement.innerText;").toString());
        System.out.println(jScript.executeScript("return document.title;").toString());
        System.out.println(jScript.executeScript("return document.URL;").toString());

    }

    @Test
    public void Move_To_Element() throws InterruptedException {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//img[@title= 'Lunar New Year 2022']"))).build().perform();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[contains(@href, 'https://mail.google.com/mail/&ogbl')]")).click();
        driver.findElement(By.xpath("//a/span[@class='laptop-desktop-only']")).click();
        System.out.println("Title of the page is: " + title);

        JavascriptExecutor jScript = (JavascriptExecutor)driver;
        jScript.executeScript("document.getElementById('firstName').value='trying to test Java Script Executor';");
        System.out.println(jScript.executeScript("return document.documentElement.innerText;").toString());
        System.out.println(jScript.executeScript("return document.title;").toString());
        System.out.println(jScript.executeScript("return document.URL;").toString());

    }

    @Test
    public void Switching_Between_Windows() throws InterruptedException {
        driver.get("https://toolsqa.com/selenium-training#enroll-form");
        String title = driver.getTitle();
        driver.findElement(By.xpath("//ul/li/a[contains(., 'Demo Site')]")).click();
        Thread.sleep(5000);

        ArrayList<String> sWindows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(sWindows.get(0));
        Assert.assertEquals(driver.getCurrentUrl(), "https://toolsqa.com/selenium-training#enroll-form");
        Thread.sleep(5000);
        driver.switchTo().window(sWindows.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
        Thread.sleep(10000);
    }

    @Test
    public void Switching_Between_Frames() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        String title = driver.getTitle();
        List<WebElement> iFrames = driver.findElements(By.xpath("//iframe"));
        System.out.println(iFrames);
        System.out.println("Total iFrames are " + iFrames.size());

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));

        driver.switchTo().frame(frame1);
        Thread.sleep(2000);
        System.out.println("Text of the first frame is: " + driver.findElement(By.xpath("//html/body/h1[@id='sampleHeading']")).getText());

        driver.switchTo().parentFrame();
        Thread.sleep(2000);

        driver.switchTo().frame(frame2);
        Thread.sleep(2000);
        System.out.println("Text of the second frame is: " + driver.findElement(By.xpath("//html/body/h1[@id='sampleHeading']")).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
    }

    @Test
    public void Working_With_Model() throws InterruptedException {
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.xpath("//button[@id= 'showSmallModal']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='modal-content']")).getText());
        driver.findElement(By.xpath("//button[@id= 'closeSmallModal']")).click();
    }

    @Test
    public void Uploading_Files() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.xpath("//input[@class= 'form-control-file']")).sendKeys("/Users/ashishmadhav/Desktop/Jenkins_Git_Setup1.png");
        Thread.sleep(10000);
    }

    @Test
    public void Selecting_Dropdowns() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select sState = new Select(driver.findElement(By.name("country")));
        sState.selectByValue("ARUBA");
        Thread.sleep(10000);
        System.out.println(sState.getFirstSelectedOption().getText());
    }

}
