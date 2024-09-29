package tests.input;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.URLs.PLAYGROUND_HOME_PAGE;

public class TextInputTest extends BaseTest {

    @DataProvider(name = "textData")
    public Object[] getData()
    {
        String[][] data={
                {"111111111111111111"},
                {"qwertyuiopasdfghjklzxcvbnmQWERTYUIOP"},
                {"!@#$%^&*()_+?><"}};
        return data;
    }

    @Test(dataProvider = "textData")
    public void checkTextOnButton(String text){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToTextInputPage();
        playgroundTextInputPage.enterText(text).clickOnUpdatingButton();
        Assert.assertEquals(text, playgroundTextInputPage.getTextFromButton());
    }
    @Test
    public void checkEmptyTextOnButton(){
        basePage.open(PLAYGROUND_HOME_PAGE);
        playgroundHomePage.goToTextInputPage();
        playgroundTextInputPage.enterText("").clickOnUpdatingButton();
        Assert.assertEquals("Button That Should Change it's Name Based on Input Value", playgroundTextInputPage.getTextFromButton());
    }
}
