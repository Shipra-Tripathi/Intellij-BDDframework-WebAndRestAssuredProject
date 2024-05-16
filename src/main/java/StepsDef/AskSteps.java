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
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AskSteps {
    WebDriver driver;
        @Given("user should be able to open URL in browser")
     public void usershouldbeabletoopenURLinbrowser() throws InterruptedException {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get("https://askmeoffers.com/");
             driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
              driver.manage().window().maximize();


        }


    @And("User should be able to navigated on dashboard screen")
    public void userShouldBeAbleToNavigatedOnDashboardScreen() {


    }

    @When("User should be able to click on Home page and search the products and validate title")
    public void userShouldBeAbleToClickOnHomePageAndsearchtheproductsandredeemcoupons() throws InterruptedException {

        WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        home.getText();
        Thread.sleep(2000);
        String expectedtitlepage = "Home";

        if (home.getText().equals(expectedtitlepage)) {

            System.out.println("title matched  " + expectedtitlepage);
        } else {

            System.out.println("title not matched");
        }


        //Search the product and store coupons
        //positive scenario

        WebElement searchicon = driver.findElement(By.xpath("//input[@id='headserpp']"));
        searchicon.click();

        WebElement searchproduct = driver.findElement(By.xpath("//input[@id='my-input-inside']"));
        searchproduct.sendKeys("BIBA");

        //select the product
        WebElement selectproduct = driver.findElement(By.xpath("//p[contains(text(),'biba.in')]"));
        selectproduct.click();
        Thread.sleep(3000);

        //Get the product title details
        WebElement Title = driver.findElement(By.xpath("//h1[contains(text(),'Biba India Coupons')]"));
        String productTitle = Title.getText();
        System.out.println("Search product details displayed   " + productTitle);



        }



    @And("User should be able to click on About us page and validate")
    public void userShouldBeAbleToClickOnAboutUsPageAndValidate() {


        WebElement aboutpage = driver.findElement(By.xpath("//a[contains(text(),'About Us')]"));
        aboutpage.getText();
        String Expectedaboutpagetitle = "About Us";

        if(aboutpage.getText().equals(Expectedaboutpagetitle)) {

            System.out.println("About us page title matched  " + Expectedaboutpagetitle);
        }
        else{

            System.out.println("About us title not matched");
        }



    }

    @And("User should be able to click on breaking news and validate")
    public void userShouldBeAbleToClickOnBreakingNewsAndValidate() throws InterruptedException {


        WebElement breakingnews = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]"));
         breakingnews.click();

         Thread.sleep(5000);



        WebElement search = driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[2]/button[1]/span[2]"));
       search.click();
      //positive sceanrio 1

        WebElement searchtext1 = driver.findElement(By.cssSelector("#search-form-2"));
        searchtext1.sendKeys("BBC news");

        WebElement submit1 = driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/button[1]"));
        submit1.click();

        WebElement result = driver.findElement(By.xpath("//a[text()='Otto Sale Calendar: German Efficiency in Seasonal Sales!']"));
        String resultdsiplay = result.getText();


        System.out.println("Search result founds  "    +     resultdsiplay);

        driver.navigate().back();
        Thread.sleep(3000);
        searchtext1.clear();
        System.out.println("I am in back window1");

       Thread .sleep(4000);


       //positive sceanrio 2 but not getting result while searching with "Budget options"  getting error page instead this result should be "no result found"


        WebElement searchtext2 = driver.findElement(By.cssSelector("#search-form-2"));
      searchtext2.sendKeys("Budget options");

       WebElement submit = driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/button[1]"));
       submit.click();
        Thread.sleep(4000);

       WebElement errorpage = driver.findElement(By.xpath("//p[contains(text(),'There has been a critical error on this website')]"));
          String errorresult = errorpage.getText();

          System.out.println("error page    "    +      errorresult);

        driver.navigate().back();
        searchtext2.clear();
        System.out.println("I am in back window2 ");

        Thread.sleep(3000);



    }



    @When("user should receive a message no result found  while searching invalid data in breaking news tab")
    public void userShouldReceiveAMessageNoResultFoundWhileSearchingInvalidDataInBreakingNewsTab() throws InterruptedException {

        WebElement noresultfound = driver.findElement(By.cssSelector("#search-form-2"));
        noresultfound.sendKeys("AAABBBBCSDSF");

        WebElement submit = driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/button[1]"));
        submit.click();
        Thread.sleep(4000);

       WebElement noresult = driver.findElement(By.xpath("//h1[contains(text(),'Nothing Found')]"));
       String error = noresult.getText();
       System.out.println("error message displayed"      +           error);


    }


    @Then("user should be able to go back to home page")
    public void userShouldBeAbleToGoBackToHomePage() {

        driver.navigate().back();

        driver.close();
    }
}

