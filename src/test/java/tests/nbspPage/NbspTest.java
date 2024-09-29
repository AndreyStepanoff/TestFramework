package tests.nbspPage;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;

public class NbspTest extends BaseTest {
    @Test
    public void checkButtonText(){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToNbspPage();
        System.out.println(playgroundNbspPage.checkTheButton());

    }
}
