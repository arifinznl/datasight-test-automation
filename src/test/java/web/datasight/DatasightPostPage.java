package web.datasight;

import core.BaseWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatasightPostPage extends BaseWeb {

    // Sidebar indikator
    private final By mainMenuHeader = By.xpath("//h3[text()='Main Menu']");

    // Icon menu sidebar (hamburger)
    private final By menuIcon = By.xpath("//*[@data-testid='MenuIcon']");

    // Menu navigation
    private final By exploreDataMenu =
            By.xpath("//span[text()='Explore Data']/ancestor::div[contains(@class,'cursor-pointer')]");

    private final By postsManagementMenu =
            By.xpath("//a[@href='/explore-data/posts']//span[contains(text(),'Posts Management')]");

    // Form fields
    private final By titleField = By.xpath("//input[@placeholder='Input post title']");
    private final By englishTitleField = By.xpath("//input[@placeholder='Input english title (optional)']");
    private final By slugField = By.xpath("//input[@placeholder='Input slug name']");
    private final By addPostButton = By.xpath("//button[contains(text(),'Add New Post')]");

    // list post mengandung judul
    //private final String postTitleXpath = "//td[contains(text(),'New Energi')]";

    private final String postRowXpath = "//td[contains(text(),'%s')]";
    private final String deleteIconXpath = "//td[text()='%s']/following-sibling::td//*[name()='path' and @fill='#EF4444']";

    // tombol delete
    private By confirmDeleteBtn = By.xpath("//button[contains(text(),'Delete')]");

    // tombol ok popup
    private final By okButton = By.xpath("//button[normalize-space()='Ok']");


    private WebDriverWait w() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateToPostManagement() {
        WebDriverWait wait = w();

        boolean sidebarVisible = false;

        try {
            sidebarVisible = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(mainMenuHeader)
            ).isDisplayed();
        } catch (Exception ignored) {}

        if (!sidebarVisible) {
            WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(menuIcon));
            icon.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(mainMenuHeader));
        }

        // Explore Data ke Posts Management
        wait.until(ExpectedConditions.elementToBeClickable(exploreDataMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(postsManagementMenu)).click();
    }

    public void inputPostTitle(String title) {
        WebElement el = w().until(ExpectedConditions.visibilityOfElementLocated(titleField));
        el.clear();
        el.sendKeys(title);
    }

    public void inputEnglishTitle(String englishTitle) {
        WebElement el = w().until(ExpectedConditions.visibilityOfElementLocated(englishTitleField));
        el.clear();
        el.sendKeys(englishTitle);
    }

    public void inputSlug(String slug) {
        WebElement el = w().until(ExpectedConditions.visibilityOfElementLocated(slugField));
        el.clear();
        el.sendKeys(slug);
    }

    public void clickAddNewPost() {
        w().until(ExpectedConditions.elementToBeClickable(addPostButton)).click();
    }


    // validasi
    public boolean isPostCreated(String title) {
        try {
            w().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(postRowXpath, title))));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // delete post
    public void deletePost(String title) {
        WebDriverWait wait = w();

        String deleteXpath = String.format(deleteIconXpath, title);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteXpath))).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();

        // Wait sampai popup OK / success hilang
        try {
            wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        } catch (Exception ignored) {}
    }

    // memastikan post baru ada di list
    public boolean isPostVisible(String title) {
        try {
            driver.findElement(By.xpath(String.format(postRowXpath, title)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // memastikan berada di halaman post management
    public boolean isOnPostListPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Posts List')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
