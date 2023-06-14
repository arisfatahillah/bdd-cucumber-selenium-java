package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Element locator from login page
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
    }

    public void clickButton(String buttonName) {
        WebElement buttonTextName = driver.findElement(By.linkText(buttonName));
        buttonTextName.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    public boolean checkIDElementExist(String IDName){
        return driver.findElement(By.id(IDName)).isDisplayed();
    }
}
