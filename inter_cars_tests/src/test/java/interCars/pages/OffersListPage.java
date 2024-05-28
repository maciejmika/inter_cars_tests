package interCars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersListPage extends PageObject {

    @FindBy(xpath = "//a[contains(@data-toggle, 'dropdown')]")
    public WebElement sortDropdown;

    @FindBy(xpath = "//input[contains(@title, 'Dostępność: od największej')]/parent::label")
    public WebElement sortByHighestAvailabiltyOption;

    @FindBy(xpath = "//a[contains(@class, 'open-card')]")
    public WebElement firstOfferCard;

    public OffersListPage(WebDriver driver) {
        super(driver);
    }

    public void sortByHighestAvailability() {
        try {
            waitUntilElementIsClickable(sortDropdown).click();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            waitUntilElementIsClickable(sortDropdown).click();
        }

        waitUntilElementIsClickable(sortByHighestAvailabiltyOption).click();
    }

    public void selectFirstOffer() {
        try {
            waitUntilElementIsClickable(firstOfferCard).click();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            waitUntilElementIsClickable(firstOfferCard).click();
        }
    }
}