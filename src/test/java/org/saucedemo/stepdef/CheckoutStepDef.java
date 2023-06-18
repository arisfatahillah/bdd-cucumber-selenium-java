package org.saucedemo.stepdef;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.saucedemo.pages.CheckoutPage;

public class CheckoutStepDef {
    protected WebDriver driver;
    private CheckoutPage checkoutPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am login to saucedemo website")
    public void login_saucedemo() {
        driver.get("https://www.saucedemo.com/");
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("I have fill username {string} and password {string}")
    public void login_using_credentials(String username, String password) {
        checkoutPage.login(username, password);
    }

    @When("I click on the {string} button")
    public void click_button_name(String buttonName) {
        checkoutPage.clickButton(buttonName);
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(checkoutPage.checkIDElementExist("shopping_cart_link"), true);
    }

    @When("User sorting price based on {string} value")
    public void sorting_price_using_type(String sortType) {
        checkoutPage.sortingPriceType(sortType);
    }

    @When("I sorting price based on {string} option")
    public void sorting_price(String sortType) {
        checkoutPage.sortingPrice(sortType);
    }

    @And("I get price list from product")
    public void get_price() {
        checkoutPage.getPriceAndProductName();
    }

    @And("I get highest product price list after sorting")
    public void get_price_sort() {
        checkoutPage.sortPriceHilo();
    }

    @When("I click on the {string} link")
    public void click_link_name(String linkName) {
        checkoutPage.clickLink(linkName);
    }

    @When("I click first cart button on product list")
    public void click_first_button() {
        checkoutPage.clickFirstCardButton();
    }

    @When("I fill textfield {string} with value {string}")
    public void fill_field_name_with_value(String fieldName, String value) {
        checkoutPage.enterFieldWithValue(fieldName, value);
    }

    @And("validate product name with highest price on checkout page")
    public void validate_highest_price() {
        Assert.assertEquals(checkoutPage.validateHighestPriceAndProductName(), true);
    }

    @And("I validate text {string} exist on page")
    public void validate_text_exist(String textName) {
        Assert.assertTrue(checkoutPage.isTextPresent(textName));
    }

}
