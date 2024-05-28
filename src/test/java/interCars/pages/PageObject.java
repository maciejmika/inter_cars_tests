package interCars.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PageObject {

    public static final int TIMEOUT_IN_MILLIS = 60000;
    public static final int POOLING_TIME_IN_MILLIS = 100;

    @FindBy(id = "bhr-items")
    public WebElement specialOffersPopUp;

    @FindBy(xpath = "//button[text()='Zaakceptuj wszystkie']")
    public WebElement acceptAllCookiesButton;

    public WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        waitUntilElementIsClickable(acceptAllCookiesButton).click();
    }

    public <T> T waitUntilConditionMeet(ExpectedCondition<T> condition) {
        return waitUntilConditionMeet(condition, TIMEOUT_IN_MILLIS);
    }

    public <T> T waitUntilConditionMeet(ExpectedCondition<T> condition, int timeoutInMillis) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofMillis(timeoutInMillis))
            .pollingEvery(Duration.ofMillis(POOLING_TIME_IN_MILLIS))
            .ignoring(NoSuchElementException.class)
            .until(condition);
    }

    public <T> T waitUntilConditionMeetIgnoreStale(ExpectedCondition<T> condition, int timeoutInMillis) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofMillis(timeoutInMillis))
            .pollingEvery(Duration.ofMillis(POOLING_TIME_IN_MILLIS))
            .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
            .until(condition);
    }

    public WebElement waitUntilVisibilityOfElement(WebElement element) {
        return waitUntilConditionMeet(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementIsClickable(WebElement element) {
        return waitUntilConditionMeet(ExpectedConditions.elementToBeClickable(element));
    }
}
