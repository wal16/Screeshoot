package pageobjects.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.SignInPage;
import pageobjects.pages.SignUpPage;


import static org.junit.Assert.assertTrue;

public class PlayerNumberTest extends BaseClassTest{

    @Before
    public void setUp(){
        prepareEnvForTests();
    }

    @Test
    public void testClickOnTheLeftNumbersOfPlayers() {

        mywait.waitForElementToBeClickable(mainPage.getLeftNumberOfPlayersButton());
        mainPage.getLeftNumberOfPlayersButton().click();
        assertTrue("Udało się przesunąć dolny przycisk limitu graczy", mainPage.getLeftNumberOfPlayersButton().getText().contains("3"));

    }

    @Test
    public void testClickOnTheUndoNumbersOfPlayers() {

        mywait.waitForElementToBeClickable( mainPage.getLeftNumberOfPlayersButton());
        mainPage.leftNumberOfPlayersButtonClick();
        mywait.waitForElementToBeClickable( mainPage.getUndoButtonNumbersOfPlayers());
        mainPage.undoButtonNumbersOfPlayersClick();
        assertTrue("Udało się przywrócić początkowe ustawienia limitu graczy", mainPage.getLeftNumberOfPlayersButton().getText().contains("2"));

    }


}
