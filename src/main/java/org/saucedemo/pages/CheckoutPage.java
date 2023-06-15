package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver driver;

    private By sortIcon = By.className("product_sort_container");
    private By itemPrice = By.className("inventory_item_price");

    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
    }

    public void sortingPrice(String sortingType) {
        Select se = new Select(driver.findElement(sortIcon));
        se.selectByValue(sortingType);
    }

}
