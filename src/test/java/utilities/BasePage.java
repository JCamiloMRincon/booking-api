package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {

    protected final By flashMessage = By.id("flash");
    protected final By pageTitle = By.tagName("h2");
    protected final By pageDescription = By.className("subheader");

    protected WebElement find(By locator) {
        return new WebDriverProvider().get().findElement(locator);
    }
    protected List<WebElement> findAll(By locator) {
        return new WebDriverProvider().get().findElements(locator);
    }
    public abstract void verifyPage();

}
