package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BaseAccess;

public class MainPage extends BaseAccess{

    @FindBy(linkText = "Wyloguj")
    private WebElement logOutbutton;

    @FindBy(xpath = "//a[text()='Nasze gry']")
    private WebElement menuButtonOurGames;

    @FindBy(xpath = "//a[text()='Mój profil']")
    private WebElement menuButtonMyProfile;

    @FindBy(xpath = "//tr[1]/td[4]/button[1]/span")
    private WebElement heartButton;

    @FindBy(xpath = "//html//span[1]/span[1]/span[1]")
    private WebElement leftNumberOfPlayersButton;

    @FindBy(xpath = "//span[@class='glyph glyphicon glyphicon-repeat']")
    private WebElement undoButtonNumbersOfPlayers;

    @FindBy(xpath = "//tbody[@class='table-body__game-list']")
    private WebElement findScrabbleGame;

    public WebElement getLeftNumberOfPlayersButton() {
        return leftNumberOfPlayersButton;
    }
    public void leftNumberOfPlayersButtonClick(){
        leftNumberOfPlayersButton.click();
    }

    public WebElement getFindScrabbleGame() { return findScrabbleGame; }

    public WebElement getUndoButtonNumbersOfPlayers() {
        return undoButtonNumbersOfPlayers;
    }

    public void undoButtonNumbersOfPlayersClick(){
        undoButtonNumbersOfPlayers.click();
    }

    public WebElement getLogOutbutton() {
        return logOutbutton;
    }


    public WebElement getMenuButtonOurGames() {
        return menuButtonOurGames;
    }

    public WebElement getMenuButtonMyProfile() {
        return menuButtonMyProfile;
    }


    public void clickOnOurGames() {
        menuButtonOurGames.click();
    }

    public void clickOnMyProfile() {
        menuButtonMyProfile.click();
    }

    public void clickOnHeartbutton() {
        heartButton.click();
    }




}
