package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPagePFMixed {

    private final String splitRegex = "\\s";
    private final WebDriver driver;
    private final String searchTerm;

    private String defaultLocator = "//div[contains(@class, 'tF2Cxc')%s";
    private String containsPart = " and contains(.,'%s')";

    @FindBy(xpath = "//div[contains(@class, 'tF2Cxc')]")
    private List<WebElement> generalSearchResults;

    public SearchResultsPagePFMixed(WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }

    public int countGeneralNumberOfSearchResults() {
        System.out.println("Search results number for requested term: " + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath(new SearchResultsPagePFMixed(driver, searchTerm).buildLocatorForSearch()));
        System.out.println("Search results number for requested term: " + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }

    private String buildLocatorForSearch() {
        StringBuilder partWithSearchTerm = new StringBuilder();
        String[] terms = searchTerm.split(splitRegex);
        for (String term : terms) {
            partWithSearchTerm.append(String.format(containsPart, term));
        }
        String locatorForSearch = String.format(defaultLocator, partWithSearchTerm);
        locatorForSearch += "]";
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }
}
