package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Formy {
    public WebDriver driver;
    @Given("User should be able to open URL in chrome browser")
    public void userShouldBeAbleToOpenURLInChromeBrowser() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "C:\\ProjectDrive\\Required_Selenium_Software\\Drivers\\chromedriver-win64\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         Thread.sleep(2000);
         driver.get("https://formy-project.herokuapp.com/switch-window");
         Thread.sleep(2000);


    }

    @When("User should be able to switch to another tab and back")
    public void userShouldBeAbleToEnterAddressFields() throws InterruptedException {
        //Switching another tab

        WebElement newtabbutton =  driver.findElement(By.xpath("//button[@id='new-tab-button']"));
         newtabbutton.click();

         //Need to handle windows
        String windowhandle1 = driver.getWindowHandle(); //defining windows
        for(String windowhandle2: driver.getWindowHandles()){ //for loop switching to the another tab
            driver.switchTo().window(windowhandle2);
            Thread.sleep(3000);


        }
        driver.switchTo().window(windowhandle1); //Switching to the back window
        Thread.sleep(3000);


    }

    @And("User should be able to accept alert")
    public void userShouldBeAbleToAcceptAlert() throws InterruptedException {
        //Alert handles

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();
        Thread.sleep(2000);

        //create object for alert to accept or dissmiss alert pop up

       Alert alert = driver.switchTo().alert();
       alert.accept();
       Thread.sleep(2000);

        driver.quit();
    }
}
