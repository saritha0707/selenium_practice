import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class Make_My_Trip_HomePage {

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
            //System.out.println(driver.getTitle());
        //Below validation of Title contains updated Rewards , we need to validate partially
        Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","Make My Trip Home Page Is not displayed");

            //Scenario 1 : Validate selected country is INDIA (Contains method and basic XPATH)
        String country = "//div[@class=\"ctrySelect\"]//p[contains(@class,\"ctrySelectText\")]";
        Assert.assertEquals(driver.findElement(By.xpath(country)).getText(),"IN","Selected Country is not INDIA");

        //Scenario 2 :Validate Flights Icon is active
        //check menu_Flights is available on home page
        String flights = "//li[@data-cy=\"menu_Flights\"]";
        Assert.assertNotNull(driver.findElement(By.xpath(flights)),"Flights menu is not available in Home Page");

        //validate Flights menu is available and selected by default
        flights = "//span[contains(@class,\"chFlights\") and contains(@class,\"active\")]";
        Assert.assertNotNull(driver.findElement(By.xpath(flights)),"Flights menu is not in active state");

        // Scenario 3 : Click on Flights
            driver.findElement(By.xpath(flights)).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.makemytrip.com/flights/","Even after clicking on Flights web page is not navigated to Flights");

        /*//Scenario 4 : Validate ONEWAY is selected by default
        String oneway = "//li[@data-cy=\"oneWayTrip\"]";
        driver.findElement(By.xpath(oneway));
*/          driver.close();
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
