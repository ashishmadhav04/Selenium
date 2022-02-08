package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


@Listeners(TestNgListenerFunction.class)
public class BaseTest extends StoreResultsToDB {
    public WebDriver driver;
    public String cValue;
    ExtentReports extent = new ExtentReports();
    ExtentTest test;
    Common_Utility util = new Common_Utility();

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

        //ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void AfterMethod(ITestResult result) throws Exception {
        String path;
        System.out.println("After Method: This is executed after every testcase. Quitting the browser");

        test = extent.createTest(result.getName(), "Name of the test");

        test.log(Status.INFO, "Test execution complete");
        int iValue = result.getStatus();
        switch (iValue)
        {
            case 1: test.pass("Test Passed");
                break;
            case 2: test.fail("Test failed");
                path = util.TakeScreenshot(driver);
                test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                break;
            case 3: test.skip("Test Skipped");
                path = util.TakeScreenshot(driver);
                test.log(Status.SKIP, "", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                break;
        }
        driver.close();
        driver.quit();
        extent.flush();
        StoreResultsToDB.SaveResultsToDB(result);
    }
}
