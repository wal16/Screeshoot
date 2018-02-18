package pageobjects.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(css = "a#tab-tab-1")
    private WebElement logSide;

    @FindBy(css = "#tab-pane-1 input#username.form-control")
    private WebElement username;

    @FindBy(css = "#tab-pane-1 input#password.form-control")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Zaloguj']")
    private WebElement logInbutton;

    @FindBy(xpath = "//a[text()='Wyloguj'")
    private WebElement logOutbutton;

    public void clickOnLogSide(){
        logSide.click();
    }

    public void setUserData(String name, String pass){
        username.sendKeys(name);
        password.sendKeys(pass);
    }
    public void clickOnSignIn() {logInbutton.click();}

}
