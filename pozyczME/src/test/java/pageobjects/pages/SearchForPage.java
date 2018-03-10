package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchForPage {


    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//a[text()='Nasze gry']")
    private WebElement ourGamesbutton;

    public void setSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void clickOnOurGamesbutton() {
        ourGamesbutton.click();
    }

    public boolean isSearchFieldVisible() {

        return searchField.isDisplayed();
    }

    public boolean isOurGamesbuttonVisible()
    {
        return ourGamesbutton.isDisplayed();
    }
}
