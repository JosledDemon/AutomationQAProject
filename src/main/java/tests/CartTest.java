package tests;

import base.BaseTest;
import pages.ProductPage;
import pages.CartPage;
import org.testng.annotations.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    @Test
    public void agregarAlCarrito() {

        ProductPage product = new ProductPage(driver);
        product.agregarProducto();

        CartPage cart = new CartPage(driver);
        cart.irCarrito();
    }
}