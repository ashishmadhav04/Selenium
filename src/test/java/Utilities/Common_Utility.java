package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common_Utility {

    WebDriver driver;
    public String TakeScreenshot(WebDriver driver) throws IOException {
        Date date = new Date();
        SimpleDateFormat sDate = new SimpleDateFormat("HHmmss");
        String sdate = sDate.format(date);

        TakesScreenshot screenshot;
        screenshot = (TakesScreenshot)driver;
        File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
        String filePath = "/Users/ashishmadhav/Documents/MyGitProjects/Basic_Selenium/Basic_Selenium-Framework/images/" + sdate + ".png";
        FileUtils.copyFile(srcFile, new File(filePath));

        return filePath;
    }

    public void read_Data_From_Excel() throws IOException
    {
        //File file = new File("/Users/ashishmadhav/Documents/MyGitProjects/Basic_Selenium/Basic_Selenium-Framework/resources/Workbook2.xlsx");
        FileInputStream inputStream = new FileInputStream("/Users/ashishmadhav/Documents/MyGitProjects/Basic_Selenium/Basic_Selenium-Framework/resources/Workbook2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println(sheet);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        for(int i=sheet.getFirstRowNum()+1; 1<=sheet.getLastRowNum(); i++)
        {
            Row row = sheet.getRow(i);
            System.out.println("Row value is : " + row);
        }
    }

    public void Wait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
