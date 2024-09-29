package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class PlaygroundTextInputPage extends BasePage {
    public PlaygroundTextInputPage(WebDriver driver) {
        super(driver);
    }

    private final By textInput = By.xpath("//input[@id = 'newButtonName']");
    private final By updatedButton = By.xpath("//button[@id='updatingButton']");

    public PlaygroundTextInputPage enterText(String text){
        WebElement Textinput = driver.findElement(textInput);
        Textinput.sendKeys(text);
        return this;
    }
    public PlaygroundTextInputPage clickOnUpdatingButton(){
        WebElement UpdatedButton = driver.findElement(updatedButton);
        UpdatedButton.click();
        return this;
    }
    public String getTextFromButton(){
        WebElement UpdatedButton = driver.findElement(updatedButton);
        System.out.println(UpdatedButton.getText());
        return UpdatedButton.getText();
    }

}
