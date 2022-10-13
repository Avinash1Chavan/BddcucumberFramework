package stepdefinations;

import Factory.DriverFactory;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    public static String title;
    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    public WebDriver driver;

//    @Given("user is on login page")
//    public void user_is_on_login_page() {
//        DriverFactory.getDriver().get("https://www.snapdeal.com/");
//    }
//    @When("user fills the form from given SheetName {string} and rowNumber {int}")
//    public void user_fills_the_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InterruptedException {
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testData =
//                reader.getData("src/main/java/utils/TestData.xlsx", sheetName);
//        String uname = testData.get(rowNumber).get("Username");
//        String pass = testData.get(rowNumber).get("Password");
//        System.out.println("username :" + uname);
//
//        loginPage.LoginDetails(uname, pass);
//    }
//    @When("Click on Login")
//    public void click_on_login() {
//        loginPage.clickOnLoginButton();
//    }
//    @Then("user gets the title of the page")
//    public void user_gets_the_title_of_the_page() {
//        title = loginPage.getLoginPageTitle();
//    }
//    @Then("page title should be {string}")
//    public void page_title_should_be(String expectedTitleName) {
//        Assert.assertTrue(title.contains(expectedTitleName));
//    }

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

    @Then("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = homePage.getHomePageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }
}

