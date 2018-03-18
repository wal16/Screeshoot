package pageobjects.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.SignInPage;
import pageobjects.pages.SignUpPage;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class SignUpTest extends BaseClassTest{

    @DataProvider
    public static Object[] testDataforSignUp(){
        return new User[]{
                new User("aaaaa","12345", "aaa@wp.pl"),
                new User("12345","12345", "eeee@wp.pl"),
                new User("abc!","12345", "ppp@wp.pl"),
                new User("aabb","12345", "1234@wp.pl"),
                new User("1234567","12345", ""),
                new User("aavvx","123","qqqq@buziaczek.pl"),
        };
    }


    @Before
    public void setUp() {
        prepareDriver();
        initializeBasicPageFactoryWithWaits();
    }

    @Test
    @UseDataProvider("testDataforSignUp")
    public void checkSignUpWithGoodData(User user){

        RegisterAndLogin(user);
        mywait.waitForElementToBeClickable(mainPage.getLogOutbutton());
        assertTrue("I cant find WYLOGUJ button: ", mainPage.getLogOutbutton().getText().equals("Wyloguj"));
    }


}
