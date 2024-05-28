package interCars;

import interCars.pages.AddedToBasketPopUp;
import interCars.pages.CartPage;
import interCars.pages.CategoriesPage;
import interCars.pages.MainPage;
import interCars.pages.OffersListPage;
import interCars.pages.PageObject;
import interCars.pages.ProductPage;
import interCars.pages.SelectCarView;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {

    public WebDriver driver;
    public PageObject pageObject;
    public MainPage mainPage;
    public SelectCarView selectCarView;
    public CategoriesPage categoriesPage;
    public OffersListPage offersListPage;
    public ProductPage productPage;
    public AddedToBasketPopUp addedToBasketPopUp;
    public CartPage cartPage;
    String productIndex;

    public StepDefinitions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        pageObject = new PageObject(driver);
        mainPage = new MainPage(driver);
        selectCarView = new SelectCarView(driver);
        categoriesPage = new CategoriesPage(driver);
        offersListPage = new OffersListPage(driver);
        productPage = new ProductPage(driver);
        addedToBasketPopUp = new AddedToBasketPopUp(driver);
        cartPage = new CartPage(driver);
    }

    @Given("user selected the car {string},{string},{string}")
    public void selectCar(String make, String model, String engine) {
        selectCarView.selectTheCar(make, model, engine);
    }

    @And("user opened the wheels and tyres category")
    public void selectWheelsTyresCategory() {
        categoriesPage.selectWheelsTyresCategory();
    }

    @And("user picked the first offer from the list")
    public void pickFirstOfferFromTheList() {
        offersListPage.sortByHighestAvailability();
        offersListPage.selectFirstOffer();
    }

    @And("user added 4 products to the cart")
    public void addProductsToCart() {
        productIndex = productPage.waitUntilVisibilityOfElement(productPage.productIndex).getText();
        productPage.provideItemsCount("4");
        productPage.waitUntilElementIsClickable(productPage.addToBasketButton).click();
    }

    @And("user navigated to the cart")
    public void navigateToCart() {
        addedToBasketPopUp.waitUntilElementIsClickable(addedToBasketPopUp.goToBasketButton).click();
    }

    @And("cart contains correct products")
    public void verifyCartContainsCorrectProducts() {
        String productTitleInCart = cartPage.waitUntilVisibilityOfElement(cartPage.productDescription).getText();
        assert (productTitleInCart).contains(productIndex);
    }

    @When("user removes product from the cart")
    public void removeProductFromCart() {
        cartPage.waitUntilElementIsClickable(cartPage.trashButton).click();
    }

    @Then("cart is empty")
    public void verifyCartIsEmpty() {
        cartPage.verifyCartIsEmpty();
    }

    @Before
    public void beforeScenario() {
        mainPage.getMainPage();
        mainPage.acceptCookies();
        mainPage.handleSpecialOffersPopUp();
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
