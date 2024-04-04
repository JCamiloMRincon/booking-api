package automation;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KeyPressesPage;
import utilities.BaseTest;
import utilities.Logs;

public class KeyPressesTest extends BaseTest {

    private final KeyPressesPage keyPressesPage = new KeyPressesPage();

    @BeforeMethod
    public void setUp() {
        Logs.info("Navigating to the web page...");
        driver.get("https://the-internet.herokuapp.com/key_presses");
    }

    @Test(priority = 1)
    public void verifyKeyPressesPageTest() {
        keyPressesPage.verifyPage();
    }

    @Test(priority = 2)
    public void typeKeysTest() {
        keyPressesPage.typeKeys(Keys.ALT);
        keyPressesPage.validatePressedKeysMessage();
    }
}
