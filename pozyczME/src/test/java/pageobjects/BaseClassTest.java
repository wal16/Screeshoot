package pageobjects;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.*;

public class BaseClassTest {

    protected WebDriver driver;
    private static final String URL = "http://app.pinapple.jdqz1.is-academy.pl/";
    protected Waits mywait;
    protected SignUpPage signUp;
    protected MainPage mainPage;
    protected SignInPage signIn;
    protected User user;

    protected void prepareDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    protected void initializeBasicPageFactory(){

        mywait = new Waits(driver);
        signIn = PageFactory.initElements(driver, SignInPage.class);
        signUp = PageFactory.initElements(driver, SignUpPage.class);
        mainPage = PageFactory.initElements(driver,MainPage.class);

    }

    protected void RegisterAndLogin(User user){

        mywait.waitForElementToBeVisible( signIn.getUsername());
        signUp.clickOnRegisterSide();
        mywait.waitForElementToBeClickable( signUp.getEmail());
        signUp.setUserData(user);
        signUp.clickOnRegister();
        signIn.clickOnLogSide();
        mywait.waitForElementToBeVisible( signIn.getUsername());
        signIn.setUserData(user);
        signIn.clickOnSignIn();
        mywait.waitForElementToBeVisible( mainPage.getLogOutbutton());
    }

    @After
    public void tearDown() { driver.close(); }


}
