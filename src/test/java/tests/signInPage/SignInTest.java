package tests.signInPage;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;

public class SignInTest extends BaseTest {


    private final By profileBtn = By.xpath("//span[text()='Профиль']");
    private final By wrongPassError = By.xpath("//div[@class='text-danger-500 pt-1.5 text-subhead']");
    private final By LoginTitle = By.xpath("//h2[text() = 'Log in']");
    @DataProvider(name = "credentials")
    public Object[][] getData()
    {
         Object[][]  data={
                {"bothCorrect","admin", "pwd"},
                {"existingEmailwrongPass", "andrey.stepanov.tr@gmail.com", "Admin00kk"},
                 {"emptyFields","",""}};
                 return data;
    }

    private final By SampleAppTitle = By.xpath("//h3[text() = 'Sample App']");

    @Test
    public void checkUserOnMainPage(){
        basePage.open(PLAYGROUND_HOME_PAGE);

        playgroundHomePage.checkUserOnPlaygroundPage();
        Assert.assertEquals("UI Test Automation\n" +
                "Playground", playgroundHomePage.checkUserOnPlaygroundPage());
    }

    @Test
    public void checkUserOnSampleAppPage(){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToLoginPage();
     //   WebDriverWait wait = new WebDriverWait(driver, 15);
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text() = 'Log in']")));
        WebElement SampleApp_Title = driver.findElement(SampleAppTitle);
        Assert.assertTrue(SampleApp_Title.isDisplayed());
    }

    @Test(dataProvider = "credentials")
    public void checkSignInCredentials(String scenario, String username, String password){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToLoginPage();
        if (scenario.equals("bothCorrect")) {
            playgroundSignInPage.enterUsername(username);
            playgroundSignInPage.enterPassword(password);
            playgroundSignInPage.clickOnLogin();
            playgroundSignInPage.checkLoginIsSuccessful();
            Assert.assertEquals("Welcome, " + username + "!", playgroundSignInPage.checkLoginIsSuccessful());
            playgroundSignInPage.clickOnLogin(); //logout
        } else if (scenario.equals("existingEmailwrongPass")){
            playgroundSignInPage.enterUsername(username);
            playgroundSignInPage.enterPassword(password);
            playgroundSignInPage.clickOnLogin();
            Assert.assertEquals("Invalid username/password", playgroundSignInPage.checkLoginIsSuccessful());
            playgroundSignInPage.clickOnLogin(); //logout
        } else if (scenario.equals("emptyFields")) {
            playgroundSignInPage.enterUsername(username);
            playgroundSignInPage.enterPassword(password);
            playgroundSignInPage.clickOnLogin();
            Assert.assertEquals("Invalid username/password", playgroundSignInPage.checkLoginIsSuccessful());
            playgroundSignInPage.clickOnLogin(); //logout
        }
    }

}
