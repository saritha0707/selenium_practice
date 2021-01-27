import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Actions_Amazon_site {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        String homepage = "https://www.amazon.in";
        try {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get(homepage);
            driver.manage().window().maximize();
            WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
            Actions search_text = new Actions(driver);
            //select second search value from search bar
            search_text.keyDown(element, Keys.SHIFT).sendKeys(element,"shoes").sendKeys(element, Keys.SPACE);
            search_text.build().perform();

            search_text.sendKeys(element, Keys.DOWN).sendKeys(element, Keys.DOWN).sendKeys(element, Keys.ENTER);
            search_text.build().perform();

            //mouseover "signin" in Amazon.in and click on signin
            element = driver.findElement(By.cssSelector("#nav-link-accountList"));
            Actions account = new Actions(driver);
            account.moveToElement(element).build().perform();
            element.click();



        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }
}