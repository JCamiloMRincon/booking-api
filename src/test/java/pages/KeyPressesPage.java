package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class KeyPressesPage extends BasePage {

    private final By keyPressesPageDescription = By.xpath("//p[contains(text(), 'Key presses are often')]");
    private final By targetInput = By.id("target");
    private final By resultInfo = By.id("result");

    @Override
    public void verifyPage() {
        Logs.info("Verifying the key presses page...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(pageTitle).isDisplayed());
        softAssert.assertEquals(find(pageTitle).getText(), "Key Presses");
        softAssert.assertTrue(find(keyPressesPageDescription).isDisplayed());
        softAssert.assertTrue(find(targetInput).isDisplayed());
        softAssert.assertAll();
    }

    public void typeKeys(Object keys) {
        find(targetInput).click();
        find(targetInput).sendKeys(keys.toString());
    }

    public void validatePressedKeysMessage() {
        Logs.info("Verifying that the message contains the key...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(resultInfo).isDisplayed());
        softAssert.assertEquals(find(resultInfo).getText(), "You entered: ALT");
        softAssert.assertAll();
    }
}
