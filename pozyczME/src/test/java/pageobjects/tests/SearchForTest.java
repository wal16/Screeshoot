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

public class SearchForTest extends BaseClassTest{

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

}
