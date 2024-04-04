package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddRemovePage;
import utilities.BaseTest;
import utilities.Logs;

public class AddRemoveTest extends BaseTest {

    private final AddRemovePage addRemovePage = new AddRemovePage();

    @BeforeMethod
    public void setUp() {
        Logs.info("Navigating to the web page...");
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(priority = 1)
    public void verifyAddRemovePageTest() {
        addRemovePage.verifyPage();
    }

    @Test(priority = 2)
    public void clickAddElementAndDeleteTest() {
        addRemovePage.clickAddElement(25);
        addRemovePage.verifyDeleteButtons(25);
        addRemovePage.clickDeleteElement();
        addRemovePage.verifyDeleteButtons(0);
    }
}
