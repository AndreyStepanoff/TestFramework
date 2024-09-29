package pages.mouseover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class PlaygroundMouseOverPage extends BasePage {
    public PlaygroundMouseOverPage(WebDriver driver) {
        super(driver);
    }

    private final By clickme = By.xpath("//a[text()='Click me']");
    private final By countClicks = By.xpath("//span[@id='clickCount']");

    public PlaygroundMouseOverPage clickOnClickMe(int numberOfClicks) {
        for (int i=0; i < numberOfClicks; i++) {
            WebElement ClickmeLink = driver.findElement(clickme);
            ClickmeLink.click();
        }
        return this;
    }

    public String countClicks(){
        WebElement CountClicks = driver.findElement(countClicks);
        return CountClicks.getText();
    }
}
