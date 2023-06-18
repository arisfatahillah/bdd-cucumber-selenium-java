package org.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {
    private WebDriver driver;

    HashMap<String, Float> priceProduct = new HashMap<String, Float>();

    HashMap<String, Float> priceProductSorted = new HashMap<String, Float>();

    // Element locator from login page
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    private By sortIcon = By.className("product_sort_container");
    private By itemPrice = By.className("inventory_item_price");

    private By firstCartButton = By.xpath(("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));


    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.sendKeys(password);
    }

    public void clickButton(String buttonName) {
        delay(1000);
        WebElement buttonTextName = driver.findElement(By.name(buttonName));
        buttonTextName.click();
    }

    public void clickLink(String linkName) {
        WebElement linkTextName = driver.findElement(By.className(linkName));
        linkTextName.click();
    }

    public void login(String username, String password) {
        delay(1000);
        enterUsername(username);
        enterPassword(password);
    }

    public boolean checkIDElementExist(String IDName){
        delay(2000);
        return driver.findElement(By.className(IDName)).isDisplayed();
    }

    public void sortingPriceType(String sortType) {
        delay(2000);
        driver.findElement(By.className("product_sort_container")).isDisplayed();
        Select se = new Select(driver.findElement(sortIcon));
        se.selectByValue(sortType);
        delay(3000);
    }

    public void getPrice() {
        List<WebElement> price = driver.findElements(By.cssSelector(".inventory_item_price"));
        List<String> prices = new ArrayList<String>();
        for (WebElement e : price)
        {
            prices.add(e.getText());
        }

        for(int i = 0; i < prices.size(); i++)
        {
            System.out.println(prices.get(i));
        }
    }

    public void getPriceAndProductName() {
        List<WebElement> price = driver.findElements(By.cssSelector(".inventory_item_price"));
        List<WebElement> productName = driver.findElements(By.cssSelector(".inventory_item_name"));
        int priceSize = price.size();
        int productNameSize = productName.size();

        List<String> prices = new ArrayList<String>();
        for (WebElement e : price)
        {
            prices.add(e.getText().replace("$", ""));
        }

        List<String> productNames = new ArrayList<String>();
        for (WebElement e : productName)
        {
            productNames.add(e.getText());
        }

        if (priceSize != productNameSize) {
            throw new IllegalArgumentException("The number of keys doesn't match the number of values.");
        }

        for (int i=0; i <priceSize; i++) {
            priceProduct.put(productNames.get(i), Float.valueOf(prices.get(i)));
        }

        System.out.println("====================================");
        System.out.println("Before sort");
        System.out.println(priceProduct);
        System.out.println("====================================");
    }

    public void sortPriceHilo() {
        priceProductSorted = sortByValue(priceProduct);
        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("After sort");
        System.out.println(priceProductSorted);
        System.out.println("====================================");
    }

    public void clickFirstCardButton() {
        WebElement firstButton = driver.findElement(firstCartButton);
        firstButton.click();
    }

    public void enterFieldWithValue(String fieldName, String value) {
        WebElement fieldInputName = driver.findElement(By.name(fieldName));
        fieldInputName.sendKeys(value);
        delay(1000);
    }

    public boolean validateHighestPriceAndProductName()
    {
        // get text Product name on checkout page
        WebElement e = driver.findElement(By.className("inventory_item_name"));
        String productNameOnCOPage = e.getText();

        // get text Product name on checkout page
        WebElement f = driver.findElement(By.className("inventory_item_price"));
        String productPriceOnCOPage = f.getText().replace("$", "");

        System.out.println("Product Name on checkout page : " +productNameOnCOPage);

        Map.Entry<String,Float> highestProductName = null;

        highestProductName = priceProductSorted.entrySet().stream().reduce((first,second) -> second).get();
        String highestPrice = String.valueOf(highestProductName.getValue());
        String highestProduct = highestProductName.getKey();

        // to get first entry on hashmap (lowest price)
        // Map.Entry<String, Float> firstEntry = priceProductSorted.entrySet().iterator().next();

        System.out.println("Product Name on hashmap : " +highestProduct);

        // compare product and price from checkout page
        if(productNameOnCOPage.equals(highestProduct) && productPriceOnCOPage.equals(highestPrice))
            return true;
        else
            return false;
    }

    public boolean isTextPresent(String text){
        delay(1000);
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }

    public void sortingPrice(String sortType)
    {
        delay(2000);
        WebElement sortButton = driver.findElement(sortIcon);
        sortButton.isDisplayed();
        Select se = new Select(sortButton);
        se.selectByValue(sortType);
        delay(3000);
    }
}
