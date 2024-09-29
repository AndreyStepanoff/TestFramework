package pages.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class PracticePage extends BasePage {
    public PracticePage(WebDriver driver){
        super(driver);
    }

    private final By AlertBtn = By.xpath("//input[@id='alertbtn']");
    private final By ConfirmBtn = By.xpath("//input[@id='confirmbtn']");
    public PracticePage goToPracticePage(){
        driver.get("https://www.letskodeit.com/practice");
        return this;
    }

    public PracticePage clickOnAlertButtonJS(){
        WebElement AlertButton = driver.findElement((By) AlertBtn);
        AlertButton.click();
        return this;
    }

    public PracticePage clickOnConfirmButtonJS(){
        WebElement AlertButton = driver.findElement((By) ConfirmBtn);
        AlertButton.click();
        return this;
    }

    public PracticePage acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
    public PracticePage dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return this;
    }


}
