package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.BaseAccess;
import pageobjects.Waits;

public class MyProfilePage extends BaseAccess{

    public MyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, MyProfilePage.class);
        this.mywait = new Waits(driver);
    }

    @FindBy(xpath = "//a[@href='game-profile/1']")
    private WebElement gameName;

    @FindBy(css = "p.alert-waiting")
    private WebElement alertName;

    public WebElement getGameName() {
        mywait.waitForElementToBeVisible(getGameName());
        return gameName;
    }

    public WebElement getAlertName() {
        return alertName;
    }
}

