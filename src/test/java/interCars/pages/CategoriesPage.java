package interCars.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends PageObject {

    @FindBy(xpath = "//a[contains(@title, 'Opony / Felgi / Akcesoria')]")
    public WebElement WheelsTyresCategory;


    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void selectWheelsTyresCategory() {
        waitUntilElementIsClickable(WheelsTyresCategory).click();
    }

}