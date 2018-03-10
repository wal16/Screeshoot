package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage {

    @FindBy(xpath = "//a[@href='game-profile/1']")
    private WebElement gameName;

    @FindBy(css = "p.alert-waiting")
    private WebElement alertName;

    public WebElement getGameName() {
        return gameName;
    }

    public WebElement getAlertName() {
        return alertName;
    }
}

