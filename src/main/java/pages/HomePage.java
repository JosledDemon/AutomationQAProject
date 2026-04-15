package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By btnLogin = By.xpath("//a[@href='/login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void irLogin() {
        driver.findElement(btnLogin).click();
    }

    public void irSignup() {
    }
}