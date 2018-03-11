package pageobjects.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.SignInPage;
import pageobjects.pages.SignUpPage;


import static org.junit.Assert.assertTrue;

public class PlayerNumberTest extends BaseClassTest{

    private SignUpPage signUp;
    private MainPage mainPage;
    private SignInPage signIn;

    @Before
    public void setUp() {
        prepareDriver();
        driver.manage().window().maximize();
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
    public void testClickOnTheLeftNumbersOfPlayers() {

        WebElement leftNumberOfPlayersButton = driver.findElement(By.xpath("//html//span[1]/span[1]/span[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(leftNumberOfPlayersButton));
        //też działa ale zostawiłam click() - bo łatwiejszy
        //mainPage.dragAndDrop2(driver, leftNumberOfPlayersButton, 100, 0);
        leftNumberOfPlayersButton.click();
        leftNumberOfPlayersButton.click();
        assertTrue("Udało się przesunąć dolny przycisk limitu graczy", leftNumberOfPlayersButton.getText().contains("4"));

    }

    @Test
    public void testClickOnTheUndoNumbersOfPlayers() {

        mywait.waitForElementToBeClickable(driver, mainPage.getLeftNumberOfPlayersButton());
        mainPage.leftNumberOfPlayersButtonClick();
        mywait.waitForElementToBeClickable(driver, mainPage.getUndoButtonNumbersOfPlayers());
        mainPage.undoButtonNumbersOfPlayersClick();
        assertTrue("Udało się przywrócić początkowe ustawienia limitu graczy", mainPage.getLeftNumberOfPlayersButton().getText().contains("2"));

    }


    @After
    public void tearDown() { closeDriver(); }
}
