package pageobjects.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BaseAccess;
import pageobjects.User;

public class SignInPage extends BaseAccess{


    @FindBy(linkText = "Logowanie")
    private WebElement logSide;

    @FindBy(xpath = "//div[@id='tab-pane-1']//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//div[@id='tab-pane-1']//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Zaloguj']")
    private WebElement logInbutton;

    public WebElement getAlert() {
        return alert;
    }

    @FindBy (css = "div.alert")
    private WebElement alert;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getLogSide() {
        return logSide;
    }

    public void clickOnLogSide(){
        logSide.click();
    }

    public void setUserData(User user){
        username.sendKeys(user.getName());
        password.sendKeys(user.getPass());
    }

    public void clickOnSignIn() {
        logInbutton.click();
    }

    public boolean showAlert() {
        return alert.isDisplayed();}
}
