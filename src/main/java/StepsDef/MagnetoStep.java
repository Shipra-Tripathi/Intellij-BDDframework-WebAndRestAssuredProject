package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MagnetoStep {
    WebDriver driver;
    @Given("User should be able to open URL in browser")
    public void userShouldBeAbleToOpenURLInBrowser() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @When("User should be able to select Men as a categeory and select jacket")
    public void userShouldBeAbleToSelectMenAsACategeoryAndSelectJacket() throws InterruptedException {

        WebElement mencat = driver.findElement(By.cssSelector("#ui-id-5"));
        mencat.click();

        //Click Tops
        WebElement tops = driver.findElement(By.xpath("//a[contains(text(),'Tops')]"));
        tops.click();

        Thread.sleep(2000);

        //Select category
        WebElement category = driver.findElement(By.xpath("//div[contains(text(),'Category')]"));
        category.click();

        //Select Jacket section
        WebElement Jsection = driver.findElement(By.xpath("//a[contains(text(),'Jackets')]"));
        Jsection.click();

        //Select Montana jacket
        WebElement montanaj = driver.findElement(By.xpath("//a[contains(text(),'Montana Wind Jacket ')]"));
        montanaj.click();


    }

    @And("User should be able to select size and color")
    public void userShouldBeAbleToSelectSizeAndColor() {
        //Select Jacket size
        WebElement jsize = driver.findElement(By.id("option-label-size-143-item-168"));
        jsize.click();

        //Select jacket color
        WebElement jcolor = driver.findElement(By.id("option-label-color-93-item-58"));
        jcolor.click();


    }

    @And("User should be able to add product to basket")
    public void userShouldBeAbleToAddProductToBasket() throws InterruptedException {
      //Add product

        WebElement Addproduct = driver.findElement(By.id("product-addtocart-button"));
        Addproduct.click();
        Thread.sleep(3000);


        //Add to basket
        WebElement basket = driver.findElement(By.xpath("//a[@class='action showcart']"));
        basket.click();
        Thread.sleep(5000);




    }

    @And("User should be able to proceed checkout process")
    public void userShouldBeAbleToProceedCheckoutProcess() throws InterruptedException {

        //Checkout process
        WebElement checkout = driver.findElement(By.id("top-cart-btn-checkout"));
        checkout.click();

     Thread.sleep(2000);

    }

    @And("User should be able to fill address details and proceed with next button")
    public void userShouldBeAbleToFillAddressDetailsAndProceedWithNextButton() throws InterruptedException {

        WebElement email = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/input[1]"));
        email.sendKeys("shipra.tripathi259@gmail.com");


        WebElement fname = driver.findElement(By.xpath("//input[@name='firstname']"));
        fname.sendKeys("Shipra");


        WebElement lname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lname.sendKeys("Tripathi");

        WebElement comname = driver.findElement(By.xpath("//input[@name='company']"));
        comname.sendKeys("Nihilent");

        WebElement streetname = driver.findElement(By.xpath("//input[@name='street[0]']"));
        streetname.sendKeys("Sandton");

        WebElement cityname = driver.findElement(By.xpath("//input[@name='city']"));
        cityname.sendKeys("Johannesburg");

        WebElement zipcode = driver.findElement(By.xpath("//input[@name='postcode']"));
        zipcode.sendKeys("2196");

       //select country from dropdown
        WebElement countryDD = driver.findElement(By.xpath("//select[@name='country_id']"));
        Select dropdown = new Select(countryDD);
        dropdown.selectByVisibleText("South Africa");

        //phone number
        WebElement phoneno = driver.findElement(By.xpath("//input[@name='telephone']"));
        phoneno.sendKeys("0645061249");

        Thread.sleep(4000);

        //next button
        WebElement nextbtn = driver.findElement(By.xpath("//span[text()='Next']"));
        nextbtn.click();
        Thread.sleep(6000);
    }

    @And("User should be able to place a order")
    public void userShouldBeAbleToPlaceAOrder() throws InterruptedException {

        //Scrollbar down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //place order
        Thread.sleep(1000);
        WebElement placeorder= driver.findElement(By.xpath("//span[text()='Place Order']"));
        placeorder.click();


        //order number print

        WebElement order = driver.findElement(By.cssSelector(".checkout-success"));
       String orderno = order.getText();
       System.out.println("orderno      "    + orderno );
        Thread.sleep(2000);

    }

    @Then("User should get sucess message and order details")
    public void userShouldGetSucessMessageAndOrderDetails() {

        WebElement msg = driver.findElement(By.xpath("//span[text()='Thank you for your purchase!']"));
        String actualmsg = msg.getText();
        String expectedsucessmsg ="Thank you for your purchase!";
        if(actualmsg.equals(expectedsucessmsg)){

            System.out.println("Assert pass     "    + actualmsg);
        }

        else{
            System.out.println("Assert failed");
        }

        driver.close();



    }
}
