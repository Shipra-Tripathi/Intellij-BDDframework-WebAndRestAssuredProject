package JavaFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop {

    public static void main (String args []) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ProjectDrive\\Required_Selenium_Software\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        Thread.sleep(2000);
        WebElement dragImage = driver.findElement(By.id("image")); //dragelement path
        WebElement boxdrop = driver.findElement(By.id("box"));   //drop element path

        //using action class to drag and drop
         Actions a1 = new Actions(driver); // create action object
        a1.dragAndDrop(dragImage,boxdrop).build().perform();
        Thread.sleep(2000);
        driver.quit();


    }


}
