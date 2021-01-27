import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Multiple_check_boxes_amazon_in {
    public static void main(String[] args) {
        //Multiple Checkboxes
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        String homepage = "https://www.amazon.in";
        try {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get(homepage);
            driver.manage().window().maximize();

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoes");
            driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
            Thread.sleep(1000);

            List<WebElement> checkbox = driver.findElements(By.xpath("//div[@id=\"brandsRefinements\"]//input[@type=\"checkbox\"]/following-sibling::i"));
            Iterator<WebElement> brand_iterator = checkbox.iterator();

            List<WebElement> checkbox_text = driver.findElements(By.xpath("//div[@id=\"brandsRefinements\"]//input[@type=\"checkbox\"]/following-sibling::i"));
            Iterator<WebElement> brand_text = checkbox_text.iterator();
            String Text;
            ArrayList<String> brands =  new ArrayList<String>();
            brands.add("ASIAN");
            brands.add("Campus");
            brands.add("Ethics");
            brands.add("CLYMB");
            brands.add("T-Rock");
            while(brand_iterator.hasNext())
            {
                WebElement element = brand_iterator.next();
                brand_text.hasNext();
                WebElement element1 = brand_text.next();
                Text = element1.getText();
                if(brands.contains(Text)) {
                    element.click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

