package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WebDriverSyncDemoFluent {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        new WebDriverWait(driver, 10)
                .until(CustomConditions.pageLoadCompleted());
        WebElement searchInput = waitForElementLocatedBy(driver, By.xpath("//input[@class='gLFyf gsfi']"));
        searchInput.sendKeys("selenium java");
        List<WebElement> searchBtn = driver.findElements(By.xpath("//div[@class='tfB0Bf']/descendant::input[@class='gNO89b']"));
        searchBtn.get(0).click();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result list was exceeded!");
        List<WebElement> searchResults = wait.until(webDriver -> driver.findElements(By.xpath("//div[contains(@class, 'tF2Cxc') and contains(.,'selenium') and contains(.,'java')]")));
        System.out.println("Search results number for requested term: " + searchResults.size());
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
