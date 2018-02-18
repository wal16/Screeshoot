package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private WebDriver driver;
    private static final int time = 20;

    public void waitForTime(WebDriver driver, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
    }

    public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement waitForElement = wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
