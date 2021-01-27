package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class locate_Flights_starts_with_function {


    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get("https://www.makemytrip.com");
            driver.manage().window().maximize();

            //Scenario 5 locate Flights with starts-with function
            //System.out.println(driver.getTitle());
            //using getTitle method
            Assert.assertEquals(driver.getTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", "Make My Trip Home Page Is not displayed");

            Assert.assertNotNull(driver.findElement(By.xpath("//ul[starts-with(@class,\"makeFlex\")]/li[@class=\"menu_Flights\"]")));
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
  /*      finally {
            driver.close();
        }*/
    }
    }
