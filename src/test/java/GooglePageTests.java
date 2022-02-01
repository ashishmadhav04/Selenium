import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListenerFunction.class)
public class GooglePageTests extends BaseTest
{
    @Test
    public void DoSearch() throws InterruptedException
    {
        GooglePage google = new GooglePage(driver);
        google.launchPage();
        google.Searchbox.sendKeys("america");
        //Thread.sleep(10000);
        google.GoogleSearchButton.click();
        String pTitle = driver.getTitle();
        System.out.println("title is :" + pTitle);
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void DoSearch1() throws InterruptedException
    {
        GooglePage google = new GooglePage(driver);
        google.launchPage();
        google.Searchbox.sendKeys("america");
        Thread.sleep(10000);
    }

}
