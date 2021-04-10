package hello_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.selenium.dev/");
        Thread.sleep(2000);
        chromeDriver.quit();

        System.setProperty("webdriver.edge.driver", "C://WebDriver/msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://www.selenium.dev/");
        Thread.sleep(2000);
        edgeDriver.quit();

        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.selenium.dev/");
        Thread.sleep(2000);
        firefoxDriver.quit();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.google.com/");
        WebElement searchInput1 = driver1.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchInput1.sendKeys("selenium java");
        WebElement searchBtn = driver1.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
        searchBtn.click();
        Thread.sleep(2000);
        driver1.quit();

        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.google.com/");
        WebElement searchInput2 = driver2.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchInput2.sendKeys("selenium java");
        List<WebElement> searchBtn2 = driver2.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
        searchBtn2.get(0).click();
        Thread.sleep(2000);
        driver2.quit();
    }
}
