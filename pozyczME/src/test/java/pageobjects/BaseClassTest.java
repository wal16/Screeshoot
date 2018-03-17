package pageobjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.*;

public class BaseClassTest extends BaseAccess{

    protected SignUpPage signUp;
    protected MainPage mainPage;
    protected SignInPage signIn;
    protected User user;

    public void prepareEnvForTests(){

        prepareDriver();
        initializeBasicPageFactoryWithWaits();
        RegisterAndLogin(new User("aaaaa", "12345", "www@wp.pl"));
    }

    protected void initializeBasicPageFactoryWithWaits(){
        mywait = new Waits(driver);
        signIn = new SignInPage(driver);
        signUp = new SignUpPage(driver);
        mainPage = new MainPage(driver);

    }

    protected void RegisterAndLogin(User user){

        mywait.waitForElementToBeVisible( signIn.getUsername());
        signUp.clickOnRegisterSide();
        signUp.setUserData(user);
        signUp.clickOnRegister();
        signIn.clickOnLogSide();
        mywait.waitForElementToBeVisible( signIn.getUsername());
        signIn.setUserData(user);
        signIn.clickOnSignIn();
    }

    @After
    public void tearDown() { driver.close(); }


}
