package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.RegisterPage;
import utils.TestData;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginCorrecto() {

        HomePage home = new HomePage(driver);

        // 🔥 EMAIL ÚNICO (CLAVE)
        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "123456";

        // 🔥 REGISTRO
        home.irLogin(); // ESTA es la pantalla correcta

        RegisterPage register = new RegisterPage(driver, wait);
        register.registrar("TestUser", email);

        // 🔥 LOGOUT (IMPORTANTE)
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        // 🔥 LOGIN
        home.irLogin();

        LoginPage login = new LoginPage(driver, wait);
        login.login(email, password);

        // 🔥 VALIDACIÓN REAL
        Assert.assertTrue(login.isLoggedIn(), "El login falló");
    }
}