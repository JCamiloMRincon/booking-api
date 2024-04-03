package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.className("radius");
    private final By loginButtonContent = By.cssSelector("button > i");

    @Override
    public void verifyPage() {
        Logs.info("Verifying the login page...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(pageTitle).isDisplayed());
        softAssert.assertEquals(find(pageTitle).getText(), "Login Page");
        softAssert.assertTrue(find(pageDescription).isDisplayed());
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertEquals(find(loginButtonContent).getText().trim(), "Login");
        softAssert.assertTrue(find(loginButton).isEnabled());
        softAssert.assertAll();
    }

    public void writeCredentials(String username, String password) {
        Logs.info("Typing the username...");
        find(usernameInput).sendKeys(username);
        Logs.info("Typing the password...");
        find(passwordInput).sendKeys(password);
        Logs.info("Clicking the login button...");
        find(loginButton).click();
    }

    public void verifyLogoutMessage() {
        Logs.info("Verifying the logout message...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(flashMessage).isDisplayed());
        softAssert.assertTrue(find(flashMessage).getText().trim().contains("You logged out of the secure area!"));
        softAssert.assertAll();
    }

    public void verifyFailedLoginMessage() {
        Logs.info("Verifying the failed login message...");
        final var softAssert = new SoftAssert();
        softAssert.assertTrue(find(flashMessage).isDisplayed());
        softAssert.assertTrue(find(flashMessage).getText().trim().contains("Your username is invalid!"));
        softAssert.assertAll();
    }

}
