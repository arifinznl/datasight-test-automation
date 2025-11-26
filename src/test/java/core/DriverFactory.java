package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    // Headless
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        //  headless github
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-tools");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();

        System.out.println("Chrome started in ALWAYS-HEADLESS mode.");
    }

    // Run Lokal
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void initDriver(String browser) {
//        WebDriver webDriver;
//
//        switch (browser.toLowerCase()) {
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                webDriver = new FirefoxDriver();
//                break;
//
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                webDriver = new EdgeDriver();
//                break;
//
//            case "chrome":
//            default:
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//
//                // Membuka Chrome dengan size full
//                options.addArguments("--start-maximized");
//
//                webDriver = new ChromeDriver(options);
//        }
//
//        driver.set(webDriver);
//    }

    public static void quitDriver() {
        // Headless
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        // Lokal Chrome
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//        }
    }
}
