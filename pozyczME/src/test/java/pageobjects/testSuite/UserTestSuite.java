package pageobjects.testSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pageobjects.tests.FavoritesTest;
import pageobjects.tests.PlayerNumberTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlayerNumberTest.class,
        FavoritesTest.class
})

public class UserTestSuite {
}
