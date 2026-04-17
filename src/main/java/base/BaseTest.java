package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("edge")) {

            // 🔥 BONUS: ruta dinámica (portable)
            String path = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
            System.setProperty("webdriver.edge.driver", path);

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");

            driver = new EdgeDriver(options);

        } else {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-blink-features=AutomationControlled");


            driver = new ChromeDriver(options);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://automationexercise.com/");

        // 🔥 NUEVO: limpiar anuncios automáticamente
        eliminarPublicidad();
    }

    // 🔥 REEMPLAZA TU MÉTODO eliminarPublicidad POR ESTE
    public void eliminarPublicidad() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "document.querySelectorAll('iframe, .adsbygoogle, .advertisement, #google_vignette').forEach(el => el.remove());"
            );

            // 🔥 SI IGUAL REDIRIGE
            if (driver.getCurrentUrl().contains("google_vignette")) {
                driver.navigate().to("https://automationexercise.com/");
            }

        } catch (Exception e) {
            // ignorar
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}