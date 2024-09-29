package pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {super(driver);}

    private final By clickMeBtn = By.xpath("//button[contains(text(), 'Click Me ')]");
   // WebElement clickMeButton = (WebElement) clickMeBtn;


    public FramesPage goToFrPage(){
        open(PLAYGROUND_HOME_PAGE);
        return this;
    }

    public FramesPage switchToFrame(int frameNumber){
        driver.switchTo().frame("frame" +frameNumber);
        System.out.println("switched to frame "+ frameNumber);
        return this;
    }

    public FramesPage clickOnButton(){
        WebElement ClickMeButton = driver.findElement(clickMeBtn);
        ClickMeButton.click();
        System.out.println("Button clicked");
        return this;
    }

    public static List<WebElement> clickableLinks(WebElement driver){
        List<WebElement> linksToClick = new ArrayList<WebElement>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement e : elements){
            if (e.getAttribute("href") != null){
                linksToClick.add(e);
            }
        }
        return linksToClick;
    }

    public static String linkStatus(URL url){
        try {
            HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
            http.connect();
            String responceMessage = http.getResponseMessage();
            http.disconnect();
            return responceMessage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public FramesPage findlinks() throws MalformedURLException {
        List<WebElement> linksList = clickableLinks((WebElement) driver);
        for (WebElement link : linksList){
            String href = link.getAttribute("href");
            URL url;
            url = new URL(href);
            System.out.println("URL " + href + linkStatus(url));
        }
        return this;
    }


}
