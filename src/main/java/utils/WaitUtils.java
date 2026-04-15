package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForElement(WebDriver driver, WebDriverWait wait, By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}