package pageobjects.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.SearchForPage;
import pageobjects.pages.SignInPage;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.SignUpPage;
import static org.junit.Assert.assertTrue;

public class SearchFor extends BaseClassTest{

    private SearchForPage searchForPage;
    private SignUpPage signUp;
    private MainPage mainPage;
    private SignInPage signIn;


    @Before
    public void setUp() {

        prepareDriver();
        driver.manage().window().maximize();
        searchForPage = PageFactory.initElements(driver, SearchForPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        signIn = PageFactory.initElements(driver, SignInPage.class);
        signUp = PageFactory.initElements(driver, SignUpPage.class);
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
    public void addLettersSearchbb() {

        searchForPage.clickOnOurGamesbutton();
        searchForPage.setSearchField("bb");
        assertTrue("SearchField is not displayed", searchForPage.isSearchFieldVisible());
    }

    @Test
    public void addLettersSearchsc() {

        searchForPage.clickOnOurGamesbutton();
        searchForPage.setSearchField("sc");
        assertTrue("OurGamesbutton is not displayed", searchForPage.isOurGamesbuttonVisible());
    }
    @Test
    public void addSearchWordScrrable() {

        searchForPage.clickOnOurGamesbutton();
        searchForPage.setSearchField("Scrabble");
        assertTrue("SearchField is not displayed", searchForPage.isSearchFieldVisible());
    }

    @After

    public void tearDown() {
        closeDriver();
    }
}
