package tests;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import org.testng.annotations.*;
import utils.TestData;
import utils.TestListener;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    @Test
    public void registrarUsuario() {

        HomePage home = new HomePage(driver);
        home.irLogin();

        RegisterPage register = new RegisterPage(driver, wait);

        TestData.email = "user" + System.currentTimeMillis() + "@test.com";

        System.out.println("Email generado: " + TestData.email);

        register.registrar("Josled", TestData.email);

    }
}