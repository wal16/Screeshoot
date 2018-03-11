package pageobjects.tests;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.pages.MainPage;
import pageobjects.Waits;
import pageobjects.pages.SignInPage;
import static org.junit.Assert.assertTrue;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "src/test/resources/logIn.xml" }, loaderType = LoaderType.XML, writeData = false)
public class SignInTest extends BaseClassTest{

    @Before
    public void setUp() {

        prepareDriver();
        initializeBasicPageFactory();

    }

    @Test
    public void testLoginWithWrongData(@Param(name = "name") String name,
                                       @Param(name = "pass") String pass){
        user = new User(name, pass, "");
        signIn.clickOnLogSide();
        signIn.setUserData(user);
        signIn.clickOnSignIn();
        mywait.waitForElementToBeVisible(signIn.getAlert());
        assertTrue("Alert isn't displayed", signIn.showAlert());
    }


}
