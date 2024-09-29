package pages.signIn;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class PlaygroundSignInPage extends BasePage {
    public PlaygroundSignInPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.xpath("//input[@placeholder = 'User Name']");
    private final By passwordInput = By.xpath("//input[@name = 'Password']");
    private final By loginButton = By.xpath("//button[@id = 'login']");
    private final By loginstatus = By.xpath("//label[@id = 'loginstatus']");

    public PlaygroundSignInPage enterUsername(String username){
  //  WebElement usernameinput = waitForElement(usernameInput, 3);
               WebElement usernameinput = driver.findElement((By) usernameInput);
    //    clickWhenReady(usernameInput, EXPLICIT_WAIT);
        usernameinput.click();
        usernameinput.sendKeys(username);
        return this;
    }

    public PlaygroundSignInPage enterPassword(String password){
        WebElement passwordinput = driver.findElement((By) passwordInput);
        passwordinput.click();
        passwordinput.sendKeys(password);
        return this;
    }
    public PlaygroundSignInPage clickOnLogin(){
        WebElement loginBtn = driver.findElement((By) loginButton);
        loginBtn.click();
        return this;
    }
    public String checkLoginIsSuccessful(){
        WebElement LogInStatus = driver.findElement((By) loginstatus);
        return LogInStatus.getText();
    }

    }

