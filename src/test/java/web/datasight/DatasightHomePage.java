package web.datasight;

import org.openqa.selenium.By;
import core.BaseWeb;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DatasightHomePage extends BaseWeb {

    private final By usersHeader = By.xpath("//h1[normalize-space()='Users']");

    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersHeader));
        return driver.findElements(usersHeader).size() > 0;
    }
//    // Tombol Login sebelum login
//    private final By loginButton = By.cssSelector("a[href='/en/login']");
//
//    // Avatar setelah login
//    private final By avatarAfterLogin = By.cssSelector("div.MuiAvatar-root");
//
//    // Teks AR (post login)
//    private final By avatarText = By.xpath("//div[contains(@class,'MuiAvatar-root') and text()='AR']");
//
//    public void openHomePage() {
//        driver.get("https://datasight-pyc.org/");
//    }
//
//    public void clickLoginButton() {
//        // Tunggu sampai tombol Login benar-benar bisa diklik
//        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//        btn.click();
//    }
//
//    // Login dianggap berhasil jika Avatar muncul dan teks AR tampil
//    public boolean isLoginSuccessful() {
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(avatarText));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
