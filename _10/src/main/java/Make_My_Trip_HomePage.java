import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class Make_My_Trip_HomePage {

    public static void main(String[] args)
    {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions(); options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver","D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
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
            flights = "//li[@data-cy=\"menu_Flights\"]";
           driver.findElement(By.xpath(flights)).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.makemytrip.com/flights/","Even after clicking on Flights web page is not navigated to Flights");

        //Scenario 4 : Validate ONEWAY is selected by default
        String oneway = "//li[@data-cy=\"oneWayTrip\"]";
        System.out.println("\n"+oneway);
        driver.findElement(By.xpath(oneway)).click();
        oneway="//li[@data-cy=\"oneWayTrip\" and @class=\"selected\"]";
        Assert.assertNotNull(driver.findElement(By.xpath(oneway)),"Oneway is not in selected state");

        //Scenario : Enter From and To Destination and click on search button
            //from type=text and XPATH : //input[@id="fromCity" and type="text"] - click on this and then enter text
           //from XPATH : //input[@placeholder="From"] (cross-check while execution)
           //Select Hyderabad XPATH: //ul[@role="listbox"]/following::p[contains(text(),"Hyderabad, India")]
           //To XPATH :
            String From = "//input[@id=\"fromCity\" and @type=\"text\"]";
            driver.findElement(By.xpath(From)).click();

            From="//input[@placeholder=\"From\"]";
            driver.findElement(By.xpath(From)).sendKeys("Hyderabad");
            Thread.sleep(1000);
            String selectFrom = "//ul[@role=\"listbox\"]//p[contains(text(),\"Hyderabad, India\")]";
                    /*"//ul[@role=\"listbox\"]/following::p[contains(text(),\"Hyderabad, India\")]";*/
            System.out.println(selectFrom);
            driver.findElement(By.xpath(selectFrom)).click();

/*
            String To = "//input[@id=\"toCity\" and @type=\"text\"]";
            driver.findElement(By.xpath(To)).click();
*/

            String To ="//input[@placeholder=\"To\"]";
            driver.findElement(By.xpath(To)).sendKeys("Bengaluru");
            Thread.sleep(1000);
            String selectTo = "//ul[@role=\"listbox\"]//p[contains(text(),\"Bengaluru, India\")]";
            driver.findElement(By.xpath(selectTo)).click();

            //select Date //div[@class="DayPicker-Day DayPicker-Day--today"]/following-sibling::div[1]
            driver.findElement(By.xpath("//div[@class=\"DayPicker-Day DayPicker-Day--today\"]/following-sibling::div[2]")).click();


            //Click on Search button
            driver.findElement(By.xpath("//p[@data-cy=\"submit\"]")).click();

            //validate search result page
            String expected = "Flights from Hyderabad to Bengaluru";
            String actual = driver.findElement(By.xpath("//div[@id=\"left-side--wrapper\"]/p[contains(@class,\"heading\")]")).getText();
            Assert.assertEquals(actual,expected,"Search result does not match with the text");

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
