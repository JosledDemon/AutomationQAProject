package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    By btnCart = By.xpath("//a[@href='/view_cart']");
    By btnCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void irCarrito() {
        WebElement btn = driver.findElement(btnCart);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void checkout() {
        driver.findElement(btnCheckout).click();
    }
}