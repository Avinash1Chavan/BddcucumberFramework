package stepdefinations;

import Factory.DriverFactory;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyStepdefs {

    public static String title;
    public static String actualMessage;
    public static String removeMessage;
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private SortBy sortBy = new SortBy(DriverFactory.getDriver());

    private SelectFirstItem selectFirstItem = new SelectFirstItem(DriverFactory.getDriver());

    private SelectPriceRange selectPriceRange = new SelectPriceRange(DriverFactory.getDriver());

    private AddToCart addToCart = new AddToCart(DriverFactory.getDriver());

    private VerifyAddToCartItem verifyAddToCartItem = new VerifyAddToCartItem(DriverFactory.getDriver());

    private RemoveCartAndVerify removeCartAndVerify= new RemoveCartAndVerify(DriverFactory.getDriver());

    public WebDriver driver;

    @Given("user is on home page")
    public void user_Is_On_Home_Page() {
        DriverFactory.getDriver().get("https://www.snapdeal.com/");
    }


    @When("user enter the item in search engine from given sheetname {string} and rownumber {int}")
    public <rowNumber> void userEnterTheItemInSearchEngineFromGivenSheetnameAndRownumberRowNumber(String sheetName, int rowNumber) throws Throwable {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData("src/main/java/utils/TestData.xlsx", sheetName);
        String SearchKeyword = testData.get(rowNumber).get("Product");
        System.out.println("SearchItem :" + SearchKeyword);

        homePage.enterItemInSearch(SearchKeyword);
    }

    @And("Click on search button")
    public void clickOnSearchButton() {

        homePage.ClickSearchButton();
    }

//    @Then("user gets the title of the page")
//    public void user_gets_the_title_of_the_page() {
//
//        title = homePage.getHomePageTitle();
//        System.out.println(title);
//    }
//
//    @Then("page title should be {string}")
//    public void page_title_should_be(String expectedTitleName) {
//        Assert.assertTrue(title.equalsIgnoreCase(expectedTitleName));
//
//    }


    @When("user clicks on the sort by button")
    public void userClicksOnTheSortByButton() {
        sortBy.ClickonSortby();
    }

    @And("user clicks on the popularity")
    public void userClicksOnThePopularity() {
        sortBy.clickpopularity();
    }

    @And("user sets the price range")
    public void userSetsTheSecondPriceRange() throws InterruptedException {
        selectPriceRange.clickFirstPriceRange();
        selectPriceRange.clickLastPriceRange();
        selectPriceRange.clickonGOButton();
    }

    @When("user clicks on the first item")
    public void userClicksOnTheFirstItem() {
        selectFirstItem.clickOnFristIteam();
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
    }

    @And("user clicks on add to cart")
    public void userClicksOnAddToCart() {
        addToCart.SelectAddtoCart();
    }

    @And("user verifies item added to cart")
    public void userVerifiesItemAddedToCart() {
        verifyAddToCartItem.clickonviewCart();
    }

    @And("user verifies item removed from cart")
    public void userVerifiesItemRemovedFromCart() {
        removeCartAndVerify.clickRemoveCart();
    }

    @Then("user gets message")
    public void userGetsMessage() {
        removeCartAndVerify.verifyremoveCart();
    }

    @And("the message should be {string}")
    public void theMessageShouldBe(String expectedRemoveMessage) {
        Assert.assertTrue(removeMessage.equalsIgnoreCase(expectedRemoveMessage));
    }


//    @Then("user gets the message")
//    public void userGetsTheMessage() {
//        actualMessage = sortBy.VerifysearchCriteria().getText();
//        System.out.println("Message :"+ actualMessage);
//    }
//
//    @And("message should be {string}")
//    public void messageShouldBe(String expectedMessage) {
//        Assert.assertTrue(actualMessage.contains(expectedMessage));
//    }
}

//    public static String title;
//    private HomePage homePage = new HomePage(DriverFactory.getDriver());
//
//    public WebDriver driver;
//
////    @Given("user is on login page")
////    public void user_is_on_login_page() {
////        DriverFactory.getDriver().get("https://www.snapdeal.com/");
////    }
////    @When("user fills the form from given SheetName {string} and rowNumber {int}")
////    public void user_fills_the_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InterruptedException {
////        ExcelReader reader = new ExcelReader();
////        List<Map<String, String>> testData =
////                reader.getData("src/main/java/utils/TestData.xlsx", sheetName);
////        String uname = testData.get(rowNumber).get("Username");
////        String pass = testData.get(rowNumber).get("Password");
////        System.out.println("username :" + uname);
////
////        loginPage.LoginDetails(uname, pass);
////    }
////    @When("Click on Login")
////    public void click_on_login() {
////        loginPage.clickOnLoginButton();
////    }
////    @Then("user gets the title of the page")
////    public void user_gets_the_title_of_the_page() {
////        title = loginPage.getLoginPageTitle();
////    }
////    @Then("page title should be {string}")
////    public void page_title_should_be(String expectedTitleName) {
////        Assert.assertTrue(title.contains(expectedTitleName));
////    }
//
//    @Given("user is on home page")
//    public void user_Is_On_Home_Page() {
//        DriverFactory.getDriver().get("https://www.snapdeal.com/");
//    }
//
//
//    @When("user enter the item in search engine from given sheetname {string} and rownumber {int}")
//    public <rowNumber> void userEnterTheItemInSearchEngineFromGivenSheetnameAndRownumberRowNumber(String sheetName, int rowNumber) throws Throwable {
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testData =
//                reader.getData("src/main/java/utils/TestData.xlsx", sheetName);
//        String SearchKeyword = testData.get(rowNumber).get("Product");
//        System.out.println("SearchItem :" + SearchKeyword);
//
//        homePage.enterItemInSearch(SearchKeyword);
//    }
//
//    @And("Click on search button")
//    public void clickOnSearchButton() {
//        homePage.ClickSearchButton();
//    }
//
//    @Then("user gets the title of the page")
//    public void user_gets_the_title_of_the_page() {
//        title = homePage.getHomePageTitle();
//    }
//
//    @Then("page title should be {string}")
//    public void page_title_should_be(String expectedTitleName) {
//        Assert.assertTrue(title.contains(expectedTitleName));
//    }
//


