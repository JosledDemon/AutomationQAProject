package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    By name = By.name("name");
    By email = By.xpath("//input[@data-qa='signup-email']");
    By btnSignup = By.xpath("//button[@data-qa='signup-button']");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void registrar(String user, String mail) {

        // 🔹 Paso 1: Signup
        WaitUtils.waitForElement(driver, wait, name);

        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(user);

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(mail);

        WebElement botonSignup = wait.until(
                ExpectedConditions.elementToBeClickable(btnSignup)
        );

// 🔥 Scroll para evitar problemas de visibilidad
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonSignup);

// 🔥 Click seguro (anti anuncios iframe)
        try {
            botonSignup.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonSignup);
        }

        // 🔹 Paso 2: Esperar formulario completo
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("123456");

        new Select(driver.findElement(By.id("days"))).selectByValue("1");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("January");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");

        driver.findElement(By.id("first_name")).sendKeys("Test");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("address1")).sendKeys("Av Test 123");

        // 🔥 FIX IMPORTANTE
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");

        driver.findElement(By.id("state")).sendKeys("Test");
        driver.findElement(By.id("city")).sendKeys("Test");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("999999999");

        // 🔥 FIX BOTÓN
        By btnCreate = By.xpath("//button[@data-qa='create-account']");
        WebElement botonCreate = wait.until(ExpectedConditions.elementToBeClickable(btnCreate));

// 🔥 Scroll
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonCreate);

// 🔥 Click seguro (anti anuncios)
        try {
            botonCreate.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonCreate);
        }

        // 🔹 Paso 3: Validar creación
        By accountCreated = By.xpath("//b[contains(text(),'Account Created')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreated));

        // 🔹 Paso 4: Continue (con espera)
        By btnContinue = By.xpath("//a[@data-qa='continue-button']");
        wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    }
}