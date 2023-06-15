package org.saucedemo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            System.out.println(" Waiting ...");
        }
    }
}
