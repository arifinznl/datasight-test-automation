package api.stepdef;

import api.pages.UserApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class UserApiSteps {
    UserApi userApi = new UserApi();
    Response response;
    String userId;

    @When("Create user with email {string} firstname {string} lastname {string}")
    public void createUserWithEmailFirstnameLastname(String email, String first, String last) {
        //Email dinamis
        String uniqueEmail = email.replace("@",System.currentTimeMillis() + "@");
        response = userApi.createUser(uniqueEmail, first, last);

        userId = response.jsonPath().getString("id");
    }

    @Then("Response status code should be {int}")
    public void responseStatusCodeShouldBe(int code) {
        assertEquals(code, response.statusCode());
    }

    @When("Get that user")
    public void getThatUser() {
        response = userApi.getUser(userId);
    }

    @When("Update user firstname to {string}")
    public void updateUserFirstnameTo(String newName) {
        response = userApi.updateUser(userId, newName);
    }

    @When("Delete the user")
    public void deleteTheUser() {
        response = userApi.deleteUser(userId);
    }
}
