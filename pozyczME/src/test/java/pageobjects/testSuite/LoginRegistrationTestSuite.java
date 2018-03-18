package pageobjects.testSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pageobjects.tests.SignInTest;
import pageobjects.tests.SignUpTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SignInTest.class,
        SignUpTest.class
})

public class LoginRegistrationTestSuite {
}
