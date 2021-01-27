package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class last_function_flights_menu {


    public static void main(String[] args)
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        try
        {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get("https://www.makemytrip.com");
            driver.manage().window().maximize();

            //validate Flights menu with specified position
            String flights = "//li[@data-cy=\"menu_Flights\"]//span[last()]";
            Assert.assertNotNull(driver.findElement(By.xpath(flights)),"Flights menu is not available on Home page");
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
