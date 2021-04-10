package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverSyncDemo {

    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        WebElement searchInput = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
//        searchInput.sendKeys("selenium java");
//        List<WebElement> searchBtn = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
//        searchBtn.get(0).click();
//        Thread.sleep(2000);
//        driver.quit();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchInput = waitForElementLocatedBy(driver, By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchInput.sendKeys("selenium java");
        List<WebElement> searchBtn = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
        searchBtn.get(0).click();
        List<WebElement> searchResults = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'tF2Cxc') and contains(.,'selenium') and contains(.,'java')]")));
        System.out.println("Search results number for requested term: " + searchResults.size());
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
