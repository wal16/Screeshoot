package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassTest {

    protected WebDriver driver;
    private static final String URL = "http://app.pinapple.jdqz1.is-academy.pl/";
    protected Waits mywait;
    protected User user;

    protected void prepareDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    protected void closeDriver(){
        driver.close();
    }



}
