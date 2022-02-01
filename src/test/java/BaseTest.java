import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Listeners(TestNgListenerFunction.class)
public class BaseTest extends StoreResultsToDB{
    public WebDriver driver;
    public String cValue;
    ExtentReports extent = new ExtentReports();
    ExtentTest test;

    @BeforeSuite
    public void BeforeSuite() throws Exception {
        System.out.println("Before Suite: This is executed once at the beginning of the entire Suite.");
        cValue = CreateDB_Connection.Make_DB_Connection().toString();

        ExtentHtmlReporter html = new ExtentHtmlReporter("./Reports/report.html");
        extent.attachReporter(html);
    }

    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("Before Method: This is executed before every testcase.");
        System.setProperty("webdriver.chrome.driver", "/Users/ashishmadhav/Downloads/chromedriver");

        /*ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test1()
    {
        driver.get("https://localhost:5001/swagger/index.html");
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Swagger UI");
    }

    @Test
    public void Test2()
    {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void Test3() throws IOException {
        driver.get("https://www.google.com");
        String title = driver.getTitle();

        System.out.println("Title of the page is: " + title);
        Assert.assertEquals(title, "Google");
        //ReadingPropertyFile.WritingPropertiesFile();
    }


    @AfterMethod
    public void AfterMethod(ITestResult result) throws Exception {
        System.out.println("After Method: This is executed after every testcase. Quitting the browser");
        test = extent.createTest(result.getName(), "Name of the test");

        test.log(Status.INFO, "Test execution complete");
        int iValue = result.getStatus();
        switch (iValue)
        {
            case 1: test.pass("Test Passed");
                break;
            case 2: test.fail("Test failed");
                break;
            case 3: test.skip("Test Skipped");
                break;
        }

        driver.close();
        driver.quit();
        extent.flush();
        StoreResultsToDB.SaveResultsToDB(result);
    }
}
