package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPriceRange {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='fromVal']")
    WebElement clickFirstPrice;

    @FindBy(xpath = "//input[@name='toVal']")
    WebElement clickLastPrice;

    @FindBy(xpath = "//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")
    WebElement clickGoButton;

    public SelectPriceRange(WebDriver driver)

    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstPriceRange() throws InterruptedException {
        Thread.sleep(3000);
        clickFirstPrice.sendKeys("700");
    }

    public void clickLastPriceRange() {
         clickLastPrice.sendKeys("3000");
    }

    public void clickonGOButton() {
        clickGoButton.click();
    }

}
