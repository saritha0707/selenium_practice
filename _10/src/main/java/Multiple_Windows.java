import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Multiple_Windows {
    //multiple tabs
    public static void main(String[] args) {
        //Multiple Checkboxes
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        String homepage = "https://www.amazon.in";
        String current_window = "";
        try {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get(homepage);
            driver.manage().window().maximize();

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoes");
            driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
            Thread.sleep(1000);
            current_window = driver.getWindowHandle();
            List<WebElement> products = driver.findElements(By.xpath("//a[@class=\"a-link-normal s-no-outline\"]//img"));
            Iterator<WebElement> it_product = products.iterator();

            System.out.println("No of links in Web Page : "+ products.size());

            if(it_product.hasNext()) {
                WebElement product = it_product.next();
                product.click();
            }
            ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

            System.out.println("No of windows:" + windows.size());
            driver.switchTo().window(current_window);

            if(it_product.hasNext()) {
                WebElement product = it_product.next();
                product.click();
            }
            windows = new ArrayList<String>(driver.getWindowHandles());

            System.out.println("No of windows:" + windows.size());
            driver.switchTo().window(current_window);
            driver.switchTo().window(windows.get(1));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
