package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddRemovePage;
import utilities.BaseTest;
import utilities.Logs;

public class AddRemoveTest extends BaseTest {

    private final AddRemovePage addRemovePage = new AddRemovePage();
    @DataProvider(name = "number-of-clicks-data")
    public static Object[][] createData() {
        return new Object[][] {
                { 1 }, { 5 }, { 25 }
        };
    }

    @BeforeMethod
    public void setUp() {
        Logs.info("Navigating to the web page...");
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(priority = 1)
    public void verifyAddRemovePageTest() {
        addRemovePage.verifyPage();
    }

    @Test(priority = 2, dataProvider = "number-of-clicks-data")
    public void clickAddElementAndDeleteTest(int clicksCount) {
        addRemovePage.clickAddElement(clicksCount);
        addRemovePage.verifyDeleteButtons(clicksCount);
        addRemovePage.clickDeleteElement();
        addRemovePage.verifyDeleteButtons(0);
    }
}
