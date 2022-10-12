package stepdefinations;

import Factory.DriverFactory;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    public static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    public WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://admin-demo.nopcommerce.com/login");
    }
    @When("user fills the form from given SheetName {string} and rowNumber {int}")
    public void user_fills_the_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData("src/main/java/utils/TestData.xlsx", sheetName);
        String uname = testData.get(rowNumber).get("Username");
        String pass = testData.get(rowNumber).get("Password");
        System.out.println("username :" + uname);

        loginPage.LoginDetails(uname, pass);
    }
    @When("Click on Login")
    public void click_on_login() {
        loginPage.clickOnLoginButton();
    }
    @Then("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }
}
