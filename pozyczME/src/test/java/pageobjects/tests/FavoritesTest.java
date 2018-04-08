package pageobjects.tests;


import org.junit.Before;
import org.junit.Test;

import pageobjects.BaseClassTest;

import pageobjects.pages.MyProfilePage;


import static org.junit.Assert.*;


public class FavoritesTest extends BaseClassTest {

    private MyProfilePage myProfilePage;

    @Before
    public void setUp() {
        prepareEnvForTests();
        myProfilePage = new MyProfilePage(driver);
    }

    @Test
    public void addToFavorites() {

        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable(mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        assertTrue(myProfilePage.getGameName().getText().length() > 0);
    }

    @Test
    public void removeFromFavorites(){

        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable( mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        mywait.waitForElementToBeClickable( myProfilePage.getAlertName());
        assertTrue("Game was not removed from favorites", myProfilePage.getAlertName().getText().contains("Nie masz"));
    }

}
