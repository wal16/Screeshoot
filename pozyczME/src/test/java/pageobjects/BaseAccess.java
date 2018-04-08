package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAccess {

    protected WebDriver driver;
    private static final String HOMEURL = "http://app.pinapple.jdqz1.is-academy.pl/";
    protected Waits mywait;
    private String buildEnv = System.getProperty("buildEnv");

    protected void prepareDriver(){

        if(buildEnv.equals("CI")){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), new DesiredCapabilities());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if(buildEnv.equals("DEV")){
            System.setProperty("webdriver.chrome.driver", "/home/waldemar/Pobrane/jdqz1-pinapple/pozyczME/src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }


        driver.get(getURL());
    }

    public static String getURL() {
        return HOMEURL;
    }
}
