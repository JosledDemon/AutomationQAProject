package tests;

import base.BaseTest;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {

    @Test
    public void flujoCheckout() {

        // 🔹 Agregar producto
        ProductPage product = new ProductPage(driver);
        product.agregarProducto();

        // 🔥 FIX: manejar modal "View Cart" (ANTI-ANUNCIOS)
        By btnViewCart = By.xpath("//u[contains(text(),'View Cart')]");
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(btnViewCart));

        // Scroll para evitar overlays
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boton);

        try {
            boton.click();
        } catch (ElementClickInterceptedException e) {
            // 🔥 Si un anuncio bloquea → click con JS
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", boton);
        }

        // 🔹 Ir al carrito
        CartPage cart = new CartPage(driver);
        cart.irCarrito();

        // 🔹 Checkout
        CheckoutPage checkout = new CheckoutPage(driver, wait);
        checkout.realizarCheckout();
    }
}