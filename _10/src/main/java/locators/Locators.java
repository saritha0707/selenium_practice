package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class Locators {

    public static void main(String[] args)
    {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions(); options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver","D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        try
        {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get("https://www.techgig.com/");
            driver.manage().window().maximize();

            //LinkText
            driver.findElement(By.linkText("Login")).click();
            Thread.sleep(1000);
            //Click on SignUp using partialLinkText
            driver.findElement(By.partialLinkText("Sign")).click();

            //enter first_name using name locator
            driver.findElement(By.name("first_name")).sendKeys("ABC");

            //mention explicit wait till radio button is displayed on page
            //select student radio button using id
            driver.findElement(By.id("student")).click();

            //enter email using css selector
            driver.findElement(By.cssSelector("#register_email")).sendKeys("abcxyz@mailinator.com");

            //select agreement using classname
            driver.findElement(By.className("agreement")).click();

            Thread.sleep(3000);
            //   driver.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }
}
