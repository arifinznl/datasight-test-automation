package web.datasight;

import org.junit.Assert;
import org.openqa.selenium.By;
import core.BaseWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DatasightLoginPage extends BaseWeb {
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By serverErrorMessage = By.cssSelector(".text-red-700");


    public void openLoginPage() {
        driver.get("https://dashboard.datasight-pyc.org/");
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        WebElement emailInput = driver.findElement(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement passInput = driver.findElement(passwordField);
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public String getEmailValidationMessage() {
        return driver.findElement(emailField).getAttribute("validationMessage");
    }

    // validation — password
    public String getPasswordValidationMessage() {
        return driver.findElement(passwordField).getAttribute("validationMessage");
    }

    public boolean isEmailFieldInvalid() {
        return !getEmailValidationMessage().isEmpty();
    }

    public boolean isPasswordFieldInvalid() {
        return !getPasswordValidationMessage().isEmpty();
    }

    // cek error muncul
    public boolean isServerErrorVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(serverErrorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // mengambil teks errornya
    public String getServerErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(serverErrorMessage))
                    .getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public void validateErrorAppear(String errorMessage) {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(serverErrorMessage));
            Assert.assertTrue("Error message tidak sesuai. Actual: " + error.getText(),
                    error.getText().trim().equalsIgnoreCase(errorMessage));
        } catch (Exception e) {
            Assert.fail("Error message tidak muncul: " + errorMessage);
        }
    }

//    private final By emailField = By.cssSelector("input[type='email']");
//    private final By passwordField = By.cssSelector("input[type='password']");
//    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");
//
//    public void enterEmail(String email) {
//        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//        emailInput.sendKeys(email);
//    }
//
//    public void enterPassword(String password) {
//        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
//        passInput.sendKeys(password);
//    }
//
//    public void clickLogin() {
//        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//        btn.click();
//    }
}
