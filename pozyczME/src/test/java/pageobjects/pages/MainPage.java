package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = "//a[text()='Wyloguj'")
    private WebElement logOutbutton;

    public WebElement getLogOutbutton() {
        return logOutbutton;
    }

    public void clickOnLogOut (){
        logOutbutton.click();
    }
}
