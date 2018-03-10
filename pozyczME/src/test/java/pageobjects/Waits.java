package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private static final int time = 20;


    public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement waitForElement = wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement waitForElement = wait.until(ExpectedConditions.visibilityOf(element));
    }
}
