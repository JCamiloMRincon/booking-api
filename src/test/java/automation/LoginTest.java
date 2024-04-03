package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @BeforeMethod
    public void setUp() {
        Logs.info("Navigating to the web page...");
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    @Test
    public void successfulLoginTest() {
        loginPage.writeCredentials("tomsmith", "SuperSecretPassword!");
        secureAreaPage.verifyPage();
        secureAreaPage.logout();
        loginPage.verifyLogoutMessage();
    }

    @Test
    public void failLoginTest() {
        loginPage.writeCredentials("camilo", "NotASecretPassword");
        loginPage.verifyFailedLoginMessage();
    }
}
