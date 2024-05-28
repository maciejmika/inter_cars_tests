package interCars.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToBasketPopUp extends PageObject {

    @FindBy(xpath = "//button[contains(@class, 'add_to_cart2_ok_full_card')]")
    public WebElement goToBasketButton;

    public AddedToBasketPopUp(WebDriver driver) {
        super(driver);
    }


}