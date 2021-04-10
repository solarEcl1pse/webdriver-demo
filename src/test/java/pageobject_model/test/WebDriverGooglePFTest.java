package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.GoogleHomePagePF;

public class WebDriverGooglePFTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "First browser test, JIRA binding can be here")
    public void commonSearchTermResultsAreNotEmpty() {
        int expectedSearchResultsNumber = new GoogleHomePagePF(driver)
                .openPage()
                .searchForTerms("selenium java")
                .countResultsNumberWithSearchTerm();
        Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserClosing() {
        driver.quit();
        driver = null;
    }
}
