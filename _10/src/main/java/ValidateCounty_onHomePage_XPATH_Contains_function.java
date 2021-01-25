import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class ValidateCounty_onHomePage_XPATH_Contains_function {

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
