package JavaFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

    public static void main (String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\ProjectDrive\\Required_Selenium_Software\\Drivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/datepicker");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Date selection

        WebElement datefield = driver.findElement(By.id("datepicker"));
        datefield.sendKeys("16/11/2023");  //select date using senkeys
        Thread.sleep(3000);
        datefield.sendKeys(Keys.RETURN);  //close the date picker
        driver.quit();


    }
}
