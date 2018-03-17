package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.BaseAccess;
import pageobjects.Waits;

public class MainPage extends BaseAccess{

    public MainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, MainPage.class);
        this.mywait = new Waits(driver);
    }
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
        mywait.waitForElementToBeVisible(leftNumberOfPlayersButton);
        return leftNumberOfPlayersButton;
    }
    public void leftNumberOfPlayersButtonClick(){
        mywait.waitForElementToBeClickable(getLeftNumberOfPlayersButton());
        leftNumberOfPlayersButton.click();
    }

    public WebElement getFindScrabbleGame() { return findScrabbleGame; }

    public WebElement getUndoButtonNumbersOfPlayers() {
        return undoButtonNumbersOfPlayers;
    }

    public void undoButtonNumbersOfPlayersClick(){
        mywait.waitForElementToBeClickable(getUndoButtonNumbersOfPlayers());
        undoButtonNumbersOfPlayers.click();
    }


    public WebElement getLogOutbutton() {
        mywait.waitForElementToBeVisible(getLogOutbutton());
        return logOutbutton;
    }


    public WebElement getMenuButtonOurGames() {
        return menuButtonOurGames;
    }

    public WebElement getMenuButtonMyProfile() {
        return menuButtonMyProfile;
    }


    public void clickOnOurGames() {
        mywait.waitForElementToBeClickable(getMenuButtonOurGames());
        menuButtonOurGames.click();
    }

    public void clickOnMyProfile() {
        mywait.waitForElementToBeClickable(getMenuButtonMyProfile());
        menuButtonMyProfile.click();
    }

    public void clickOnHeartbutton() {
        heartButton.click();
    }




}
