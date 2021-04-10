package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class GoogleHomePagePF {

    private final static String HOMEPAGE_URL = "https://www.google.com/";
    private final WebDriver driver;
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='tfB0Bf']/descendant::input[@class='gNO89b']")
    private WebElement searchButton;

    public GoogleHomePagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static void waitForElementLocatedBy(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public GoogleHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.pageLoadCompleted());
        return this;
    }

    public SearchResultsPagePFMixed searchForTerms(String term) {
        searchInput.sendKeys(term);
        waitForElementLocatedBy(driver, searchButton);
        searchButton.click();
        return new SearchResultsPagePFMixed(driver, term);
    }
}
