package tests;

import base.BaseTest;
import pages.ProductPage;
import pages.CartPage;
import org.testng.Assert;
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

    // 🔥 NUEVO TEST PRO (MEJORADO)
    @Test
    public void agregarVariosProductosAlCarrito() {

        ProductPage product = new ProductPage(driver);
        product.agregarMultiplesProductos(3);

        CartPage cart = new CartPage(driver);
        cart.irCarrito();

        // 🔥 ESPERA PARA EVITAR FALSO NEGATIVO
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int cantidadReal = cart.obtenerCantidadProductos();

        // 🔥 DEBUG (MUY IMPORTANTE PARA QA REAL)
        System.out.println("Productos en carrito: " + cantidadReal);

        Assert.assertEquals(cantidadReal, 3,
                "No se agregaron correctamente los productos");
    }
}