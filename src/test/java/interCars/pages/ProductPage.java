package interCars.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {

    @FindBy(id = "fcCounter")
    public WebElement itemsCountInput;

    @FindBy(xpath = "//button[contains(@class, 'cart-add-confirm')]")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//span[contains(@class, 'indexValue')]")
    public WebElement productIndex;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void provideItemsCount(String itemsCount) {
        waitUntilElementIsClickable(itemsCountInput).sendKeys(Keys.BACK_SPACE + itemsCount);
    }
}