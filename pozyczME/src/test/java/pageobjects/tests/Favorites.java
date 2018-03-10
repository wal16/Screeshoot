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


public class Favorites extends BaseClassTest {

    private SignInPage signIn;
    private SignUpPage signUp;
    private MainPage mainPage;
    private MyProfilePage myProfilePage;

    @Before
    public void setUp() {

        prepareDriver();
        signIn = PageFactory.initElements(driver, SignInPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        signUp = PageFactory.initElements(driver, SignUpPage.class);
        myProfilePage = PageFactory.initElements(driver, MyProfilePage.class);
        mywait = new Waits();
        user = new User("aaaaa", "12345", "www@wp.pl");

        mywait.waitForElementToBeVisible(driver, signIn.getUsername());
        signUp.clickOnRegisterSide();
        mywait.waitForElementToBeClickable(driver, signUp.getEmail());
        signUp.setUserData(user);
        signUp.clickOnRegister();
        signIn.clickOnLogSide();
        mywait.waitForElementToBeVisible(driver, signIn.getUsername());
        signIn.setUserData(user);
        signIn.clickOnSignIn();
        mywait.waitForElementToBeVisible(driver, mainPage.getLogOutbutton());

    }

    @Test
    public void addToFavorites() {

        mywait.waitForElementToBeClickable(driver, mainPage.getMenuButtonOurGames());
        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable(driver, mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        mywait.waitForElementToBeVisible(driver, myProfilePage.getGameName());
        System.out.println(myProfilePage.getGameName().getText());
        assertTrue(myProfilePage.getGameName().getText().length() > 0);
    }

    @Test
    public void removeFromFavorites(){

        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable(driver, mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        mywait.waitForElementToBeClickable(driver, myProfilePage.getGameName());
        assertTrue("Game was not removed from favorites", myProfilePage.getGameName().getText().equals("Scrabble"));
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
