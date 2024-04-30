package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Swag {
    public WebDriver driver;
    @Given("^User able to open URL on chrome$")
    public void userAbleToOpenURLOnChrome() {
    //System.setProperty("webdriver.chrome.driver","C:\\ProjectDrive\\Required_Selenium_Software\\Drivers\\chromedriver-win64\\chromedriver.exe");
     // we don't need to write above code for drivers we can add webdriver dependencies in pom.xml
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     driver.get("https://www.saucedemo.com/");
     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
     driver.manage().window().maximize();
     //validate URL
        String actualurl = driver.getCurrentUrl();
        System.out.println(actualurl);
        String expectedurl = "https://www.saucedemo.com/";


        if (actualurl.equalsIgnoreCase(expectedurl)){

            System.out.println("URL matched");

        }
        else{
            System.out.println("Url is not matched");
        }
       // throw new io.cucumber.java.PendingException();
    }

    @When("^User able to login with valid credentials$")
    public void userAbleToLoginWithValidCredentials() throws InterruptedException {
        //Enter valid username
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        //Enter valid password
        WebElement pwd = driver.findElement(By.cssSelector("input#password"));
        pwd.sendKeys("secret_sauce");
        Thread.sleep(2000);

        //click on login button
        WebElement loginbtn = driver.findElement(By.cssSelector("input#login-button"));
        loginbtn.click();
        Thread.sleep(2000);

    }

    @And("^User should be Navigated to Dashboard page$")
    public void userShouldBeNavigatedToDashboardPage() {


    }

    @And("Select the product and Add to the Cart")
    public void selectTheProductAndAddToTheCart() throws InterruptedException {
        WebElement AddCart = driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
        AddCart.click();
        Thread.sleep(2000);

            WebElement Shoppingbasket = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            Shoppingbasket.click();
            Thread.sleep(2000);

        }


    @And("User should be able to proceed with checkout")
    public void userShouldBeAbleToProceedWithCheckout() throws InterruptedException {
        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        Thread.sleep(2000);

        //client information
        WebElement name = driver.findElement(By.xpath("//input[@id='first-name']"));
        name.sendKeys("Shipra");

        WebElement lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastname.sendKeys("tripathi");

        WebElement Zipcode = driver.findElement(By.xpath("//input[@id='postal-code']"));
        Zipcode.sendKeys("2196");

        WebElement continuebtn = driver.findElement(By.xpath("//input[@id='continue']"));
        continuebtn.click();
        Thread.sleep(2000);


    }

    @And("User should be able to see payment information with payment order number")
    public void userShouldBeAbleToSeePaymentInformationWithPaymentOrderNumber() throws InterruptedException {
        WebElement PaymentInfo = driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[2]"));
        String OrderNo = PaymentInfo.getText();
        System.out.println("print order number"+  OrderNo);
        Thread.sleep(2000);

        WebElement finishbtn = driver.findElement(By.xpath("//button[@id='finish']"));
        finishbtn.click();

    }

    @Then("User should get success message by clicking on finish button")
    public void userShouldGetSuccessMessageByClickingOnFinishButton() throws InterruptedException {


        WebElement sucessmsg = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        sucessmsg.getText();
        System.out.println(sucessmsg);
        Thread.sleep(2000);

        driver.quit();





    }


}


