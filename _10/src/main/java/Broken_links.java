import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Broken_links {

    public static void main(String[] args)
    {
            //Broken Links
            //URL : http://newtours.demoaut.com/
        WebDriver driver;
        HttpURLConnection huc = null;
        int responseCode=200;
        String url = "";
        ChromeOptions options = new ChromeOptions(); options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver","D:\\Nisum_2021\\selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        String homepage = "https://www.techgig.com";
        try {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.get(homepage);
            driver.manage().window().maximize();

            List<WebElement> links = driver.findElements(By.tagName("a"));

            Iterator<WebElement> it = links.iterator();
            System.out.println("No of links in Web Page : "+ links.size());
            while(it.hasNext())
            {
                url = it.next().getAttribute("href");
                if(url == null) {
                    System.out.println("URL is either not configured for anchor tag or it is empty");
                    continue;
                }
                else if(!url.startsWith(homepage))
                {
                    System.out.println("URL:"+url+" belongs to another domain , Skipping it");
                    continue;
                }
                else
                {
                    huc = (HttpURLConnection)(new URL(url).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    responseCode=huc.getResponseCode();
                    if(responseCode>=400)
                        System.out.println("URL : "+ url + "is broken link");
                    else
                        System.out.println("URL : "+ url + "is valid link");
                }
            }
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
        }
}
