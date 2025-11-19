package web.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import web.datasight.DatasightHomePage;
import web.datasight.DatasightLoginPage;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    DatasightLoginPage loginPage = new DatasightLoginPage();
    DatasightHomePage homePage = new DatasightHomePage();

    @Given("User is on Datasight dashboard login page")
    public void userIsOnDatasightDashboardLoginPage() {
        loginPage.openLoginPage();
    }

    @When("User input dashboard email {string}")
    public void userInputDashboardEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("User input dashboard password {string}")
    public void userInputDashboardPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("User click dashboard login button")
    public void userClickDashboardLoginButton() {
        loginPage.clickLogin();
    }

    // ASSERTIONS
    @Then("User should be redirected to Datasight dashboard homepage")
    public void userShouldBeRedirectedToDatasightDashboardHomepage() {
        Assert.assertTrue(
                "Login gagal, header Users pada halaman dashboard tidak ditemukan",
                homePage.isLoginSuccessful()
        );
    }

    @Then("Email field should show invalid email message")
    public void emailFieldShouldShowInvalidEmailMessage() {
        Assert.assertTrue("Email field seharusnya invalid",
                loginPage.isEmailFieldInvalid());
    }

    @Then("Password field should show required field message")
    public void passwordFieldShouldShowRequiredFieldMessage() {
        Assert.assertTrue("Password field seharusnya invalid",
                loginPage.isPasswordFieldInvalid());
        
    }

    @Then("Error message should appear for {string}")
    public void errorMessageShouldAppearFor(String errorMessage) {
        loginPage.validateErrorAppear(errorMessage);
    }
}
