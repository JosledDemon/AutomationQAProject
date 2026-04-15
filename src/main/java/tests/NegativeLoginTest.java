package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.*;
import org.testng.Assert;
import utils.TestListener;

@Listeners(TestListener.class)
public class NegativeLoginTest extends BaseTest {

    @Test
    public void loginFallido() {

        HomePage home = new HomePage(driver);
        home.irLogin();

        LoginPage login = new LoginPage(driver, wait);
        login.login("fake@test.com", "wrongpass");

        Assert.assertTrue(login.getError().contains("incorrect"));
    }
}