package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver){

        this.driver = driver;
    }
    public void open(String url){
        driver.get(url);
    }

//    public WebElement waitElementIsVisible(WebElement element){
 //       new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
//        return element;
    }

//    public WebElement waitForElement(By locator, int timeout){
//        WebElement element = null;
//        try {
//            System.out.println("Waiting for max: " + timeout + "seconds for element to be available");
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            System.out.println("Element appeared on the Webpage");
//        } catch(Exception e) {
//            System.out.println("Element not appeared on the Webpage");
//        }
//        return element;
//    }

//    public void clickWhenReady(By locator, int timeout){
//        try {
//            WebElement element = null;
//            System.out.println("Waiting for max: " + timeout + "seconds for element to be clickable");
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//            element.click();
//            System.out.println("Element clicked on the Webpage");
//        } catch(Exception e) {
//            System.out.println("Element not appeared on the Webpage");
//        }
//    }



