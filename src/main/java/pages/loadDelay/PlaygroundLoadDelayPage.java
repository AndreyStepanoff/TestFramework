package pages.loadDelay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class PlaygroundLoadDelayPage extends BasePage {
    public PlaygroundLoadDelayPage(WebDriver driver) {
        super(driver);
    }
    private final By buttonAppearAfterDelay = By.xpath("//button[text() = 'Button Appearing After Delay']");

    public WebElement waitForElementToAppear(){
        WebElement ButtonAppearAfterDelay = driver.findElement(buttonAppearAfterDelay);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonAppearAfterDelay = wait.until(ExpectedConditions.visibilityOf(ButtonAppearAfterDelay));
        return buttonAppearAfterDelay;
    }

}

