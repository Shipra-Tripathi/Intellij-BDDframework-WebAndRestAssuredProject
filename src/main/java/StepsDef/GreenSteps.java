package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class GreenSteps {
    WebDriver driver;

        @Given("user should be able to open the url on browser")
        public void usershouldbeabletoopentheurlonbrowser(){

            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
             driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            driver.manage().window().maximize();

    }


    @And("user should be able to add product to the basket")
    public void userShouldBeAbleToAddProductToTheBasket() throws InterruptedException {


        WebElement cauliflower = driver.findElement(By.xpath("//h4[text()='Cauliflower - 1 Kg']"));
            cauliflower.click();

            Thread.sleep(4000);

        WebElement cucumber = driver.findElement(By.cssSelector("div.cart a.cart-icon:nth-child(5) > img:nth-child(1)"));
        cucumber.click();




        Thread.sleep(5000);





    }

    @And("User should be able to continue with checkout")
    public void userShouldBeAbleToContinueWithCheckout() throws InterruptedException {

            WebElement checkout = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
            checkout.click();
            Thread.sleep(2000);
    }

    @And("User should be able to proceed with place order")
    public void userShouldBeAbleToProceedWithPlaceOrder() throws InterruptedException {

        WebElement order = driver.findElement(By.xpath("//button[text()='Place Order']"));
        order.click();
        Thread.sleep(2000);



    }

    @And("user should be able to select country and proceed")
    public void userShouldBeAbleToSelectCountryAndProceed() throws InterruptedException {
         //locate the dropdown element

        WebElement dropdownElement = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]"));
        Select dropdown = new Select(dropdownElement);

            dropdown.selectByVisibleText("India");

            Thread.sleep(2000);

        WebElement checkbox = driver.findElement(By.cssSelector(".chkAgree"));
        checkbox.click();

        Thread.sleep(2000);

        WebElement proceedbtn = driver.findElement(By.xpath("//button[text()='Proceed']"));
        proceedbtn.click();






    }

    @Then("User should receive a sucess message")
    public void userShouldReceiveASucessMessage() {

           driver.close();

    }
}

