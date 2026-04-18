package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By email = By.xpath("//input[@data-qa='login-email']");
    By password = By.xpath("//input[@data-qa='login-password']");
    By btnLogin = By.xpath("//button[@data-qa='login-button']");
    By error = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");
    By loggedUser = By.xpath("//*[contains(text(),'Logged in as')]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String user, String pass) {

        WaitUtils.waitForElement(driver, wait, email);

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(btnLogin));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boton);

        boton.click();
    }

    // ✅ NUEVO METODO CLAVE //
    public boolean isLoggedIn() {
        try {
            return wait.until(driver ->
                    driver.getPageSource().contains("Logged in as")
            );
        } catch (Exception e) {
            return false;
        }
    }

    public String getError() {
        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(error)
        );
        return errorMsg.getText();
    }
}