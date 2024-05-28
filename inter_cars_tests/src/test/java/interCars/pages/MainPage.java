package interCars.pages;

import interCars.TestData;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends PageObject {


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void getMainPage() {
        driver.get(Paths.get(TestData.MAIN_PAGE_URL).toString());
    }

    public void handleSpecialOffersPopUp() {
        waitUntilVisibilityOfElement(specialOffersPopUp);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='salesmanago-consent-form-title']"));
        driver.switchTo().frame(iframe);
        waitUntilElementIsClickable(driver.findElement(By.xpath("//button[2]"))).click();
        driver.switchTo().defaultContent();
    }
}