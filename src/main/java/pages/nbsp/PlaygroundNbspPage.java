package pages.nbsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class PlaygroundNbspPage extends BasePage {
    public PlaygroundNbspPage(WebDriver driver) {
        super(driver);
    }
    private final By MyButton = By.xpath("//button[@class='btn btn-primary']");

    public String checkTheButton(){
        WebElement My_Button = driver.findElement(MyButton);
        return My_Button.getText();
    }
}
