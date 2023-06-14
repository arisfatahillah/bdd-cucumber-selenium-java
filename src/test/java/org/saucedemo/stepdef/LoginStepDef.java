package org.saucedemo.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.saucedemo.pages.LoginPage;

public class LoginStepDef {
    private WebDriver driver;
    private LoginPage loginPage;

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
        loginPage = new LoginPage(driver);
    }

    @Given("I have fill username {string} and password {string}")
    public void login_using_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I click on the {string} button")
    public void click_button_name(String buttonName) {
       loginPage.clickButton(buttonName);
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkIDElementExist("shopping_cart_container"), true);
    }
}
