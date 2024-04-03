package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class SecureAreaPage extends BasePage {

    private final By logoutButton = By.cssSelector("a[href='/logout']");
    private final By logoutButtonContent = By.cssSelector("a[href='/logout'] > i");

    @Override
    public void verifyPage() {
        Logs.info("Verifying the secure area page...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(flashMessage).isDisplayed());
        softAssert.assertTrue(find(flashMessage).getText().trim().contains("You logged into a secure area!"));
        softAssert.assertTrue(find(pageTitle).isDisplayed());
        softAssert.assertEquals(find(pageTitle).getText().trim(), "Secure Area");
        softAssert.assertTrue(find(pageDescription).isDisplayed());
        softAssert.assertEquals(find(pageDescription).getText(), "Welcome to the Secure Area. When you are done click logout below.");
        softAssert.assertTrue(find(logoutButton).isDisplayed());
        softAssert.assertEquals(find(logoutButtonContent).getText().trim(), "Logout");
        softAssert.assertAll();
    }

    public void logout() {
        Logs.info("Clicking the logout button...");
        find(logoutButton).click();
    }
}
