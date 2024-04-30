package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHRM {
    public WebDriver driver;



    @Given("^User opens orange hrm website on chrome$")
    public void userOpensOrangeHrmWebsiteOnChrome() throws InterruptedException {
   System.setProperty("webdriver.chrome.driver","C:\\ProjectDrive\\Required_Selenium_Software\\Drivers\\chromedriver-win32\\chromedriver.exe");
    //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @When("^User enter valid username and password$")
    public void userEnterValidUsernameAndPassword() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        Thread.sleep(3000);

        WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
        pwd.sendKeys("admin123");
        Thread.sleep(2000);


    }

   @And("^User able to clear Username and password$")
    public void userAbleToClearUsernameAndPassword() throws InterruptedException {
        //to clear
       driver.findElement(By.name("username")).sendKeys(Keys.chord(Keys.CONTROL,"A"));
       Thread.sleep(2000);
       driver.findElement(By.name("username")).sendKeys(Keys.BACK_SPACE);
       Thread.sleep(2000);


       driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.CONTROL,"A"));
       Thread.sleep(2000);
       driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
       Thread.sleep(2000);


    }

    @And("^User able to Re-enter username and password$")
    public void userAbleToReEnterUsernameAndPassword() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        Thread.sleep(3000);

        WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
        pwd.sendKeys("admin123");
        Thread.sleep(2000);


   }
    @And("User able to validate username and password text box present login page")
    public void userAbleToValidateUsernameAndPasswordTextBoxPresentLoginPage() {
        //username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));

        //Password
        WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));

        //validate present text is displayed or not
        //&& means if both the condition is true then it will print

        if(username.isDisplayed() && pwd.isDisplayed()) {

            System.out.println("username text and password text present");
        }
            else{
            System.out.println("error message is displayed");

            }
        }
    @And("User able to validate Tile of login page")
    public void userAbleToValidateTileOfLoginPage() {
        String actualtitle = driver.getTitle();
        System.out.println(actualtitle);

         //comparing result
        String expectedtitle = "OrangeHRM";

        if(actualtitle.equalsIgnoreCase(expectedtitle)){

            System.out.println("Result is matched");
        }
        else {
            System.out.println("Result is not matched");
        }

    }


    @And("^User click on login button and validate login button is enabled$")
    public void userClickOnLoginButtonAndValidateLoginButtonIsEnabled() throws InterruptedException {
        //check login button is enabled or not
    WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']")) ;
    boolean check = loginbtn.isEnabled();
    if(check){

        System.out.println("login button is enabled");

    }
    else{
        System.out.println("Login button is not enabled");
    }
    Thread.sleep(2000);
     loginbtn.click();
        Thread.sleep(2000);
        driver.close();

    }


    @Then("^User should be able to Navigated to Dashboard page$")
    public void userShouldBeAbleToNavigatedToDashboardPage() {
    }



}
