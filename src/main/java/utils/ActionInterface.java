package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
    void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);

    void BrokenLines(WebDriver driver, String siteUrl);

    void click(WebDriver driver, WebElement ele);

    void BrokenLines(WebDriver driver, WebElement siteUrl);

    boolean findElement(WebDriver driver, WebElement ele);

    boolean isDisplayed(WebDriver driver, WebElement ele);

    boolean isSelected(WebDriver driver, WebElement ele);

    boolean isEnabled(WebDriver driver, WebElement ele);

    boolean type(WebElement ele, String text);

    boolean selectBySendkeys(String value, WebElement ele);

    boolean selectByIndex(WebElement element, int index);

    boolean selectByValue(WebElement element, String value);

    boolean selectByVisibleText(String visibletext, WebElement ele);

    boolean mouseHoverByJavaScript(WebElement ele);

    boolean JSClick(WebDriver driver, WebElement ele);

    boolean switchToFrameByIndex(WebDriver driver, int index);

    boolean switchToFrameById(WebDriver driver, String idValue);

    boolean switchToFrameByName(WebDriver driver, String nameValue);

    boolean switchToDefaultFrame(WebDriver driver);

    void mouseOverElement(WebDriver driver, WebElement element);

    boolean moveToElement(WebDriver driver, WebElement ele);

    boolean mouseover(WebDriver driver, WebElement ele);

    boolean draggable(WebDriver driver, WebElement source, int x, int y);

    boolean draganddrop(WebDriver driver, WebElement source, WebElement target);

    boolean slider(WebDriver driver, WebElement ele, int x, int y);

    boolean rightclick(WebDriver driver, WebElement ele);

    boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count);

    boolean switchToNewWindow(WebDriver driver);

    boolean switchToOldWindow(WebDriver driver);

    int getColumncount(WebElement row);

    int getRowCount(WebElement table);

    boolean Alert(WebDriver driver);

    boolean launchUrl(WebDriver driver, String url);

    boolean isAlertPresent(WebDriver driver);

    String getTitle(WebDriver driver);

    String getCurrentURL(WebDriver driver);

    boolean click1(WebElement locator, String locatorName);

    void fluentWait(WebDriver driver, WebElement element, int timeOut);

    void implicitWait(WebDriver driver, int timeOut);

    void explicitWait(WebDriver driver, WebElement element, int timeOut);

    void pageLoadTimeOut(WebDriver driver, int timeOut);

    //	@Override
////	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
////		WebDriverWait wait = new WebDriverWait(driver,timeOut);
////		wait.until(ExpectedConditions.visibilityOf(element));
////	}
//	@Override
//	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
//		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
//	}
    String screenShot(WebDriver driver, String filename);

    String getCurrentTime();
}
