package pageobjects.testWatcher;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.fail;

public class TakeScreenshot {

    @Test

    public void testScreenShot() throws Exception {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/home/waldemar/Pobrane/Screeshoot/pozyczME/src/test/resources/chromedriver");
        driver = new ChromeDriver();

        //goto url

        driver.get("http://app.pinapple.jdqz1.is-academy.pl/");

        //Call take screenshot function

        this.takeSnapShot(driver, "/home/waldemar/Pobrane/test.png");

    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile = new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

    public static class WatchmanTest {
        private static String watchedLog;

        @Rule
        public TestWatcher watchman = new TestWatcher() {
            @Override
            protected void failed(Throwable e, Description description) {
                watchedLog += description + "\n";
            }

            @Override
            protected void succeeded(Description description) {
                watchedLog += description + " " + "success!\n";
            }
        };

        @Test
        public void fails() {
            fail();
        }

        @Test
        public void succeeds() {
        }
    }
}
