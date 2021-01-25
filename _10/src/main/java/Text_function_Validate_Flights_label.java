import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Text_function_Validate_Flights_label {
    public static void main(String[] args)
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get("https://www.makemytrip.com");
            driver.manage().window().maximize();

            // Scenario 6 : locate Flights Text under menu
            Assert.assertNotNull(driver.findElement(By.xpath("//span[text()=\"Flights\"]")));
            driver.close();
        }
        catch(Exception e)
        {

        }

    }

}
