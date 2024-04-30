package JavaFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class form {

    public static WebDriver driver;

    public static void main (String args[]) throws InterruptedException {  //main method
        System.setProperty("webdriver.chrome.driver", "C:\\ProjectDrive\\Required_Selenium_Software\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        submitForm(driver); //call the method in main method

    }

    public static void submitForm(WebDriver driver) throws InterruptedException {  //create method and define driver

        //Enter firstname
        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.sendKeys("Shipra");
        Thread.sleep(2000);


        //Enter Lastname
        WebElement Lastname = driver.findElement(By.id("last-name"));
        Lastname.sendKeys("Tripathi");
        Thread.sleep(2000);

        //JobTitle
        //Enter Jobtitle
        WebElement Jobtitle = driver.findElement(By.id("job-title"));
        Jobtitle.sendKeys("System Analyst");
        Thread.sleep(2000);

        //Select education
        WebElement edu = driver.findElement(By.id("radio-button-3"));
        edu.click();
        Thread.sleep(2000);

        //Select gender
        WebElement gender = driver.findElement(By.id("checkbox-2"));
        gender.click();
        Thread.sleep(2000);

        //Select Exp
        WebElement exp = driver.findElement(By.cssSelector("option[value='2'"));
        exp.click();
        Thread.sleep(2000);

        //Select Date picker
        WebElement selectdate = driver.findElement(By.id("datepicker"));
        selectdate.sendKeys("11/17/2023");
        Thread.sleep(2000);
        selectdate.sendKeys(Keys.RETURN);  // for close the date picker
        Thread.sleep(2000);


        //submit form
        WebElement submitbutton = driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary"));
        submitbutton.click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle()); // get the title name of the page

        //Compare the sucess result

        String expectedsucessmsg ="The form was successfully submitted!";
        String actualmsg ="The form was successfully submitted!";

        if (expectedsucessmsg.equals(actualmsg)){

            System.out.println(expectedsucessmsg);
        }
        else {
            System.out.println("Not matched");
        }

        driver.quit();



    }

    }

