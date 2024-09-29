package pages.realt_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class PlaygroundHomePage extends BasePage {
    public PlaygroundHomePage(WebDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//*[text() = 'UI Test Automation']");
    private final By SamplaApploginPage = By.xpath("//a[text() = 'Sample App']");
    private final By TextInputPage = By.xpath("//a[text() = 'Text Input']");
    private final By LoadDelayPage = By.xpath("//a[text() = 'Load Delay']");
    private final By ScrollBarPage = By.xpath("//a[text() = 'Scrollbars']");
    private final By NbspPage = By.xpath("//a[text() = 'Non-Breaking Space']");
    private final By MouseOverPage = By.xpath("//a[text() = 'Mouse Over']");



    @FindBy(xpath = "//a[@href = 'expected_conditions.html']")
    private WebElement Wait_Conditions;

    public String checkUserOnPlaygroundPage(){
        WebElement Playgrountitle = driver.findElement((By) title);
        return Playgrountitle.getText();
    }
    public PlaygroundHomePage goToLoginPage(){
        WebElement SampleAppLoginLink = driver.findElement(SamplaApploginPage);
        SampleAppLoginLink.click();
        return this;
    }
    public PlaygroundHomePage goToTextInputPage(){
        WebElement Text_InputPage = driver.findElement(TextInputPage);
        Text_InputPage.click();
        return this;
    }
    public PlaygroundHomePage goToLoadDelayPage(){
        WebElement Load_DelayPage = driver.findElement(LoadDelayPage);
        Load_DelayPage.click();
        return this;
    }
    public PlaygroundHomePage goToScrollBarsPage(){
        WebElement Scroll_BarPage = driver.findElement(ScrollBarPage);
        Scroll_BarPage.click();
        return this;
    }

    public PlaygroundHomePage goToNbspPage(){
        WebElement NBspPage = driver.findElement(NbspPage);
        NBspPage.click();
        return this;
    }

    public PlaygroundHomePage goToMouseOverPage(){
        WebElement Mouseover = driver.findElement(MouseOverPage);
        Mouseover.click();
        return this;
    }
}
