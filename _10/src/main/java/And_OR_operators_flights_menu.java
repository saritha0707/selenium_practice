import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class And_OR_operators_flights_menu {
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

            //validate Flights menu is available and selected by default AND operator
            String flights = "//span[contains(@class,\"chFlights\") and contains(@class,\"active\")]";
            Assert.assertNotNull(driver.findElement(By.xpath(flights)),"Flights menu is not in active state");

            //identify same flights menu with OR operator
            flights = "//li[@data-cy=\"menu_Flights\" or @class=\"menu_Flights\"]//span[text()=\"Flights\"]";
            Assert.assertNotNull(driver.findElement(By.xpath(flights)));

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
