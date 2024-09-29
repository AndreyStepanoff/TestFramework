package tests.PracticePageTests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class PracticeTest extends BaseTest {

    @Test
    public void openPracticepge(){
        practicePage.goToPracticePage();
    }

    @Test
    public void clickOnAlertBtnAndAccept() throws InterruptedException {
        practicePage.goToPracticePage().clickOnAlertButtonJS();
        Thread.sleep(2000);
        practicePage.acceptAlert();
    }

    @Test
    public void clickOnConfirmBtnAndAccept() throws InterruptedException {
        practicePage.goToPracticePage().clickOnConfirmButtonJS();
        Thread.sleep(2000);
        practicePage.dismissAlert();
    }
}
