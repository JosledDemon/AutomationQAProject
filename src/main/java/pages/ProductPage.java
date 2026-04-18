package pages;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By btnProducts = By.xpath("//a[@href='/products']");
    By addToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    // 🔥 NUEVOS
    By addToCartList = By.xpath("//a[contains(text(),'Add to cart')]");
    By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔥 MÉTODO PARA EVITAR ANUNCIOS
    private void evitarPublicidad() {
        if (driver.getCurrentUrl().contains("google_vignette")) {
            driver.navigate().to("https://automationexercise.com/products");
        }
    }

    // 🔹 TU MÉTODO ORIGINAL (MEJORADO sin romper)
    public void agregarProducto() {

        driver.findElement(btnProducts).click();

        evitarPublicidad();

        try {
            wait.until(ExpectedConditions.urlContains("products"));
        } catch (Exception e) {
            driver.navigate().to("https://automationexercise.com/products");
        }

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        WebElement btn = wait.until(
                ExpectedConditions.presenceOfElementLocated(addToCart)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    // 🔥 METODO PRO ESTABLE


    public void agregarMultiplesProductos(int cantidad) {

        driver.get("https://automationexercise.com/products");

        wait.until(ExpectedConditions.urlContains("products"));

        for (int i = 0; i < cantidad; i++) {

            List<WebElement> productos = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(addToCartList)
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", productos.get(i)
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", productos.get(i));

            WebElement btnContinue = wait.until(
                    ExpectedConditions.elementToBeClickable(continueShopping)
            );

            btnContinue.click();

            // 🔥 ESTE ES EL FIX REAL
            wait.until(ExpectedConditions.invisibilityOfElementLocated(continueShopping));
        }
    }
}