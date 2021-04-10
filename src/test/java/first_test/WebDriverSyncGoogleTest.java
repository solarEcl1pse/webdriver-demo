package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import waits.CustomConditions;

import java.util.List;

public class WebDriverSyncGoogleTest {

    private WebDriver driver;

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "First browser test, JIRA binding can be here")
    public void commonSearchTermResultsAreNotEmpty() {
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
        Assert.assertTrue(searchResults.size() > 0, "Search results are empty!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserClosing() {
        driver.quit();
        driver = null;
    }
}
