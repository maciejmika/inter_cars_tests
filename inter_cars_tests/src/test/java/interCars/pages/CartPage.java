package interCars.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {

    @FindBy(xpath = "//span[contains(@class, 'opis-tow')]")
    public WebElement productDescription;

    @FindBy(xpath = "//div[contains(@class, 'trashButton')]")
    public WebElement trashButton;

    @FindBy(xpath = "//div[contains(@class, 'swal2-container in')]//button[contains(text(), 'OK')]")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[contains(text(), 'Koszyk jest pusty')]")
    public WebElement emptyCartMessage;


    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void verifyCartIsEmpty() {
        waitUntilElementIsClickable(confirmDeleteButton).click();
        waitUntilVisibilityOfElement(emptyCartMessage);
    }

}