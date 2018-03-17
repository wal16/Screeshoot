package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseAccess {

    protected WebDriver driver;
    private static final String URL = "http://app.pinapple.jdqz1.is-academy.pl/";
    protected Waits mywait;

    protected void prepareDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(getURL());
    }

    public static String getURL() {
        return URL;
    }
}
