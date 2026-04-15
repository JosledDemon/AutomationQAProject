package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By btnCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void realizarCheckout() {

        // 🔥 Esperar que la página cargue correctamente
        wait.until(ExpectedConditions.presenceOfElementLocated(btnCheckout));

        WebElement boton = wait.until(
                ExpectedConditions.elementToBeClickable(btnCheckout)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boton);

        try {
            boton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", boton);
        }
    }
}