package pageobjects.tests;

import org.junit.Before;
import org.junit.Test;
import pageobjects.BaseClassTest;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerNumberTest extends BaseClassTest{

    @Before
    public void setUp(){
        prepareEnvForTests();
    }

    @Test
    public void testClickOnTheLeftNumbersOfPlayers() {

        mywait.waitForElementToBeVisible(mainPage.getLeftNumberOfPlayersButton());
        mainPage.getLeftNumberOfPlayersButton().click();
        assertTrue("Udało się przesunąć dolny przycisk limitu graczy", mainPage.getLeftNumberOfPlayersButton().getText().contains("3"));

    }

    @Test
    public void testClickOnTheLeftNumbersOfPlayersAndNotFindScrabbleGame() {

      mywait.waitForElementToBeClickable(mainPage.getLeftNumberOfPlayersButton());
      mainPage.getLeftNumberOfPlayersButton().click();

        assertFalse("Udało się przesunąć dolny przycisk limitu graczy tak, że nie znajduje gry Scrabble", mainPage.getFindScrabbleGame().getText().contains("Scrabble"));

    }

    @Test
    public void testClickOnTheUndoNumbersOfPlayers() {

        mywait.waitForElementToBeClickable(mainPage.getLeftNumberOfPlayersButton());
        mainPage.leftNumberOfPlayersButtonClick();
        mywait.waitForElementToBeClickable(mainPage.getUndoButtonNumbersOfPlayers());
        mainPage.undoButtonNumbersOfPlayersClick();
        assertTrue("Udało się przywrócić początkowe ustawienia limitu graczy", mainPage.getLeftNumberOfPlayersButton().getText().contains("2"));

    }


}
