package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverSyncDemoExplicit {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        new WebDriverWait(driver, 10)
                .until(CustomConditions.pageLoadCompleted());
        WebElement searchInput = waitForElementLocatedBy(driver, By.xpath("//input[@class='gLFyf gsfi']"));
        searchInput.sendKeys("selenium java");
        List<WebElement> searchBtn = driver.findElements(By.xpath("//div[@class='tfB0Bf']/descendant::input[@class='gNO89b']"));
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
