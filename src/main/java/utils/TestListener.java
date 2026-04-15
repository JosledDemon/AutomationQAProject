package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        Object currentClass = result.getInstance();
        WebDriver driver = ((base.BaseTest) currentClass).driver;

        String path = ScreenshotUtils.takeScreenshot(driver, result.getName());

        if (path != null) {
            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}