package pageobjects.tests;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.SearchForPage;
import pageobjects.pages.SignInPage;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.SignUpPage;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SearchForTest extends BaseClassTest {

    private SearchForPage searchForPage;

    @Before
    public void setUp() {

        prepareDriver();
        initializeBasicPageFactoryWithWaits();
        searchForPage = PageFactory.initElements(driver, SearchForPage.class);
        RegisterAndLogin(new User("aaaaa", "12345", "www@wp.pl"));

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

    @Rule
    public SearchForTest watchman = new SearchForTest();
}
