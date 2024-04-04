package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class AddRemovePage extends BasePage {

    private final By addRemovePageTitle = By.tagName("h3");
    private final By buttonAddElement = By.xpath("//button[text()='Add Element']");
    private final By buttonDelete = By.xpath("//button[text()='Delete']");

    @Override
    public void verifyPage() {
        Logs.info("Verifying the add/remove page...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(addRemovePageTitle).isDisplayed());
        softAssert.assertEquals(find(addRemovePageTitle).getText(), "Add/Remove Elements");
        softAssert.assertTrue(find(buttonAddElement).isDisplayed());
        softAssert.assertEquals(find(buttonAddElement).getText(), "Add Element");
        softAssert.assertTrue(find(buttonAddElement).isEnabled());
        softAssert.assertAll();
    }

    public void clickAddElement(int numberOfClicks) {
        for (int i = 0; i < numberOfClicks; i++) {
            Logs.info("Clicking the add element button... Click number " + (i + 1));
            find(buttonAddElement).click();
        }
    }

    public void verifyDeleteButtons(int numberOfButtons) {
       Logs.info("Verifying there are " + numberOfButtons + " delete buttons...");
       Assert.assertEquals(findAll(buttonDelete).size(), numberOfButtons);
    }

    public void clickDeleteElement() {
        int iteration = 1;
        var buttonDeleteList = findAll(buttonDelete);
        for(var button : buttonDeleteList) {
            Logs.info("Deleting the button number " + iteration + "...");
            button.click();
            iteration++;
        }
    }
}
