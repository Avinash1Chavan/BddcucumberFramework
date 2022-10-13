package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@class='col-xs-20 searchformInput keyword']")
    WebElement itemSearch;

    @FindBy(css = "span.searchTextSpan")
    WebElement SearchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void enterItemInSearch(String searchItem) {
           itemSearch.sendKeys(searchItem);
    }

    public WebElement ClickSearchButton() {
        return SearchButton;
    }
}
