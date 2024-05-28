package interCars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCarView extends MainPage {


    @FindBy(xpath = "//button[contains(@class, 'select-vehicle')]")
    public WebElement selectCarButton;
    @FindBy(xpath = "//input[contains(@class, 'select2-search__field')]")
    public WebElement dropdownInput;
    @FindBy(id = "select-vehicle")
    private WebElement selectCarView;
    @FindBy(id = "select2-ExpandableMake-container")
    private WebElement selectMakeDropdownButton;


    public SelectCarView(WebDriver driver) {
        super(driver);
    }

    public void selectTheCar(String make, String model, String engine) {
        waitUntilElementIsClickable(selectCarButton).click();
        waitUntilVisibilityOfElement(selectCarView);

        //make
        waitUntilElementIsClickable(selectMakeDropdownButton).click();
        waitUntilElementIsClickable(dropdownInput).sendKeys(make);
        waitUntilElementIsClickable(driver.findElement(By.xpath(
            "//ul[contains(@class, 'select2-results__options--nested')]/li[text()='" + make.toUpperCase()
                + "']"))).click();
        // add count to check if there are more than one results fitting

        //model
        model = model.split("\\)")[0];
        waitUntilElementIsClickable(dropdownInput).sendKeys(model);
        waitUntilElementIsClickable(driver.findElement(By.xpath(
            "//ul[contains(@class, 'select2-results__options')]//div[contains(text(), '" + model + "')]"))).click();
        // add count to check if there are more than one results fitting

        //engine
        engine = engine.split("\\(")[0].trim();
        waitUntilElementIsClickable(dropdownInput).sendKeys(engine);
        waitUntilElementIsClickable(driver.findElement(By.xpath(
            "//ul[contains(@class, 'select2-results__options')]//div[contains(text(), '" + engine + "')]"))).click();
        // add count to check if there are more than one results fitting

    }

    public void handleSpecialOffersPopUp() {
        waitUntilVisibilityOfElement(specialOffersPopUp);
        waitUntilElementIsClickable(specialOffersPopUp.findElement(By.xpath("//button[2]"))).click();
    }
}