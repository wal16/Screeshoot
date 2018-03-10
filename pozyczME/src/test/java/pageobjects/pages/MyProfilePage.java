package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage {

    @FindBy(xpath = "//a[@href='game-profile/1']")
    private WebElement gameName;

    public WebElement getGameName() {
        return gameName;
    }
}

