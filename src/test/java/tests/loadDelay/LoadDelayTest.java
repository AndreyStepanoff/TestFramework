package tests.loadDelay;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;

public class LoadDelayTest extends BaseTest {


    @Test
    public void checkLoadDelay(){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToLoadDelayPage();
        Assert.assertTrue(playgroundLoadDelayPage.waitForElementToAppear().isDisplayed());

    }

}
