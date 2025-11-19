package support;

import core.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {
    public static void attachScreenshot(String name) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver == null) return;

        try {
            if (driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
            }
        } catch (Exception e) {
            // Tambah log ringan agar tidak menghentikan test
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
