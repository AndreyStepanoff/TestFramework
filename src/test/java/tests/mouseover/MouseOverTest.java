package tests.mouseover;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;

public class MouseOverTest extends BaseTest {


    @Test()
    public void checkNumberOfClicks(){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToMouseOverPage();
        int numberOfClicks = 6;
        playgroundMouseOverPage.clickOnClickMe(numberOfClicks);
        System.out.println(playgroundMouseOverPage.countClicks());
        Assert.assertEquals(playgroundMouseOverPage.countClicks(), String.valueOf(numberOfClicks));
    }
}
