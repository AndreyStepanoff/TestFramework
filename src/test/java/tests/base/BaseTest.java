package tests.base;

import common.CommonActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.frames.FramesPage;
import pages.listing.PlaygroundTextInputPage;
import pages.loadDelay.PlaygroundLoadDelayPage;
import pages.mouseover.PlaygroundMouseOverPage;
import pages.nbsp.PlaygroundNbspPage;
import pages.practice.PracticePage;
import pages.realt_home.PlaygroundHomePage;
import pages.signIn.PlaygroundSignInPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected PlaygroundHomePage playgroundHomePage = new PlaygroundHomePage(driver);
    protected PlaygroundSignInPage playgroundSignInPage = new PlaygroundSignInPage(driver);
    protected PlaygroundTextInputPage playgroundTextInputPage = new PlaygroundTextInputPage(driver);
    protected PlaygroundLoadDelayPage playgroundLoadDelayPage = new PlaygroundLoadDelayPage(driver);
    protected PlaygroundNbspPage playgroundNbspPage = new PlaygroundNbspPage(driver);
    protected PlaygroundMouseOverPage playgroundMouseOverPage = new PlaygroundMouseOverPage(driver);
    protected PracticePage practicePage = new PracticePage(driver);
    public FramesPage framesPage = new FramesPage(driver);

    public static String getTimeString(){
        LocalDateTime dateTimeObj = LocalDateTime.now();
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = dateTimeObj.format(dateTimePattern);
        return formattedDate;
    }
    @AfterTest
    public void clearCookiesAndLocalStorage() throws IOException {
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }

        System.out.println("Test was executed at :" + getTimeString());

        String filename = getTimeString() + ".png";
        String directory = "src/main/resources";

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }

}
