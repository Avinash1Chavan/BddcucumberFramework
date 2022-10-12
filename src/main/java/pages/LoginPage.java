package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver rDriver)
    {
        driver=rDriver;

        PageFactory.initElements(rDriver, this);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    private By forgotPwdLink = By.linkText("Forgot your password?111");
    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }



    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement pass_text;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement LoginBtn;


    @FindBy(linkText = "Logout")
    WebElement logout;


    public void LoginDetails(String uname , String password) throws InterruptedException {
        email.clear();
        Thread.sleep(4000);
        email.sendKeys(uname);
        pass_text.clear();
        pass_text.sendKeys(password);
    }



    public void clickOnLoginButton()
    {
        LoginBtn.click();
    }

    public void clickOnLogOutButton()
    {
        logout.click();
    }
}
