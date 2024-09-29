package tests.frames;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.base.BasePage;
import tests.base.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;
import static pages.frames.FramesPage.clickableLinks;
import static pages.frames.FramesPage.linkStatus;

public class FramesTest extends BaseTest {

    @Test
    public void switchFrameTest(){
        framesPage.goToFrPage()
                .switchToFrame(1)
                .switchToFrame(3)
                .switchToFrame(4)
                .clickOnButton();
    }
    @Test
    public void checkAllLinks() throws MalformedURLException {
        framesPage.goToFrPage();



        List<WebElement> linksList = clickableLinks((WebElement) driver);
        for (WebElement link : linksList){
            String href = link.getAttribute("href");
            URL url;
            url = new URL(href);
            System.out.println("URL " + href + linkStatus(url));
        }


//        framesPage.findlinks();
    }


}
