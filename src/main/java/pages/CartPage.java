package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    WebDriver driver;

    By btnCart = By.xpath("//a[@href='/view_cart']");
    By btnCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    // 🔥 NUEVO
    By productosCarrito = By.xpath("//tr[contains(@id,'product')]");

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

    // 🔥 NUEVO MÉTODO
    public int obtenerCantidadProductos() {

        List<WebElement> cantidades = driver.findElements(
                By.xpath("//td[@class='cart_quantity']//button")
        );

        List<WebElement> nombres = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));

        for (WebElement nombre : nombres) {
            System.out.println("Producto: " + nombre.getText());
        }
        int total = 0;

        for (WebElement c : cantidades) {
            total += Integer.parseInt(c.getText());
        }

        System.out.println("Productos en carrito: " + total);

        return total;
    }
}