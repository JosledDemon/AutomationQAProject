package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    WebDriver driver;

    By btnProducts = By.xpath("//a[@href='/products']");
    By addToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void agregarProducto() {
        driver.findElement(btnProducts).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        WebElement btn = driver.findElement(addToCart);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }
}