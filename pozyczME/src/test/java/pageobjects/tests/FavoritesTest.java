package pageobjects.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.MyProfilePage;
import pageobjects.pages.SignInPage;
import pageobjects.pages.SignUpPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class FavoritesTest extends BaseClassTest {

    private MyProfilePage myProfilePage;

    @Before
    public void setUp() {
        prepareEnvForTests();
        myProfilePage = PageFactory.initElements(driver, MyProfilePage.class);
    }

    @Test
    public void addToFavorites() {

        mywait.waitForElementToBeClickable( mainPage.getMenuButtonOurGames());
        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable( mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        mywait.waitForElementToBeVisible( myProfilePage.getGameName());
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
