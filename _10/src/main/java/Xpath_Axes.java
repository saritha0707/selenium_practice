import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Xpath_Axes {
    public static void main(String[] args)
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        try
        {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().window().maximize();

            //Navigate to Form tag using ancestor axis
            String xpath = "//label[text()=\"Name\"]/ancestor::form";
            Assert.assertNotNull(driver.findElement(By.xpath(xpath)),"Form tag is not available in Home Page");

            //To Navigate till first name from form tag with Child Axis
            xpath="//form[@id=\"userForm\"]/child::div[1]//input[1]";
            driver.findElement(By.xpath(xpath));

            //Click on Yes Radio button
            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();
            xpath = "//div[@id=\"app\"]/descendant::input[@id=\"yesRadio\"]";
            driver.findElement(By.xpath(xpath));

            //to locate current address text area using following Axis
            driver.get("https://demoqa.com/text-box");
            xpath="//input[@id=\"userName\"]/following::textarea";
            driver.findElement(By.xpath(xpath));

            //following sibiling to locate next input area
            xpath="//div[@id=\"userName-wrapper\"]/following-sibling::div//input";
            driver.findElement(By.xpath(xpath));

            //to locate radio button using parent axis
            driver.get("https://demoqa.com/radio-button");
            xpath="//label[text()=\"Yes\"]/parent::div";
            driver.findElement(By.xpath(xpath));

            //using preceding axis
            driver.get("https://demoqa.com/text-box");
            xpath="//input[@id=\"userName\"]/preceding::label";
            driver.findElement(By.xpath(xpath));
            driver.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
  /*      finally {
            driver.close();
        }*/
    }
}
