package pageobjects.tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.MainPage;
import pageobjects.Waits;
import pageobjects.pages.SignInPage;

public class SignIn {

    private static final String URL = "http://app.pinapple.jdqz1.is-academy.pl/";

    private WebDriver driver;

    private SignInPage sign;
    private MainPage mainPage;
    private Waits wait = new Waits();

    @Before
    public void setUp() {

        sign = PageFactory.initElements(driver, SignInPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);

    }

    @Test
    public void testLoginWithGoodData() {

        sign.clickOnLogSide();
        sign.setUserData("aaaaa", "12345");
        sign.clickOnSignIn();



        assertTrue(mainPage.getLogOutbutton().getText().equals("Wyloguj"));
    }



//    @After
//    public void tearDown() { driver.close(); }

}
